package com.projectmanagementsystem.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagementsystem.demo.model.Department;
import com.projectmanagementsystem.demo.model.Employee;
import com.projectmanagementsystem.demo.repository.DepartmentRepository;
import com.projectmanagementsystem.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        Department department = departmentRepository.findById(employee.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        employee.setFullName(employee.getFullName());
        employee.setRole(employee.getRole());
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Department department = departmentRepository.findById(employee.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existingEmployee.setFullName(employee.getFullName());
        existingEmployee.setRole(employee.getRole());
        existingEmployee.setDepartment(department);
        return employeeRepository.save(existingEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    @GetMapping("/search/{fullName}")
    public List<Employee> searchEmployeesByFullName(@PathVariable String fullName) {
        return employeeRepository.findByFullNameContainingIgnoreCase(fullName);
    }

    @GetMapping("/sort-asc")
    public List<Employee> sortEmployeesByFullNameAsc() {
        return employeeRepository.findAllByOrderByFullNameAsc();
    }

    @GetMapping("/sort-desc")
    public List<Employee> sortEmployeesByFullNameDesc() {
        return employeeRepository.findAllByOrderByFullNameDesc();
    }
}
