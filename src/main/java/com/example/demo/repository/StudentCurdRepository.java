package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;
import com.example.demo.model.User;

@Repository
public interface StudentCurdRepository extends CrudRepository <Student, Long> {

	List<Student> findByName(String name); 
	
}
