package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.dao.ProductDAO;
@Repository("productDAO")
@Transactional

public class ProductDAOImp implements  ProductDAO{
	@Autowired
	SessionFactory sessionFactory;
	

	public List<Product> findAllProducts() {
		
		return sessionFactory.getCurrentSession().createQuery("From Product").list();
	}

	public Product findProductById(int ProductId) {
		
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where Id="+ProductId).list();
	}

	public Product findProductByName(String ProductName) {
		
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where ProductName= '"+ProductName+"'").list();
	}

	public boolean addProduct(Product product) {
		try {
			
		
	
		 sessionFactory.getCurrentSession().saveOrUpdate(product);
		 return true;
	}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateProduct(Product product) {
		
		sessionFactory.getCurrentSession().update(product);
		return true;
	}

	public boolean deleteProduct(int productId) {
		
		sessionFactory.getCurrentSession().delete(findProductById(productId));
		return true;
	}

	public List<Category> getAllCategories() {
		
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class, id);
		return product;
				
	}
	

}
