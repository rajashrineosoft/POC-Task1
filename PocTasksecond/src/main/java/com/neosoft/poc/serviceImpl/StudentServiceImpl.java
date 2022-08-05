package com.neosoft.poc.serviceImpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neosoft.poc.model.Student;
import com.neosoft.poc.repository.StudentRepository;
import com.neosoft.poc.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	private StudentRepository studentRepository;
	//constructor for student Repository
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

// method for add new student into database
	@Override
	public Student addNewStudent(Student student) {
		
	return studentRepository.save(student);
	}

	// method for get all student data from database

	@Override
	public List<Student> getStudentData() {
		
	List<Student>students=studentRepository.findAll();
	return students;
	}

//method for find student by id
	@Override
	public Student findByStudentId(int studentId) {
		
	return studentRepository.getByStudentId(studentId);
	}


	


	

}
