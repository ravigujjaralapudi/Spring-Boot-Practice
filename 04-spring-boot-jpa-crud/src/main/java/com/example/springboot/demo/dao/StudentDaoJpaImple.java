package com.example.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.demo.entity.Student;

@Repository
public class StudentDaoJpaImple implements StudentDAO {

	private EntityManager entityManager;

	@Autowired
	public StudentDaoJpaImple(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Student> findAll() {
		return entityManager.createQuery("from Student", Student.class).getResultList();
	}

	@Override
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(int id) {


		Student student = entityManager.find(Student.class, id);

		if (student == null) {
			System.out.println("Student Not Found in the DB");
		}

		return student;
	}

	
	@Override
	public String deleteById(int id) {
		
		String resultMessage="";
		

		Student student = entityManager.find(Student.class, id);
		if(student!=null) {
			entityManager.remove(student);
			resultMessage= "Student with id : "+id + " successfully deleted.";
		}else {
			System.out.println("Student Not Found in the DB");
			resultMessage="Student Not Found in the DB";
		}
		
		return resultMessage;
		
	}
}
