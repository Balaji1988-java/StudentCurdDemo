package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentCurdRepository;

@Service
public class StudentService 
{

@Autowired
StudentCurdRepository curdRepository;

public Student getStudentById(Long id) throws Exception 
{
    Optional<Student> stu = curdRepository.findById(id);
     
    if(stu.isPresent()) {
        return stu.get();
    } else {
        throw new Exception("No employee record exist for given id");
    }
}
	
public void deleteStudentId(Long id) throws Exception 
{
    Optional<Student> employee = curdRepository.findById(id);
     
    if(employee.isPresent()) 
    {
    	curdRepository.deleteById(id);
    } else {
        throw new Exception("No employee record exist for given id");
    }
} 


}
