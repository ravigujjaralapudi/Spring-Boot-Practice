package com.example.springboot.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.demo.entity.Student;
import com.example.springboot.demo.repo.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/welcome")
	public String getWelomceMessage() {
		return "Welcome to the Spring Boot - Practice";
	}

	@GetMapping("/students")
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}

	@PostMapping("/student")
	public void addStudent(@RequestBody Student theStudent) {
		studentRepository.save(theStudent);
	}

	@GetMapping("/student/{id}")
	public Optional<Student> findStudentById(@PathVariable int id) {				
			return studentRepository.findById(id);
	}

	@DeleteMapping("/student/{id}")
	public void deleteStudentById(@PathVariable int id) {
		studentRepository.deleteById(id);
	}

}
