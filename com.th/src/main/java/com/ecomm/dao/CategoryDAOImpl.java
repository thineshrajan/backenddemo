package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	
    @Autowired
    SessionFactory sessionfactory;
	public boolean add(Category category) {
		
		sessionfactory.getCurrentSession().save(category);
		return true;
	}

	public boolean delete(Category category) {
		
		sessionfactory.getCurrentSession().delete(category);
		return true;
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().update(category);
		return true;
	}

	public List<Category> listCategories() {
		// TODO Auto-generated method stub
		return sessionfactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		return (Category)sessionfactory.getCurrentSession().createQuery("from Category where CategoryId="+categoryId).uniqueResult();
	}
	
}