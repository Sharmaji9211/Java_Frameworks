package com.cetpa.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.cetpa.models.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository
{
	private Session session;
	private Transaction transaction;
	
	public StudentRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	public Student getRecord(int sid) 
	{
		Student product=session.get(Student.class,sid);
		return product;
	}
	public List<Student> getList() 
	{
		Query<Student> query=session.createQuery("from Student",Student.class);
		return query.list();
	}

	public void persistObject(Student student) {
	
		transaction.begin();
		session.persist(student);
		transaction.commit();
		
	}

	@Override
	public void deleteRecord(Student student) {
		transaction.begin();
		session.remove(student);
		transaction.commit();
		
	}

	@Override
	public void updateRecord(Student ostudent, Student nstudent) {
		// TODO Auto-generated method stub
		transaction.begin();
		ostudent.setName(nstudent.getName());
		ostudent.setMobile(nstudent.getMobile());
		ostudent.setEmail(nstudent.getEmail());
		ostudent.setCourse(nstudent.getCourse());
		ostudent.setFee(nstudent.getFee());
		transaction.commit();
		
	}
}
