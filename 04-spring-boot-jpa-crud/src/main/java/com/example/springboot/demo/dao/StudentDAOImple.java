package com.example.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.demo.entity.Student;

@Repository
public class StudentDAOImple implements StudentDAO {

	private EntityManager entityManager;

	@Autowired
	public StudentDAOImple(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Student> findAll() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Student", Student.class).getResultList();
	}

	@Override
	public void save(Student theStudent) {
		Session session = entityManager.unwrap(Session.class);
		session.save(theStudent);
	}

	@Override
	public Student findById(int id) {
		Session session = entityManager.unwrap(Session.class);

		Student student = session.get(Student.class, id);

		if (student == null) {
			System.out.println("Student Not Found in the DB");
		}

		return student;
	}

	
	@Override
	public String deleteById(int id) {
		
		String resultMessage="";
		Session session = entityManager.unwrap(Session.class);

		Student student = session.get(Student.class, id);
		if(student!=null) {
			session.delete(student);
			resultMessage= "Student with id : "+id + " successfully deleted.";
		}else {
			System.out.println("Student Not Found in the DB");
			resultMessage="Student Not Found in the DB";
		}
		
		return resultMessage;
		
	}
}
