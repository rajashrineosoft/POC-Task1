package com.neosoft.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.poc.model.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	public Student getByStudentId(int studentId);
}
