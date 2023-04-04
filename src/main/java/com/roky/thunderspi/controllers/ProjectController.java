package com.roky.thunderspi.controllers;


import com.roky.thunderspi.entities.Project;
import com.roky.thunderspi.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id)
    {
        return projectService.getProjectById(id);
    }

    @PostMapping
    public void addProject(@RequestParam Project p)
    {
        projectService.addProject(p);
    }

    @PutMapping
    public void updateProject(@RequestParam Project p)
    {
        projectService.updateProject(p);
    }

    @DeleteMapping
    public void deleteProject(@PathVariable Long id)
    {
        projectService.deleteProject(id);
    }

    @GetMapping("/teacher/{id}")
    public Set<Project> getProjectByTeacherId(@PathVariable Long id)
    {
        return projectService.getProjectsByTeacher(id).collect(Collectors.toSet());
    }

    @GetMapping
    public Set<Project> getAllProjects()
    {
        return projectService.getAllProjects().collect(Collectors.toSet());
    }

}
