package com.niit.ShoppingCart;




import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.model.Product;

public class ProductTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	ProductDAO ProductDAO=(ProductDAO) context.getBean("productDAO");
	Product Product=(Product) context.getBean("product");
	Product.setId("PRO_001");
	Product.setName("PROName001");
	Product.setDescription("PRO001 descri");
	if (ProductDAO.save(Product)==true) 
	{
		System.out.println("Product created successfully");
		
	} else {
		System.out.println("cannot create product");

	}
}
}
