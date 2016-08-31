package com.niit.ShoppingCart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.model.Category;

public class TestCaseCategory {

 @Autowired
 CategoryDAO categoryDAO;
	@Autowired
	Category category;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingCart");
		context.refresh();
	categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	category= (Category) context.getBean("category");
	}
@Test
public void deleteCategoryTest(){
	category.setId("CAT_002");
	boolean flag =categoryDAO.delete(category);
	assertEquals("deleteCategoryTest",flag,true);
	
}
@Test
public void addCategoryTest()

{
	category.setId("CAT_003");
	category.setName("ELECTRONIC");
	category.setDescription("this is new iphone");
	
	assertEquals("addCategoryTest",categoryDAO.save(category),true);
	
}
@Test
public void listCategoryTest(){
	assertEquals("listCategoryTest",categoryDAO.list().size(),2);
}
@Test
public void updateCategoryTestCase(){
	category.setId("CAT_003");
	category.setName("Gadgets");
	category.setDescription("this is htc mobile");
	assertEquals("updateCategoryTestCase",categoryDAO.update(category),true);
	
}
@Test
public void getCategoryTestCase(){
category= categoryDAO.get("CAT_003");
assertEquals("getCategoryTestCase",category.getId(),"CAT_003");
}
}
