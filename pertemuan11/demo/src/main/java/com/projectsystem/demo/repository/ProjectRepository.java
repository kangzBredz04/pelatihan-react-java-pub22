package com.projectsystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsystem.demo.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
