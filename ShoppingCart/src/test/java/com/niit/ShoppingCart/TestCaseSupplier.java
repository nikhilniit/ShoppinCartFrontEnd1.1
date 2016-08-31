package com.niit.ShoppingCart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.model.Supplier;

public class TestCaseSupplier {

 @Autowired
 SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingCart");
		context.refresh();
	supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
	supplier= (Supplier) context.getBean("supplier");
	}
@Test
public void deleteSupplierTest(){
	supplier.setId("SUP_001");
	boolean flag =supplierDAO.delete(supplier);
	assertEquals("deleteSupplierTest",flag,true);
	
}
@Test
public void addSupplierTest()

{
	supplier.setId("SUP_003");
	supplier.setName("sony");
	supplier.setDescription("4 star rated");
	
	assertEquals("addSupplierTest",supplierDAO.save(supplier),true);
	
}
@Test
public void listSupplierTest(){
	assertEquals("listSupplierTest",supplierDAO.list().size(),2);
}
@Test
public void updateSupplierTestCase(){
	supplier.setId("SUP_003");
	supplier.setName("rocky");
	supplier.setDescription("5 star rated");
	assertEquals("updateSupplierTestCase",supplierDAO.update(supplier),true);
	
}
@Test
public void getSupplierTestCase(){
	supplier= supplierDAO.get("SUP_003");
//assertEquals("getSupplierTestCase",supplier.getId(),"SUP_003");
}
}
