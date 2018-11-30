package com.ecomm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTestCase {

	static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst() {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	
	@Test
	public void addProductTest() {
		
		Product product=new Product();
		product.setId(2);
		product.setProductName("ATM");
		product.setProductDescription("kit");
		product.setProductSize("small");
		product.setProductPrice(100);
		product.setProductQuantity(10);
		assertEquals(true,productDAO.addProduct(product));
		
	}
	@Ignore
	@Test
	public void updateProductTest() {
		
		Product product3=productDAO.getProduct(45);
		product3.setProductName("Malayalam");
		product3.setProductQuantity(15);
		productDAO.updateProduct(product3);
		assertTrue(product3.getProductQuantity()==15);
	}
	
	@Ignore
	@Test
	public void deletProductTest() {
		
		Product product4=productDAO.findProductById(44);
		assertEquals(true,productDAO.deleteProduct(product4.getId()));

	}
	public void FindAllProducts() 
	{
		List<Product> listproduct=productDAO.findAllProducts();
        assertTrue("Problem in Listing the Categories",listproduct.size()>0);
		
		for(Product product:listproduct)
		{
			System.out.print("Product ID:"+product.getId());
			System.out.print("Product Name:"+product.getProductName());
			System.out.println("Product Quantity:"+product.getProductQuantity());
		}
		}

}
