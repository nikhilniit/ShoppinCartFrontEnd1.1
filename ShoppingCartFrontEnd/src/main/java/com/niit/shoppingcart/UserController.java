package com.niit.shoppingcart;

import javax.servlet.http.HttpSession;

import org.h2.engine.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.dao.UserDetailsDAO;
import com.niit.ShoppingCart.model.UserDetails;

@Controller
public class UserController {
	@Autowired
UserDetailsDAO userDetailsDAO;
	@Autowired
	UserDetails userDetails;
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value="id") String id,
			@RequestParam(value="password") String password,HttpSession session)
	{
		ModelAndView mv =new ModelAndView("home");
		String msg;
		userDetails=userDetailsDAO.isValidUser(id,password);
				if(userDetails == null){
			msg="invalid user...please try again";
		}
				else
				{
					if(userDetails.getRole().equals("ROLE_ADMIN"))
					{
						mv=new ModelAndView("adminHome");
					}
					else {
						session.setAttribute("welcome msge",userDetails.getName());
						session.setAttribute("userid",userDetails.getId());
					}
						
				}
		return mv;
		
		
}


}