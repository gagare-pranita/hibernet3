package com.jspider.hibernet3.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.mapping.Array;

import com.jspider.hibernet3.dao.AdharCard;
import com.jspider.hibernet3.dao.Company;
import com.jspider.hibernet3.dao.Employee;
import com.jspider.hibernet3.dao.Person;

public class CompanyMain {
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
	Company c=new Company();
	c.setName("infosys");
	c.setId(1);
	c.setDob(1998);
	Employee employee1=new Employee();
	employee1.setName("pranita");
	employee1.setId(1);
	employee1.setAge(22);
	employee1.setSalary(23000);
	
	Employee employee2=new Employee();
	employee2.setName("swati");
	employee2.setId(2);
	employee2.setAge(25);
	employee2.setSalary(24000);
	
		List<Employee> employees=new ArrayList();
		employees.add(employee1);
		employees.add(employee2);
		c.setEmployee(employees);
        entityManager.persist(employee1);
entityManager.persist(employee2);
entityManager.persist(c);
		entityTransaction.commit();
		closeConnection();
	}


}
