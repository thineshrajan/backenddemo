package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.CategoryDAOImpl;
import com.ecomm.dao.CustomerDAO;
import com.ecomm.dao.CustomerDAOImpl;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.ProductDAOImp;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.dao.SupplierDAOImpl;
import com.ecomm.dao.UserDAO;
import com.ecomm.dao.UserDAOImpl;
import com.ecomm.model.Authorities;
import com.ecomm.model.BillingAddress;
import com.ecomm.model.CartItem;
import com.ecomm.model.Category;
import com.ecomm.model.Customer;
import com.ecomm.model.CustomerOrder;
import com.ecomm.model.Product;
import com.ecomm.model.ShippingAddress;
import com.ecomm.model.Supplier;
import com.ecomm.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm.model")
public class DBConfig{
	
	@Bean(name="dataSource")
	public DataSource getH2DataSource() {
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sample");
		dataSource.setPassword("123");
		System.out.println("---DataSource Object is Created----");
		return dataSource;
		
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource datasource) {
		
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto" ,"create");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(User.class);
		factory.addAnnotatedClass(Authorities.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(Customer.class);
		factory.addAnnotatedClass(CustomerOrder.class);
		factory.addAnnotatedClass(ShippingAddress.class);
		factory.addAnnotatedClass(CartItem.class);
		factory.addAnnotatedClass(BillingAddress.class);
		
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
	
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
		System.out.println("--CategoryDAO Object Creation--");
		return new CategoryDAOImpl();
	}
	
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory)
	{
		System.out.println("--ProductDAO Object Creation--");
		return new ProductDAOImp();
	}
	
	@Autowired
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		System.out.println("--SupplierDAO Object Creation--");
		return new SupplierDAOImpl();
	}
	
	@Autowired
	@Bean(name="userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("--UserDAO Object Creation--");
		return new UserDAOImpl();
	}
	
	@Autowired
	@Bean(name="customerDAO")
	public CustomerDAO getCustomerDAO(SessionFactory sessionFactory)
	{
		System.out.println("--UserDAO Object Creation--");
		return new CustomerDAOImpl();
	}
	
	
	
}
	
