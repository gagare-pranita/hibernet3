package com.jspider.hibernet3.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernet3.dao.Pranita;



public class PranitaMain {
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
	Pranita p=new Pranita();
	p.setId(1);
	//b.setId(1);  does not needed to set the id
	p.setName("panu");

	entityManager.persist(p);
	

		entityTransaction.commit();
		closeConnection();
	}
}

