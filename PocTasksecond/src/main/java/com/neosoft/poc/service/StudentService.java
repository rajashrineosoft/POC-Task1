package com.neosoft.poc.service;


import java.util.List;
import com.neosoft.poc.model.Student;



public interface StudentService {

	
	public Student addNewStudent(Student student);
	
	public List<Student> getStudentData(); 
	
	public Student findByStudentId(int studentId);
}
