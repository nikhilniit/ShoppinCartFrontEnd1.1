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

import com.niit.ShoppingCart.model.UserDetails;

@EnableTransactionManagement
@Repository(value="userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDetailsDAOImpl.class);
	//private static final Logger log= LoggerFactory.getLogger("com.niit.ShoppingCart.dao.UserDetailsDAOImpl);
	@Autowired
private SessionFactory sessionFactory;
public UserDetailsDAOImpl(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;
}
@Transactional
public boolean save(UserDetails userDetails){
try {
	log.debug("starting of method save");
	sessionFactory.getCurrentSession().save(userDetails);
	log.debug("ending of method save");
	return true;
} catch (Exception e) {
	log.error("exception occured in save method"+e.getMessage());
	e.printStackTrace();
return false;}

}
@Transactional
public boolean update(UserDetails userDetails){
	try {
		log.debug("starting of method update");
		sessionFactory.getCurrentSession().update(userDetails);
		log.debug("ending of method update");
		return true;
	} catch (Exception e) {
		log.error("exception occured in update method"+e.getMessage());
		e.printStackTrace();
	
	return false;
	}	
}
@Transactional
public boolean delete(UserDetails userDetails){
	try {
		log.debug("starting of method delete");
		sessionFactory.getCurrentSession().delete(userDetails);
		log.debug("starting of method delete");
		return true;
	} catch (Exception e) {
		log.error("exception occured in delete method"+e.getMessage());
		e.printStackTrace();
		return false;
	}
	

	
}
@Transactional
public UserDetails get(String id){
	log.debug("starting of the method get");
	log.info("tryimg to get product based on id:"+id);
	String hql="from UserDetails where id="+"'"+id+"'";
	log.info("the hql query is:"+hql);
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<UserDetails> list=  query.list();
	if(list==null||list.isEmpty()){
		log.info("no users are available with this id"+id);
	return null;
	}else {
		return list.get(0);
	}	
}
@Transactional
public UserDetails isValidUser(String id, String password)
{
String hql="from UserDetails where id='"+id+"' and password='"+password +"'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
List<UserDetails> list=  query.list();
if(list==null){
	
return null;
}else {
	return list.get(0);
}	
}
@Transactional
public List<UserDetails> list(){
	log.debug("starting of the method list");
	String hql="from UserDetails";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	log.debug("starting of the method list");
	List<UserDetails> list=  query.list();
	if(list==null||list.isEmpty()){
		log.info("no users are available");
	
	}
	return list;
}
}