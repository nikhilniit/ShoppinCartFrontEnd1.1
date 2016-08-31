package com.niit.ShoppingCart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.model.Product;

public class TestCaseProduct {

 @Autowired
 ProductDAO productDAO;
	@Autowired
	Product product;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingCart");
		context.refresh();
	productDAO=(ProductDAO) context.getBean("productDAO");
	product= (Product) context.getBean("product");
	}
@Test
public void deleteProductTest(){
	product.setId("PRO_001");
	boolean flag =productDAO.delete(product);
	assertEquals("deleteProductTest",flag,true);
	
}
@Test
public void addProductTest()

{
	product.setId("PRO_003");
	product.setName("ELECTRONIC");
	product.setDescription("this is new iphone");
	
	assertEquals("addProductTest",productDAO.save(product),true);
	
}
@Test
public void listProductTest(){
	assertEquals("listProductTest",productDAO.list().size(),1);
}
@Test
public void updateProductTestCase(){
	product.setId("PRO_003");
	product.setName("Gadgets");
	product.setDescription("this is htc mobile");
	assertEquals("updateProductTestCase",productDAO.update(product),true);
	
}
@Test
public void getProductTestCase(){
product= productDAO.get("PRO_003");
//assertEquals("getProductTestCase",product.getId(),"PRO_003");
}
}
