package com.cetpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetData 
{
	public static void main(String[] args) 
	{
		SessionFactory factory  = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		AdharCard card= session.get(AdharCard.class, 101);
		                                                     
		
		
	
	}
}
