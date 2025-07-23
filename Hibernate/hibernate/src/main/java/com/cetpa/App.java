package com.cetpa;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.cetpa.product.entity.Product;
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.getTransaction();
        t.begin();
        session.persist(new Product(101,"Laptop","Hp",60000));
        session.persist(new Product(102,"Mouse","HCL",800));
        session.persist(new Product(103,"Keyboard","Dlink",1200));
        session.persist(new Product(104,"Pendrive","sandisk",500));
        t.commit();
        
       
         
        }
    
}
