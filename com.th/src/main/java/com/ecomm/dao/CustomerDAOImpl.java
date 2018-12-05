package com.ecomm.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Authorities;
import com.ecomm.model.Customer;
import com.ecomm.model.User;

@Repository
@Transactional

public class CustomerDAOImpl  implements CustomerDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public void registerCustomer(Customer customer) {
		
		//SET ENABLED property in USER as true
		   customer.getUser().setEnabled(true);
		   
		   System.out.println(customer.getUser().getAuthorities());
		   
		   //CREATE new AUTHORITIES OBJECT AND SET THE ROLE AS ROLE_USER
		   Authorities authorities=new Authorities();
		   authorities.setRole("ROLE_USER");
		   //AUTHORITIES PROPERTY IN USER REFERS TO AUTHORITIES OBJECT
		   customer.getUser().setAuthorities(authorities);
		   
		   //MAKE USER PROPERTY IN AUTHORITIES TO REFER USER OBJECT
		   authorities.setUser(customer.getUser());
		   
		   Session session=sessionFactory.getCurrentSession();
     		session.save(customer);
		   //has to insert into customer table
				
	}

	public boolean isEmailUnique(String email) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		if(user==null)//email is unique
			return true;
			else
				return false;//email is not unique.
		
	}

}
