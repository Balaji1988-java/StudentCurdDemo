package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String pass;
	private String email;
	private Double salary;
	private String dateOfBirth;
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/**
	 * @param name
	 * @param pass
	 * @param email
	 * @param salary
	 * @param dateOfBirth
	 */
	public User(String name, String pass, String email, Double salary, String dateOfBirth) {
		super();
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.salary = salary;
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * 
	 */
	public User() {}
	
	

}

