package com.neosoft.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@Entity
@Table(name="project")
public class Project  {
	
	public Project()
	{
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_id")
	private int projectId;
	
	@NotEmpty(message="Project name should not be empty")
	@Column(name="project_name")
	private	String projectName;
	
	@NotEmpty(message="Project duration should not be empty")
	@Column(name="project_duration")
	private String projectDuration;
	
 //@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
 // private Student student;
	
	
}
