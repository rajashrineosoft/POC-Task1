package com.example.demo.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="userdetails")

public class UserDetails implements Serializable{
	
	public UserDetails()
	{
		
	}
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private int id;
@NotEmpty(message="First name must be not empty")
@Column(name="firstname")
private	String firstName;
@NotEmpty(message="Last name must be not empty")
@Column(name="lastname")
private String lastName;
@NotNull
@Column(name="pincode")
private	int pinCode;
@NotNull
@Temporal(TemporalType.DATE)
Date dateOfBirth;
@NotNull
@Temporal(TemporalType.DATE)
Date joiningDate;

/* Generate Constructor */
public UserDetails(int id, String firstName, String lastName, int pinCode,Date dateOfBirth, Date joiningDate) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.pinCode = pinCode;
	this.dateOfBirth=dateOfBirth;
	this.joiningDate=joiningDate;
}

/* Generate Getter and Setter*/

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getPinCode() {
	return pinCode;
}
public void setPinCode(int pinCode) {
	this.pinCode = pinCode;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}

public Date getJoiningDate() {
	return joiningDate;
}

public void setJoiningDate(String joiningDate) throws ParseException {
	String pattern = "dd/MM/yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	this.joiningDate = simpleDateFormat.parse(joiningDate);;
}

public void setDateOfBirth(String dateOfBirth) throws ParseException {
	String pattern = "dd/MM/yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	this.dateOfBirth = simpleDateFormat.parse(dateOfBirth);
}
 /* Generate toString method*/
@Override
public String toString() {
	return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pinCode=" + pinCode
			+  "]";
}
	
	
}
