package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class SpringBootThymleaf19April20Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymleaf19April20Application.class, args);
	}

	@Autowired
	UserRepository userRepository;
	
	@PostConstruct
	public void createUser()
	{
		userRepository.save(new User("Sawnil", "Rmaesha@123", "Sawnil@example.com", 15000.00, "19-Jan-1999"));
		userRepository.save(new User("Kiran", "Rmaesha@123", "Kiran@example.com", 13000.00, "19-May-1989"));
		userRepository.save(new User("Raju", "Rmaesha@123", "Raju@example.com", 16000.00, "19-Nov-1987"));
		userRepository.save(new User("Manish", "Rmaesha@123", "Manish@example.com", 17000.00, "19-Oct-1988"));
		userRepository.save(new User("Chandani", "Chandani@123", "Chandani@example.com", 15600.00, "19-Sep-1994"));
		
	}
	
	
}
