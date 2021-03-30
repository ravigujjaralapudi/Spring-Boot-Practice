package com.example.springboot.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.demo.entity.Student;
import com.example.springboot.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/welcome")
	public String getWelomceMessage() {
		return "Welcome to the Spring Boot - Practice";
	}
	
	@GetMapping("/students")
	public List<Student> findAllStudents(){
		return studentService.findAll();
	}
	
	@PostMapping("/student")
	public void addStudent(@RequestBody Student theStudent) {
		studentService.save(theStudent);
	}
	
	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable int id) {
		return studentService.findById(id);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudentById(@PathVariable int id) {
		return studentService.deleteById(id);
	}

}
