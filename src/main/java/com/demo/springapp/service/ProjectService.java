package com.demo.springapp.service;

import java.util.List;
import java.util.UUID;

import com.demo.springapp.entity.Project;

public interface ProjectService {

    Project createProject(Project project);

    Project getProjectById(UUID projectId);

    List<Project> getAllProjects();

    Project updateProject(Project project);

    void deleteProjectById(UUID projectId);


}
