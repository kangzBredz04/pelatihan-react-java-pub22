package com.projectmanagementsystem.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagementsystem.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFullNameContainingIgnoreCase(String fullName);

    List<Employee> findAllByOrderByFullNameAsc();

    List<Employee> findAllByOrderByFullNameDesc();
}
