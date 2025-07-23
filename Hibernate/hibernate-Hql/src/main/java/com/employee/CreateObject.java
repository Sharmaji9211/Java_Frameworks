package com.employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class CreateObject 
{
	public static void main( String[] args )
	    {
	        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	        Session session = factory.openSession();
	        Transaction t = session.getTransaction();
	        t.begin();
	        session.save(new Employee("Amit","sales",20000));
	        session.save(new Employee("Sumit","Acountant",90000));
	        session.save(new Employee("Atul","Marketing",80000));
	        session.save(new Employee("Vivek","Software",1000));
	        session.save(new Employee("shivam","sales",40000));
	        session.save(new Employee("kapil","Acountant",55000));
	        session.save(new Employee("Rishabh","Marketing",25000));
	        session.save(new Employee("Abhi","Software",32500));
	        t.commit();
	        }
	}

