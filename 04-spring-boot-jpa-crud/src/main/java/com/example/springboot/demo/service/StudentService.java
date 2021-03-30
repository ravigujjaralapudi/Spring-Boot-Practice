package com.example.springboot.demo.service;

import java.util.List;

import com.example.springboot.demo.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public void save(Student theStudent);
	
	public Student findById(int id);
	
	public String deleteById(int id);
	
}
