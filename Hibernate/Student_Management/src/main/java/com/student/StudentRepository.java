package com.student;

import org.hibernate.cfg.Configuration;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.*;


public class StudentRepository {

	private static Session session;
	private static Transaction  transaction;
	
	static {
		SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
		session= sessionFactory.openSession();
		transaction=session.getTransaction();
	}
	public void saveStudent(Student student) {
		transaction.begin();
		session.save(student);
		transaction.commit();
	}
	public Student searchById(int studentsid) {
	   return session.get(Student.class,studentsid);	
	}
	public List<Student> getAllStudent() {
		
		Query<Student> query=session.createQuery("from Student",Student.class);
		return query.list();
	}
	public void DeteteById(Student student ) {
	   transaction.begin();
	   session.remove(student);
	   transaction.commit();
	}
	public void UpdateRecord(Student ostudent, Student nstudent) {
		 transaction.begin();
		   ostudent.setMobile(nstudent.getMobile());
		   ostudent.setEmail(nstudent.getEmail());
		   ostudent.setCourse(nstudent.getCourse());
		   ostudent.setFee(nstudent.getFee());
		   transaction.commit();
	}

}
