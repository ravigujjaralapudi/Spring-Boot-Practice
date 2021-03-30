package com.example.springboot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
