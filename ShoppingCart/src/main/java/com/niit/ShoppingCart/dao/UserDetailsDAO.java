package com.niit.ShoppingCart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ShoppingCart.model.UserDetails;





@Repository
public interface UserDetailsDAO {
public boolean save(UserDetails userDetails);
public boolean update(UserDetails userDetails);
public boolean delete(UserDetails userDetails);
public UserDetails get(String id);
public List<UserDetails> list();
public UserDetails isValidUser(String id,String password);
}
