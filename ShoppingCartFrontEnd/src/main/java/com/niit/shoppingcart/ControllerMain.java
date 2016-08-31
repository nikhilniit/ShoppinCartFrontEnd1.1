package com.niit.shoppingcart;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.dao.UserDetailsDAO;
import com.niit.ShoppingCart.model.Category;
import com.niit.ShoppingCart.model.UserDetails;

@Controller
public class ControllerMain {
;
	@Autowired
UserDetails userDetails;
	@Autowired
private	CategoryDAO categoryDAO;
	@Autowired
	private UserDetailsDAO userDetailsDAO;
	@Autowired
	private Category category;
	
	@RequestMapping("/")
	@Autowired
	public ModelAndView onLoad(HttpSession session)
	{
		ModelAndView mv=new ModelAndView("/home");
	session.setAttribute("category",category);
		session.setAttribute("categoryList", categoryDAO.list());
		System.out.println("size:"+categoryDAO.list());
		return mv;
	}
	@RequestMapping(value="user/register",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute UserDetails userDetails)
	{

		ModelAndView mv=new ModelAndView("/home");
		if (userDetailsDAO.get(userDetails.getId())==null) {
			userDetailsDAO.save(userDetails);
			mv.addObject("msg","you are successfully registered");
		} else {
			mv.addObject("msg","no user exist with this id");
		}
	
		return mv;
	}
	@RequestMapping("/register")
	public ModelAndView register()
	{

		ModelAndView mv=new ModelAndView("/home");
		mv.addObject("userDetails",userDetails);
		mv.addObject("user clicked register here","true");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login()
	{

		ModelAndView mv=new ModelAndView("/home");
		mv.addObject("userDetails",userDetails);
		mv.addObject("user clicked login here","true");
		return mv;
}
}
