package com.demo.springapp.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.demo.springapp.enumeration.ModuleColor;

@Entity
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "module_uuid")
	@Type(type = "uuid-char")
    private UUID moduleUuid;

	@Column(name = "module_key")
    private String moduleKey;

	@Column(name = "module_description")
    private String moduleDescription;

    @Column(name = "module_created")
    private LocalDateTime moduleCreated = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private ModuleColor color;

    @ManyToOne // Many-to-One mapping with Project
    @JoinColumn(name = "project_uuid")
    private Project project;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL) // One-to-Many mapping with Script
    private List<Script> scripts = new ArrayList<>();

	public UUID getModuleUuid() {
		return moduleUuid;
	}

	public void setModuleUuid(UUID moduleUuid) {
		this.moduleUuid = moduleUuid;
	}

	public String getModuleKey() {
		return moduleKey;
	}

	public void setModuleKey(String moduleKey) {
		this.moduleKey = moduleKey;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public LocalDateTime getModuleCreated() {
		return moduleCreated;
	}

	public void setModuleCreated(LocalDateTime moduleCreated) {
		this.moduleCreated = moduleCreated;
	}

	public ModuleColor getColor() {
		return color;
	}

	public void setColor(ModuleColor color) {
		this.color = color;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Script> getScripts() {
		return scripts;
	}

	public void setScripts(List<Script> scripts) {
		this.scripts = scripts;
	}

	@Override
	public String toString() {
		return "Module [moduleUuid=" + moduleUuid + ", moduleKey=" + moduleKey + ", moduleDescription="
				+ moduleDescription + ", moduleCreated=" + moduleCreated + ", color=" + color + ", project=" + project
				+ ", scripts=" + scripts + "]";
	}

    
}