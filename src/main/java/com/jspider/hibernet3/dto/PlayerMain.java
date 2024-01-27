package com.jspider.hibernet3.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernet3.dao.AdharCard;
import com.jspider.hibernet3.dao.Person;
import com.jspider.hibernet3.dao.Player;
import com.jspider.hibernet3.dao.Team;

public class PlayerMain {
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
	Player p1=new Player();
	p1.setId(1);
	p1.setName("rohit shrama");
	p1.setAge(34);
	p1.setContact(1234567);
	
	Player p2=new Player();
	p2.setId(2);
	p2.setName("virat kholi");
	p2.setAge(32);
	p2.setContact(123456790);
	
	
	Team team=new Team();
	team.setId(1);
	team.setNoofplayer(12);
	team.settName("india");
	entityManager.persist(team);
	p1.setTeam(team);
	p2.setTeam(team);
	entityManager.persist(p1);
	entityManager.persist(p2);
		entityTransaction.commit();
		closeConnection();
	}

}
