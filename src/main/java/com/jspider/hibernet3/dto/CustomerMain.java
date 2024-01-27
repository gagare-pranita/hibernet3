package com.jspider.hibernet3.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernet3.dao.Course;
import com.jspider.hibernet3.dao.Customer;
import com.jspider.hibernet3.dao.Product;
import com.jspider.hibernet3.dao.Student;

public class CustomerMain {
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
	Customer customer1=new Customer();
	customer1.setId(9);
	customer1.setName("pranita");
	Customer customer2=new Customer();
	customer2.setId(10);
	customer2.setName("swati");
	List<Customer> customers1=new ArrayList<>();
	customers1.add(customer1);
	customers1.add(customer2);
	
	List<Customer> customers2=new ArrayList<>();
	customers2.add(customer1);
	Product product1=new Product();
	product1.setId(9);
	product1.setPname("santoor");
	product1.setPrice(123);
	Product product2=new Product();
	product2.setId(10);
	product2.setPname("lux");
	product2.setPrice(163);
	
	List<Product> products1=new ArrayList<>();
	products1.add(product2);
	products1.add(product1);
	List<Product> products2=new ArrayList<>();
	product1.setCustomer(customers2);
	product2.setCustomer(customers1);
	product2.setCustomer(customers2);
	customer1.setProduct(products2);
	entityManager.persist(product1);
	entityManager.persist(product2);
	entityManager.persist(customer1);
	entityManager.persist(customer2);
		entityTransaction.commit();
		closeConnection();
	}

}
