package com.projectsystem.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsystem.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Searching
    List<Employee> findByNameContainingIgnoreCase(String name);

    // Sorting Descending (Terkecil ke Terbesar)
    List<Employee> findAllByOrderByNameAsc();

    // Sorting Descending (Terbesar ke Terkecil)
    List<Employee> findAllByOrderByNameDesc();
}
