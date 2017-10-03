package com.registry.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.registry.model.User;
import com.registry.service.RegistryService;
import com.registry.validate.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	UserValidator userValidator;
	
	@Autowired
	RegistryService registryService;


	@RequestMapping(value="/login.html",method= RequestMethod.GET)
	public String userLogin(Model model){
		
		model.addAttribute("user", new User());				
		
		return "login";
	}
	
	
	@RequestMapping(value="/validateUser.html",method= RequestMethod.POST)
	public String validateUser(@ModelAttribute("user") User user, BindingResult result,Model model, HttpServletResponse response){
	
		userValidator.validate(user, result);
		
		if(result.hasErrors()){
			return "login";
		}
		
		boolean validate = registryService.validateUser(user);
		
		if(validate){
			Cookie cookie = new Cookie("firstname", user.getFirstName());
			response.addCookie(cookie);
			return "home";
		}else{
			model.addAttribute("validate","User data did not match records, please check again");
		}
		return "login";
	}
	
	
}
