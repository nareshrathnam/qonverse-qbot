package com.demo.springapp.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springapp.entity.Project;
import com.demo.springapp.repository.ProjectRepository;
import com.demo.springapp.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProjectById(UUID projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Project project) {
        Project existingProject = projectRepository.findById(project.getProjectUuid()).orElse(null);
        if (existingProject != null) {
            // Update relevant fields (e.g., projectName, projectDescription)
            existingProject.setProjectName(project.getProjectName());
            existingProject.setProjectDescription(project.getProjectDescription());
            return projectRepository.save(existingProject);
        }
        return null;
    }

    @Override
    public void deleteProjectById(UUID projectId) {
        projectRepository.deleteById(projectId);
    }
}
