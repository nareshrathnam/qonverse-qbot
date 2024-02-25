package com.demo.springapp.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_uuid")
	@Type(type = "uuid-char")
	private UUID projectUuid;
	
	@Column(name = "project_name")
	private String projectName;

	@Column(name = "project_description")
	private String projectDescription;

	@Column(name = "project_created", nullable = false, updatable = false)
	private LocalDateTime projectCreated = LocalDateTime.now();

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL) // One-to-Many mapping with Module
	private List<Module> modules = new ArrayList<>();

	public UUID getProjectUuid() {
		return projectUuid;
	}

	public void setProjectUuid(UUID projectUuid) {
		this.projectUuid = projectUuid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public LocalDateTime getProjectCreated() {
		return projectCreated;
	}

	public void setProjectCreated(LocalDateTime projectCreated) {
		this.projectCreated = projectCreated;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	@Override
	public String toString() {
		return "Project [projectUuid=" + projectUuid + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", projectCreated=" + projectCreated + ", modules=" + modules + "]";
	}

}