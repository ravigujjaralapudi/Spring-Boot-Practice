package com.example.springboot.demo.dao;

import java.util.List;

import com.example.springboot.demo.entity.Student;

public interface StudentDAO {
	
	public List<Student> findAll();

	public void save(Student theStudent);
	
	public Student findById(int id);
	
	public String deleteById(int id);
}
