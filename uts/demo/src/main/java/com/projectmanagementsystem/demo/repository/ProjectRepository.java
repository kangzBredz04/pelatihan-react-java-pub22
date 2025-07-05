package com.projectmanagementsystem.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagementsystem.demo.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByTitleContainingIgnoreCase(String title);

    List<Project> findAllByOrderByTitleAsc();

    List<Project> findAllByOrderByTitleDesc();
}
