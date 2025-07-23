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
	        Transaction  t = session.getTransaction();
	        
	        Employee emp=(new Employee("Amit","sales",20000));//Transient State
	        t.begin();
	        session.save(emp);//Persistent State
	        //session.persist(emp);//Persistent State
	        t.commit();
	        t.begin();
	        emp.setDepartment("Marketing");
	        t.commit();
	        session.detach(emp);//Datched State
	        t.begin();
	        emp.setDepartment("Accounts");
	        t.commit();
	        
	        }
	}

