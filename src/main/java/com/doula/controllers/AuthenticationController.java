package com.doula.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doula.models.User;

@Controller
public class AuthenticationController extends AbstractController {
	
	
	
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
	public String signinForm(){
		return "signin";
	}
	
	
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(HttpServletRequest request, Model model){
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(User.isValidEmail(email)){
			User user = userDao.findByEmail(email);
			if(user.isMatchingPassword(password)){
				setUserInSession(request.getSession(), user);
				return "redirect: /u/home";
			}
		}
		
		model.addAttribute("error", "Either the email address or password are incorrect.");
		model.addAttribute("email", email);
		
		return "signin";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupForm(){
		return "signup";
	}
	
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(HttpServletRequest request, Model model){
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String verify = request.getParameter("verify");
		
		
		if(!password.equals(verify)){
			model.addAttribute("email", email);
			model.addAttribute("verify_error", "The passwords do not match");
			return "signup";
		}
		if(!User.isValidPassword(password)){
			model.addAttribute("email", email);
			model.addAttribute("password_error", "This is an invalid password");
			return "signup";
		}		
		if(!User.isValidEmail(email)){
			model.addAttribute("email", email);
			model.addAttribute("email_error", "This is an invalid email");
			return "signup";
		}

		
		User user = new User(email, password, false);
		userDao.save(user);
		setUserInSession(request.getSession(), user);
		
		return "redirect: /signin";
	}
	
	
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signout(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:/preview";
	}
	
	
}
