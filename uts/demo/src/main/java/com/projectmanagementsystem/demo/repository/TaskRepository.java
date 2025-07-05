package com.projectmanagementsystem.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagementsystem.demo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
