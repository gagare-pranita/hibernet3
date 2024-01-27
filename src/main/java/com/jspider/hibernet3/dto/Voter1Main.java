package com.jspider.hibernet3.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernet3.dao.Voter;
import com.jspider.hibernet3.dao.Voter1;
import com.jspider.hibernet3.dao.VotingCard;
import com.jspider.hibernet3.dao.Votingcard1;

public class Voter1Main {
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
Voter1  voter1=new Voter1();
voter1.setId(3);
voter1.setName("pranita");
voter1.setAddress("pune");

Votingcard1 votingcard1=new Votingcard1();
votingcard1.setId(3);
votingcard1.setVoter1(voter1);
votingcard1.setVoternumber(1289);
voter1.setVotingcard1(votingcard1);
entityManager.persist(votingcard1);
entityManager.persist(voter1);
		entityTransaction.commit();
		closeConnection();
	}


}
