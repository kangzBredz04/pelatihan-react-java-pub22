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

import com.projectmanagementsystem.demo.model.Project;
import com.projectmanagementsystem.demo.model.Task;
import com.projectmanagementsystem.demo.repository.ProjectRepository;
import com.projectmanagementsystem.demo.repository.TaskRepository;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        Project project = projectRepository.findById(task.getProject().getId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        task.setName(task.getName());
        task.setStatus(task.getStatus());
        task.setProject(project);
        return taskRepository.save(task);
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        Project project = projectRepository.findById(task.getProject().getId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        existingTask.setName(task.getName());
        existingTask.setStatus(task.getStatus());
        existingTask.setProject(project);
        return taskRepository.save(existingTask);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
