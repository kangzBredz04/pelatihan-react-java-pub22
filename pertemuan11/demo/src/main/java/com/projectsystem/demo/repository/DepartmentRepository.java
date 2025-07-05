package com.projectsystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsystem.demo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
