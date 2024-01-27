package com.jspider.hibernet3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspider.hibernet3.dto.EmployeeInsert;

public class EmployeeJpql {
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
		String jpql="select emp from EmployeeInsert emp";
	Query query=entityManager.createQuery(jpql);
	List<EmployeeInsert> employees= query.getResultList();
	for(EmployeeInsert emp:employees)
	{
		System.out.println(emp);
	}
	
		entityTransaction.commit();
		closeConnection();
	}

}
