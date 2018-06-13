package com.niit.crudhibernatespring.configuration;
//import org.springframework.transaction.annotation.*;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.niit.crudhibernatespring")
//@PropertySource({ "classpath:src/main/resources/db.properties" })
public class ConfigurationUser {

	//@Autowired
//	private Environment environment;
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource()
	{
		System.out.println("Database method loaded");
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.h2.Driver");
		driverManagerDataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		driverManagerDataSource.setUsername("sa");
		driverManagerDataSource.setPassword("");
		
		return driverManagerDataSource;
	}
	
	Properties hibernateProperties()
	{
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		//properties.setProperty("hibernate.globally_quoted_identifiers","true");
		return properties;
	}
	
	
	@Bean(name = "sessionFactory")
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource)
	{
		System.out.println("method start");
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		localSessionFactoryBean.setPackagesToScan("com.niit.crudhibernatespring.model");
		return localSessionFactoryBean;

	}
	
	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{
		System.out.println("transaction Method loaded");
		
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
}