package com.cetpa;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.cetpa.product.entity.Product;
public class DeleteObject 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Product p = session.get(Product.class, 101);
        if(p!=null) {
        	
        	Transaction t = session.beginTransaction();
        	session.delete(p);
        	t.commit();
        	System.out.println("Product is Deleted");
        }
        else {
        	System.out.println("Product Not Found");
        	
        }
         
        }
    
}
