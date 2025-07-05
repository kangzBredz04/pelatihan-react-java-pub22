package com.projectsystem.demo.controller;

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

import com.projectsystem.demo.model.Employee;
import com.projectsystem.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/search/{name}")
    public List<Employee> searchByName(@PathVariable String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/sort/asc")
    public List<Employee> sortByNameAsc() {
        return employeeRepository.findAllByOrderByNameAsc();
    }

    @GetMapping("/sort/desc")
    public List<Employee> sortByNameDesc() {
        return employeeRepository.findAllByOrderByNameDesc();
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee updated) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updated.getName());
            return employeeRepository.save(employee);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
