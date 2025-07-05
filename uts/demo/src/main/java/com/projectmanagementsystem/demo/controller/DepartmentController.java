package com.projectmanagementsystem.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagementsystem.demo.model.Company;
import com.projectmanagementsystem.demo.model.Department;
import com.projectmanagementsystem.demo.repository.CompanyRepository;
import com.projectmanagementsystem.demo.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department) {
        Company company = companyRepository.findById(department.getCompany().getId())
                .orElseThrow(() -> new RuntimeException("Company not found"));
        department.setName(department.getName());
        department.setCompany(company);
        return departmentRepository.save(department);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        Company company = companyRepository.findById(department.getCompany().getId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        existingDepartment.setName(department.getName());
        existingDepartment.setCompany(company);
        return departmentRepository.save(existingDepartment);
    }

    @PostMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }
}
