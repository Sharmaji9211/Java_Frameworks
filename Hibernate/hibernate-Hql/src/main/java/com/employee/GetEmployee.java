package com.employee;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;
public class GetEmployee 
{
	 public static void main(String[] args) {

	        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	        Session session = factory.openSession();
	        Query<Employee> query = session.createQuery("from Employee",Employee.class);
	        List<Employee> employeeList =query.list();
	        for(Employee emp: employeeList) {
	        	System.out.println(emp);
	        }
	        Query<Employee> query1 = session.createQuery("from Employee where department=:arg",Employee.class);
	        query1.setParameter("arg", "sales" + "");
	        List<Employee> employeeList1 =query.list();
	        for(Employee emp1: employeeList1) {
	        	System.out.println(emp1);
	        }
	 }
}
