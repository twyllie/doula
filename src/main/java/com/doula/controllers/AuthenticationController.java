package com.doula.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doula.models.User;
import com.doula.services.UserService;

@Controller
public class AuthenticationController extends AbstractController {
	
	
	
	@Autowired
    private UserService userService;
    
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(){
		//TODO: Implement a check to see if the user is logged in already.
		//If they are redirect straight to the dash.
		return "redirect:/preview";
	}
	
	
	
	@RequestMapping(value = "/preview", method = RequestMethod.GET)
	public String preview(){
		return "preview";
	}
	
	
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signinGet(){
		return "signin";
	}
	
	
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signinPost(HttpServletRequest request){
		
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		
//		if(User.isValidEmail(email)){
//			User user = userDao.findByEmail(email);
//			if(user.isMatchingPassword(password)){
//				setUserInSession(request.getSession(), user);
//				return "redirect: /u/home";
//			}
//		}
		
		return "signin";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(){
		return "signup";
	}
	
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(HttpServletRequest request, Model model){
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String verify = request.getParameter("verify");
		
		if(!User.isValidPassword(password)){
			model.addAttribute("password_erro", "Invalid password");
			return "signup";
		}
		
		
		if(!password.equals(verify)){
			model.addAttribute("verify_error", "The passwords do not match.");
			return "signup"; 
		}
		
		if(!User.isValidEmail(email)){
			model.addAttribute("email_error", "The email address is invalid");
			return "signup";
		}
		
		if(userService.findByEmail(email) != null){
			model.addAttribute("email_error", "Email is already in use.");
			return "signup";
		}

		
		User user = new User(email, password);
		userService.save(user, false);
		
		
		return "redirect:/signin";
	}
	
	
	
	@RequestMapping(value="/admin/signup", method = RequestMethod.GET)
	public String adminSignupGet(){
		return "admin_signup";
	}
	
	
	
	@RequestMapping(value="/admin/signup", method = RequestMethod.POST)
	public String adminSignupPost(HttpServletRequest request, Model model){
		return "admin_signup";
	}
	
//	
//	
//	@RequestMapping(value = "/signout", method = RequestMethod.GET)
//	public String signout(HttpServletRequest request){
//		request.getSession().invalidate();
//		return "redirect:/preview";
//	}
//	
	
}
