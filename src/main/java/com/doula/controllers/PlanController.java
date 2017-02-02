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
		String doctor = request.getParameter("doctor");
		String pedi = request.getParameter("pedi");
		String doula = request.getParameter("doula");
		String coordinator = request.getParameter("coordinator");
		String doer1 = request.getParameter("doer1");
		String doer2 = request.getParameter("doer2");
		String doer3 = request.getParameter("doer3");
		String encourager1 = request.getParameter("encourager1");
		String encourager2 = request.getParameter("encourage2");
		String encourager3 = request.getParameter("encourager3");
		String emergencyFood1 = request.getParameter("emergencyFood1");
		String emergencyFood2 = request.getParameter("emergencyFood2");
		String emergencyFood3 = request.getParameter("emergencyFood3");
		String pantry1 = request.getParameter("pantry1");
		String pantry2 = request.getParameter("pantry2");
		String pantry3 = request.getParameter("pantry3");
		String chore1 = request.getParameter("chore1");
		String chore2 = request.getParameter("chore2");
		String chore3 = request.getParameter("chore3");
		String sitter1 = request.getParameter("sitter1");
		String sitter2 = request.getParameter("sitter2");
		String sitter3 = request.getParameter("sitter3");
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String date3 = request.getParameter("date3");
		String outting1 = request.getParameter("outting1");
		String outting2 = request.getParameter("outting2");
		String outting3 = request.getParameter("outting3");
		String lactator1 = request.getParameter("lactator1");
		String lactator2 = request.getParameter("lactator2");
		String lactator3 = request.getParameter("lactator3");
		String moodyPeople1 = request.getParameter("moodyPeople1");
		String moodyPeople2 = request.getParameter("moodyPeople2");
		String moodyPeople3 = request.getParameter("moodyPeople3");
		model.addAttribute("plan", plan);
		return "plan";
	}
}
