package com.jspider.hibernet3.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernet3.dao.Player;
import com.jspider.hibernet3.dao.Team;
import com.jspider.hibernet3.dao.Voter;
import com.jspider.hibernet3.dao.VotingCard;

public class VoterMain {

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
Voter  voter=new Voter();
voter.setId(7);
voter.setName("pranita");
voter.setAddress("pune");

VotingCard votingcard=new VotingCard();
votingcard.setId(7);
votingcard.setVoter(voter);
votingcard.setVoternumber(1289);
voter.setVotingcard(votingcard);
entityManager.persist(votingcard);
entityManager.persist(voter);
		entityTransaction.commit();
		closeConnection();
	}

}
