package com.niit.ShoppingCart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.UserDetailsDAO;
import com.niit.ShoppingCart.model.UserDetails;

public class TestCaseUserDetails {

 @Autowired
 UserDetailsDAO userDetailsDAO;
	@Autowired
	UserDetails userDetails;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingCart");
		context.refresh();
	userDetailsDAO=(UserDetailsDAO) context.getBean("userDetailsDAO");
	userDetails= (UserDetails) context.getBean("userDetails");
	}
@Test
public void deleteUserDetailsTest(){
	userDetails.setId("USD_001");
	boolean flag =userDetailsDAO.delete(userDetails);
	assertEquals("deleteUserDetailsTest",flag,true);
	
}
@Test
public void addUserDetailsTest()

{
	userDetails.setId("USD_003");
	userDetails.setName("Nikhil");

	
	assertEquals("addUserDetailsTest",userDetailsDAO.save(userDetails),true);
	
}

@Test
public void updateUserDetailsTestCase(){
	userDetails.setId("USD_003");
	userDetails.setName("amar");

	assertEquals("updateUserDetailsTestCase",userDetailsDAO.update(userDetails),true);
	
}
@Test
public void listUserDetailsTest(){
	assertEquals("listUserDetailsTest",userDetailsDAO.list().size(),1);
}
@Test
public void getUserDetailsTestCase(){
	userDetails= userDetailsDAO.get("USD_003");
	assertEquals("getTestCase",userDetails.getId(),"USD_003");

}
}
