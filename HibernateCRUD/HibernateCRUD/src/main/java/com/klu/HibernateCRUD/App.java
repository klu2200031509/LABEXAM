package com.klu.HibernateCRUD;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
        Metadata md = new MetadataSources().getMetadataBuilder(ssr).build();
        
        SessionFactory sf = md.getSessionFactoryBuilder().build();
        Session s = sf.openSession();
        Transaction t;
        
        Student s1 = new Student();
        s1.setName("Nikam Sujal");
        t = s.beginTransaction();
   
        System.out.println("Inserted Data");
        
        
       Acceleration ac = new Acceleration();
        ac.setName("Student 1");
        ac.setCourse("JFSD");
        ac.setResult("PASS");
        t.begin();
        s.save(ac);
        t.commit();
        System.out.println("Inserted Acceleration Object");
        
        
        OddSemester odd = new OddSemester();
        odd.setName("Student 2");
        odd.setCourse("JFSD");
        odd.setRegistration("YESS");
        t.begin();
        s.save(odd);
        t.commit();
        System.out.println("Inserted OddSemister Object");
        
        
        
       Student s2 =  s.find(Student.class, 6);
        s2.setName("xyz");
        t.begin();
        s.update(s2);
        t.commit();
        System.out.println("Updated Student Object");
        
        
        Student s21 = s.find(Student.class,6);
        //s1.setNext("XYZ");
        t = s.beginTransaction();
        //s.update(s2);
       // s.delete(s2);
        t.commit();
        System.out.println("Deleted Stuednt Object");
        
        
        
        Criteria c =s.createCriteria(Student.class);
        c.add(Restrictions.gt("id", 5));
        List<Student> l = c.list();
        for(Student s3:  l)
        {
          System.out.println("id: " + s3.getId() + " , name =  " + s3.getName());
        }
        
        Query<Student> qry = s.createQuery("select ST from Student ST where ST.id>10", Student.class);
        
        List<Student> l1 = qry.list();
        for(Student s3:  l1)
        {
          System.out.println("id: " + s3.getId() + " , name =  " + s3.getName());
        }
        
        
        
        
        
    }
}