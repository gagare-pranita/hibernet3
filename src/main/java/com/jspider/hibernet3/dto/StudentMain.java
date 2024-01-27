package com.jspider.hibernet3.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.mapping.Array;

import com.jspider.hibernet3.dao.Course;
import com.jspider.hibernet3.dao.Player;
import com.jspider.hibernet3.dao.Student;
import com.jspider.hibernet3.dao.Team;

public class StudentMain {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("emp");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeConnection()
	{
		if(entityManagerFactory!=null)
		{
			entityManagerFactory.close();
		}
		if(entityManager!=null)
		{
			entityManager.close();
		}
		if(entityTransaction!=null)
		{
			if(entityTransaction.isActive())
			{
				entityTransaction.rollback();
			}
		}
	}
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
	Student student1=new Student();
	student1.setId(1);
	student1.setName("pranita");
	student1.setAge(12);
	
	Student student2=new Student();
	student2.setId(2);
	student2.setName("swati");
	student2.setAge(13);

	
	Course course1=new Course();
	course1.setId(1);
	course1.setName("java");
	
	
	Course course2=new Course();
	course2.setId(2);
	course2.setName("c++");
	List<Course> courses1=new ArrayList<>();
	courses1.add(course1);
	courses1.add(course2);
	List<Course> courses2=new ArrayList<>();
	courses2.add(course1);

entityManager .persist(student1);
entityManager.persist(student2);
student1.setCourse(courses1);
student2.setCourse(courses2);
entityManager.persist(course1);
entityManager.persist(course2);
		entityTransaction.commit();
		closeConnection();
	}


}
