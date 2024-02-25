package com.demo.springapp.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class Script {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "script_uuid")
	@Type(type = "uuid-char")
    private UUID scriptUuid;

	@Column(name = "script_name")
    private String scriptName;

	@Column(name = "script_tag")
    private String scriptTag;

    @Column(name = "script_created")
    private LocalDateTime scriptCreated = LocalDateTime.now();

    @ManyToOne // Many-to-One mapping with Module
    @JoinColumn(name = "module_uuid")
    private Module module;

	public UUID getScriptUuid() {
		return scriptUuid;
	}

	public void setScriptUuid(UUID scriptUuid) {
		this.scriptUuid = scriptUuid;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public String getScriptTag() {
		return scriptTag;
	}

	public void setScriptTag(String scriptTag) {
		this.scriptTag = scriptTag;
	}

	public LocalDateTime getScriptCreated() {
		return scriptCreated;
	}

	public void setScriptCreated(LocalDateTime scriptCreated) {
		this.scriptCreated = scriptCreated;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "Script [scriptUuid=" + scriptUuid + ", scriptName=" + scriptName + ", scriptTag=" + scriptTag
				+ ", scriptCreated=" + scriptCreated + ", module=" + module + "]";
	}

    
}