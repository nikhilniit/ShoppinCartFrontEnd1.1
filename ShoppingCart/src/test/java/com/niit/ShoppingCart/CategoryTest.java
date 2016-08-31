package com.niit.ShoppingCart;




import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.model.Category;

public class CategoryTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	CategoryDAO CategoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	Category Category=(Category) context.getBean("category");
	Category.setId("CAT_002");
	Category.setName("CGName001");
	Category.setDescription("CG001 descri");
	if (CategoryDAO.save(Category)==true) 
	{
		System.out.println("Category created successfully");
		
	} else {
		System.out.println("cannot create category");

	}
}
}
