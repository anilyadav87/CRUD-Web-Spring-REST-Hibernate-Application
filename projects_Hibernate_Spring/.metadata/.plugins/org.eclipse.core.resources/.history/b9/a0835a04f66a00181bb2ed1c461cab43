package com.niit.crudhibernate.config;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.niit.crudhibernate.model.*;

import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
public class DBConfig {

	private static SessionFactory sessionFactory = null;
	 
    public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void setSessionFactory(SessionFactory sessionFactory) {
		DBConfig.sessionFactory = sessionFactory;
	}
	static {
        try{
        	System.out.println("Not Successful");
            load();
            System.out.println("Successful");
        }catch(Exception e){
            System.err.println("Exception while initializing hibernate util.. ");
            e.printStackTrace();
        }
    }
	public static void load()
	{
		Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    configuration.addAnnotatedClass(User.class);
    ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    setSessionFactory(configuration.buildSessionFactory(srvcReg));
		
	}
	
	public static Session getSession() throws HibernateException {
		 
        Session session=null;
            try {
                session=getSessionFactory().openSession();
                //session.getTransaction().begin();;
            }catch(Throwable t){
            System.err.println("Exception while getting session.. ");
            t.printStackTrace();
            }
            if(session == null) {
                System.err.println("session is discovered null");
            }
 
            return session;
    }
}
