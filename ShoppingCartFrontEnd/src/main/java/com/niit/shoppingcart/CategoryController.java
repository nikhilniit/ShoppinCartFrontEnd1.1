package com.niit.shoppingcart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.model.Category;

public class CategoryController {

	private static Logger log=LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public String listCategories(Model model)
	{
		log.debug("starting of method listCategories");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		log.debug("ending of method listCategories");
		return "category";
	}
	@RequestMapping(value="/category/add",method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category)
	{
	log.debug("starting of method addcategory");
categoryDAO.save(category);
log.debug("ending of method addCategory");
return "category";
}
	@RequestMapping("category/remove/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id) throws Exception
	{
		category= categoryDAO.get(id);
		ModelAndView mv=new ModelAndView("category");
		
		if(category==null)
		{
     mv.addObject("error message", "could not delete category");
		}
	
	
	else
	{
	categoryDAO.delete(category);	
	}
		return mv;
		}
	}
