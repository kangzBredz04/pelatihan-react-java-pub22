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
import com.projectmanagementsystem.demo.model.Project;
import com.projectmanagementsystem.demo.repository.DepartmentRepository;
import com.projectmanagementsystem.demo.repository.ProjectRepository;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
        Department department = departmentRepository.findById(project.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        project.setTitle(project.getTitle());
        project.setDescription(project.getDescription());
        project.setDepartment(department);
        return projectRepository.save(project);
    }

    @PutMapping("/update/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        Department department = departmentRepository.findById(project.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existingProject.setTitle(project.getTitle());
        existingProject.setDescription(project.getDescription());
        existingProject.setDepartment(department);
        return projectRepository.save(existingProject);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
    }

    @GetMapping("/search/{title}")
    public List<Project> searchProjectsByTitle(@PathVariable String title) {
        return projectRepository.findByTitleContainingIgnoreCase(title);
    }

    @GetMapping("/sort-asc")
    public List<Project> sortProjectsByTitleAsc() {
        return projectRepository.findAllByOrderByTitleAsc();
    }

    @GetMapping("/sort-desc")
    public List<Project> sortProjectsByTitleDesc() {
        return projectRepository.findAllByOrderByTitleDesc();
    }
}
