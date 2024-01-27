package com.jspider.hibernet3.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernet3.dao.AdharCard;
import com.jspider.hibernet3.dao.Person;

public class PersonMain {
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
		Person p=new Person();
		p.setId(1);
		p.setName("pranita");
		p.setAge(12);
		
		AdharCard adharcard=new AdharCard();
		adharcard.setId(2);
		adharcard.setAdharno(1234);
		entityManager.persist(adharcard);
		p.setAdharcard(adharcard);
	
		entityManager.persist(p);
	
		
		entityTransaction.commit();
		closeConnection();
	}

}
