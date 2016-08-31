package com.niit.ShoppingCart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.Category;

@EnableTransactionManagement
@Repository(value="categoryDAO")

public class CategoryDAOImpl implements CategoryDAO {
	private static final Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
	//private static final Logger log= LoggerFactory.getLogger("com.niit.ShoppingCart.dao.CategoryDAOImpl);
	@Autowired
private SessionFactory sessionFactory;
	
public CategoryDAOImpl(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;
}
@Transactional
public boolean save(Category category){
try {
	log.debug("starting of method save");
	sessionFactory.getCurrentSession().save(category);
	log.debug("ending of method save");
	return true;
} catch (Exception e) {
	log.error("exception occured in save method"+e.getMessage());
	e.printStackTrace();
return false;}

}
@Transactional
public boolean update(Category category){
	try {
		log.debug("starting of method update");
		sessionFactory.getCurrentSession().update(category);
		log.debug("ending of method update");
		return true;
	} catch (Exception e) {
		log.error("exception occured in update method"+e.getMessage());
		e.printStackTrace();
	
	return false;
	}	
}
@Transactional
public boolean delete(Category category){
	try {
		log.debug("starting of method delete");
		sessionFactory.getCurrentSession().delete(category);
		log.debug("starting of method delete");
		return true;
	} catch (Exception e) {
		log.error("exception occured in delete method"+e.getMessage());
		e.printStackTrace();
		return false;
	}
	

	
}
@Transactional
public Category get(String id){
	log.debug("starting of the method get");
	log.info("tryimg to get product based on id:"+id);
	String hql="from Category where id="+"'"+id+"'";
	log.info("the hsql query is:"+hql);
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Category> list=  query.list();
	if(list==null||list.isEmpty()){
		log.info("no categories are available with this id"+id);
	return null;
	}else {
		return list.get(0);
	}	
}
@Transactional
public List<Category> list(){
	log.debug("starting of the method list");
	String hql="from Category";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	log.debug("starting of the method list");
	List<Category> list=  query.list();
	if(list==null||list.isEmpty()){
		log.info("no categories are available");
	
	}
	return list;
}
}