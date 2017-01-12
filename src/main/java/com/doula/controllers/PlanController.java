package com.doula.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doula.models.Plan;
import com.doula.models.User;

@Controller
public class PlanController extends AbstractController {
	
	@RequestMapping(value = "/myplan", method = RequestMethod.GET)
	public String myplanForm(HttpServletRequest request, Model model){
		User user = getUserFromSession(request.getSession());
		Plan plan = user.getPlan();
		model.addAttribute("plan", plan);
		return "plan";
	}
	
	@RequestMapping(value = "/myplan", method = RequestMethod.POST)
	public String myplan(HttpServletRequest request, Model model){
		User user = getUserFromSession(request.getSession());
		Plan plan = user.getPlan();
		model.addAttribute("plan", plan);
		return "plan";
	}
}
