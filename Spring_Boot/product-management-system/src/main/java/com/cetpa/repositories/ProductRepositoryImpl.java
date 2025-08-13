package com.cetpa.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.cetpa.models.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository
{
	private Session session;
	private Transaction transaction;
	
	public ProductRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	
	public void persistObject(Product product) 
	{
		transaction.begin();
		session.persist(product);
		transaction.commit();
	}

	public Product getRecord(int pid) 
	{
		Product product=session.get(Product.class,pid);
		return product;
	}

	public void deleteRecord(Product product) 
	{
		transaction.begin();
		session.remove(product);
		transaction.commit();
	}

	public void updateRecord(Product oproduct, Product nproduct) 
	{
		transaction.begin();
		oproduct.setName(nproduct.getName());
		oproduct.setBrand(nproduct.getBrand());
		oproduct.setPrice(nproduct.getPrice());
		transaction.commit();
	}

	public List<Product> getList() 
	{
		Query<Product> query=session.createQuery("from Product",Product.class);
		return query.list();
	}
}
