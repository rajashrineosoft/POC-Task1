package com.neosoft.poc.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
@Getter
@Setter
@ToString
@Entity
@Table(name="student")
public class Student {
	
	public Student()
	{
		
	}
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="student_id")
private int studentId;

@NotEmpty(message="First name must be not empty")
@Column(name="firstname")
private	String firstName;

@NotEmpty(message="Last name must be not empty")
@Column(name="lastname")
private String lastName;

@NotEmpty
@Size(min=10,max=10,message="mobile number must be not empty")
@Column(name="mobile_number")
private String mobileNumber;

@NotEmpty
@Email(message = "Email address is not valid")
@Column(name = "email_id")
private String email;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="fk_student_id",referencedColumnName="student_id")
private Set<Project> project;




}
