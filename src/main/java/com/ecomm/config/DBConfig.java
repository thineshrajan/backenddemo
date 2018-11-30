package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm.model")
public class DBConfig{
	
	@Bean(name="dataSource")
	public DataSource getH2DataSource() {
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/test");
		dataSource.setUsername("sample");
		dataSource.setPassword("123");
		System.out.println("---DataSource Object is Created----");
		return dataSource;
		
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernateProp.hbm2ddl.auto" ,"create");
		hibernateProp.put("hibernateProp.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(User.class);
		factory.addProperties(hibernateProp);
		System.out.println("---SessionFactory Object  Created ----");
		return factory.buildSessionFactory();
		
	}
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager object Created--");
		return new HibernateTransactionManager(sessionFactory);
	}
	
}
	
