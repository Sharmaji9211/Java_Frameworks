package com.cetpa;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.cetpa.product.entity.Product;
public class ReadObject 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Product p = session.get(Product.class, 101);
        if(p!=null) {
        	System.out.println(p);
        }
        else {
        	System.out.println("Product Not Found");
        	
        } 
        }
    
}
