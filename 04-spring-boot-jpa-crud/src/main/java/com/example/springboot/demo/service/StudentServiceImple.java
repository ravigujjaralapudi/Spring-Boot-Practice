package com.example.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.demo.dao.StudentDAO;
import com.example.springboot.demo.entity.Student;

@Service
public class StudentServiceImple implements StudentService {

	@Autowired
	@Qualifier("studentDaoJpaImple")
	private StudentDAO studentDAO;

	@Override
	@Transactional
	public List<Student> findAll() {
		return studentDAO.findAll();
	}
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		studentDAO.save(theStudent);
	}
	
	@Override
	@Transactional
	public Student findById(int id) {
		return studentDAO.findById(id);
	}
	
	@Override
	@Transactional
	public String deleteById(int id) {
		return studentDAO.deleteById(id);
	}

}
