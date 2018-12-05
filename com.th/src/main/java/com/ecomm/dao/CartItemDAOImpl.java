package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.model.CartItem;
import com.ecomm.model.CustomerOrder;
import com.ecomm.model.User;

public class CartItemDAOImpl implements CartItemDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public void addToCart(CartItem cartItem) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);

	}

	public User getUser(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,email);
		return user;
	
	}

	public List<CartItem> getCart(String email) {
		Session session=sessionFactory.getCurrentSession();
		//SQL - select * from cartitem where user_email=?
		//cartItem has user, user has email
		Query query=session.createQuery("from CartItem where user.email='"+email+"'");
		//query.setString(0, email);
		List<CartItem> cartItems=query.list();
		return cartItems;

	}

	public void removeCartItem(int cartItemId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
		session.delete(cartItem);
	}

	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(customerOrder);
		//customerOrder.user -> user obj
		//user -> customer -> updated shipping address
		return customerOrder;

	}
}