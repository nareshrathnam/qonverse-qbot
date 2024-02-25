package com.demo.springapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springapp.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

}
