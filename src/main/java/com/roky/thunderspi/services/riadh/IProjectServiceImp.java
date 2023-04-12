package com.roky.thunderspi.services.riadh;


import com.roky.thunderspi.entities.Project;
import com.roky.thunderspi.repositories.riadh.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.stream.Stream;

@Service
public class IProjectServiceImp implements IProjectService{
    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project p)
    {
        return projectRepository.save(p);
    }
    public Project updateProject(Project p)
    {
        Assert.notNull(projectRepository.findById(p.getId()));
        return projectRepository.save(p);
    }

    public void deleteProject(Long id)
    {
        projectRepository.deleteById(id);
    }

    public Project getProjectById(Long id)
    {
        return projectRepository.findById(id).get();
    }

    public Stream<Project> getAllProjects()
    {
        return projectRepository.findAll().stream();
    }


    public Stream<Project> getProjectsByTeacher(Long id){ return null;}

    @Override
    public Stream<Project> getProjectsByNumberOfNumberPassed() {
        return null;
    }

    @Override
    public Stream<Project> getProjectsByNumberOfEnrollments() {
        return null;
    }

    @Override
    public Stream<Project> getProjectsByCourse(Long courseId) {
        return null;
    }
}
