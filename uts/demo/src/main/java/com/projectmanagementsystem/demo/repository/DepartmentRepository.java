package com.projectmanagementsystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagementsystem.demo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
