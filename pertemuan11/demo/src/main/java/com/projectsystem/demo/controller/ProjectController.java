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

import com.projectsystem.demo.model.Department;
import com.projectsystem.demo.model.Employee;
import com.projectsystem.demo.model.Project;
import com.projectsystem.demo.repository.DepartmentRepository;
import com.projectsystem.demo.repository.EmployeeRepository;
import com.projectsystem.demo.repository.ProjectRepository;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    @PostMapping("/save")
    public Project savProject(@RequestBody Project project) {
        Department department = departmentRepository.findById(project.getDepartment().getId())
                .orElseThrow(
                        () -> new RuntimeException("Department not found with id: " + project.getDepartment().getId()));
        Employee employee = employeeRepository.findById(project.getEmployee().getId())
                .orElseThrow(
                        () -> new RuntimeException("Employee not found with id: " + project.getEmployee().getId()));
        project.setDepartment(department);
        project.setEmployee(employee);
        return projectRepository.save(project);
    }

    @PutMapping("/update/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        Project projectSave = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));

        Department department = departmentRepository.findById(project.getDepartment().getId())
                .orElseThrow(
                        () -> new RuntimeException("Department not found with id: " + project.getDepartment().getId()));
        Employee employee = employeeRepository.findById(project.getEmployee().getId())
                .orElseThrow(
                        () -> new RuntimeException("Employee not found with id: " + project.getEmployee().getId()));

        projectSave.setTitle(project.getTitle());
        projectSave.setDepartment(department);
        projectSave.setEmployee(employee);

        return projectRepository.save(project);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found with id: " + id);
        }
        projectRepository.deleteById(id);
    }
}
