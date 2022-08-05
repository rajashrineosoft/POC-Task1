package com.neosoft.poc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.poc.model.Student;

@Repository
public interface ProjectRepository extends JpaRepository<Student,Integer>{

}
