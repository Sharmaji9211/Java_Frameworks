package com.cetpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main(String[] args) 
	{
		SessionFactory factory  = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.getTransaction();
		t.begin();
		Person p1= new Person("Amit", "4455667788","Noida");
		Person p2= new Person("Sumit", "8899774466","Delhi");
		Person p3= new Person("Kapil", "8822114455","Bareilly");
		session.persist(new AdharCard(101,"123-456-789",p1));
		session.persist(new AdharCard(102,"456-789-123",p2));
		session.persist(new AdharCard(103,"789-456-123",p3));
		t.commit();
		
	
	}
}
