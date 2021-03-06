package com.ecomm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Collection;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ecomm.config.*;
import com.ecomm.model.*;
import com.ecomm.dao.*;

public class SupplierDAOTestCase {
	
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	SupplierDAO supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
	
	@Test
	public void testFindAllSuppliers() {
		
		List<com.ecomm.model.Supplier> supplierList=supplierDAO.findAllSuppliers();
		assertNotNull(supplierList);
	}
	@Test
	public void testFindSupplierById() 
	{
		Supplier supplier1=supplierDAO.findSupplierById(3);
		assertNotNull(supplier1);
		int expectedId=3;
		int actualId=supplier1.getSupplierId();
		assertTrue(expectedId==actualId);
	}
	@Test
	public void testFindSupplierByName()
	{
		Supplier supplier2=supplierDAO.findSupplierByName("basics");
		assertNotNull(supplier2);
		String expectedName="basics";
		String actualName=supplier2.getSupplierName();
		assertTrue(expectedName.equals(actualName));
	}
@Test
	public void testAddSupplier()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(2);
		supplier.setSupplierName("SRT");
		supplier.setSupplierAddress("Chennai");
		supplier.setSupplierMobNo("89754");
		supplier.setSupplierMailId("srt@gmail.com");
		assertEquals(true,supplierDAO.addSupplier(supplier));
	}
@Test
	public void testUpdateSupplier()
	{
		Supplier supplier3=supplierDAO.findSupplierById(5);
		supplier3.setSupplierMobNo("91356");
		supplierDAO.updateSupplier(supplier3);
		assertTrue(supplier3.getSupplierMobNo()=="91356");
	}
@Test
	public void testDeleteSupplier()
	{
		Supplier supplier4=supplierDAO.findSupplierById(6);
		assertEquals(true,supplierDAO.deleteSupplier(supplier4.getSupplierId()));
	}

}

	

	