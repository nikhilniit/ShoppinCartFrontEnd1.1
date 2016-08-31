package com.niit.ShoppingCart;




import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.model.Supplier;

public class SupplierTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	SupplierDAO SupplierDAO=(SupplierDAO) context.getBean("supplierDAO");
	Supplier Supplier=(Supplier) context.getBean("supplier");
	Supplier.setId("SUP_001");
	Supplier.setName("CGName001");
	Supplier.setDescription("CG001 descri");
	if (SupplierDAO.save(Supplier)==true) 
	{
		System.out.println("Supplier created successfully");
		
	} else {
		System.out.println("cannot create supplier");

	}
}
}
