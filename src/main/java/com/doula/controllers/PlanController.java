package com.doula.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doula.models.Plan;
import com.doula.models.User;

@Controller
public class PlanController extends AbstractController {
	
	
	
	@RequestMapping(value = "/u/myplan", method = RequestMethod.GET)
	public String myplanForm(HttpServletRequest request, Model model){
		User user = getUserFromSession(request.getSession());
		int planuid = user.getPlan().getUid();
		Plan plan = planDao.findByUid(planuid);
		model.addAttribute("plan", plan);
		return "plan";
	}
	
	
	
	@RequestMapping(value = "/u/myplan", method = RequestMethod.POST)
	public String myplan(HttpServletRequest request, Model model){
		User user = getUserFromSession(request.getSession());
		int planuid = user.getPlan().getUid();
		Plan plan = planDao.findByUid(planuid);
		boolean change = false;
		
		//Get every field and check if they are different from existing fields, if so reset them.
		String doctor = request.getParameter("doctor");
		if(!doctor.equals(plan.getDoctor())){
			plan.setDoctor(doctor);
			change = true;
		}
		
		String pedi = request.getParameter("pedi");
		if(!pedi.equals(plan.getPedi())){
			plan.setPedi(pedi);
			change = true;
		}
		
		String doula = request.getParameter("doula");
		if(!doula.equals(plan.getDoula())){
			plan.setDoula(doula);
			change = true;
		}
		
		
		String coordinator = request.getParameter("coordinator");
		if(!coordinator.equals(plan.getCoordinator())){
			plan.setCoordinator(coordinator);
			change  = true;
		}
		
		String doer1 = request.getParameter("doer1");
		String doer2 = request.getParameter("doer2");
		String doer3 = request.getParameter("doer3");
		ArrayList<String> doers = plan.getDoers();
		if(!doers.get(0).equals(doer1)){
			plan.setDoersAt(0, doer1);
			change = true;
		}
		if(!doers.get(1).equals(doer2)){
			plan.setDoersAt(1, doer2);
			change = true;
		}
		if(!doers.get(2).equals(doer3)){
			plan.setDoersAt(2, doer3);
			change = true;
		}
		
		
		String encourager1 = request.getParameter("encourager1");
		String encourager2 = request.getParameter("encourage2");
		String encourager3 = request.getParameter("encourager3");
		ArrayList<String> encouragers = plan.getEncouragers();
		if(!encouragers.get(0).equals(encourager1)){
			plan.setEncouragersAt(0, encourager1);
			change = true;
		}
		if(!encouragers.get(1).equals(encourager2)){
			plan.setEncouragersAt(1, encourager2);
			change = true;
		}
		if(!encouragers.get(2).equals(encourager3)){
			plan.setEncouragersAt(2, encourager3);
			change = true;
		}
		
		String emergencyFood1 = request.getParameter("emergencyFood1");
		String emergencyFood2 = request.getParameter("emergencyFood2");
		String emergencyFood3 = request.getParameter("emergencyFood3");
		ArrayList<String> emergencyFood = plan.getEmergencyFood();
		if(!emergencyFood.get(0).equals(emergencyFood1)){
			plan.setEmergencyFoodAt(0, emergencyFood1);
			change = true;
		}
		if(!emergencyFood.get(1).equals(emergencyFood2)){
			plan.setEmergencyFoodAt(1, emergencyFood2);
			change = true;
		}
		if(!emergencyFood.get(2).equals(emergencyFood3)){
			plan.setEmergencyFoodAt(2, emergencyFood3);
			change = true;
		}
		
		String pantry1 = request.getParameter("pantry1");
		String pantry2 = request.getParameter("pantry2");
		String pantry3 = request.getParameter("pantry3");
		ArrayList <String> pantry = plan.getPantry();
		if(!pantry.get(0).equals(pantry1)){
			plan.setPantryAt(0, pantry1);
			change = true;
		}
		if(!pantry.get(1).equals(pantry2)){
			plan.setPantryAt(1, pantry2);
			change = true;
		}
		if(!pantry.get(2).equals(pantry3)){
			plan.setPantryAt(2, pantry3);
			change = true;
		}
		
		String chore1 = request.getParameter("chore1");
		String chore2 = request.getParameter("chore2");
		String chore3 = request.getParameter("chore3");
		ArrayList <String> chores = plan.getChores();
		if(!chores.get(0).equals(chore1)){
			plan.setChoresAt(0, chore1);
			change = true;
		}
		if(!chores.get(1).equals(chore2)){
			plan.setChoresAt(1, chore2);
			change = true;
		}
		if(!chores.get(2).equals(chore3)){
			plan.setChoresAt(2, chore3);
			change = true;
		}
		
		String sitter1 = request.getParameter("sitter1");
		String sitter2 = request.getParameter("sitter2");
		String sitter3 = request.getParameter("sitter3");
		ArrayList <String> sitters = plan.getSitters();
		if(!sitters.get(0).equals(sitter1)){
			plan.setSittersAt(0, sitter1);
			change = true;
		}
		if(!sitters.get(1).equals(sitter2)){
			plan.setSittersAt(1, sitter2);
			change = true;
		}
		if(!sitters.get(2).equals(sitter3)){
			plan.setSittersAt(2, sitter3);
			change = true;
		}
		
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String date3 = request.getParameter("date3");
		ArrayList <String> dates = plan.getDates();
		if(!dates.get(0).equals(date1)){
			plan.setDatesAt(0, date1);
			change = true;
		}
		if(!dates.get(1).equals(date2)){
			plan.setDatesAt(1, date2);
			change = true;
		}
		if(!dates.get(2).equals(date3)){
			plan.setDatesAt(2, date3);
			change = true;
		}
		
		String outting1 = request.getParameter("outting1");
		String outting2 = request.getParameter("outting2");
		String outting3 = request.getParameter("outting3");
		ArrayList<String> outtings = plan.getOuttings();
		if(!outtings.get(0).equals(outting1)){
			plan.setOuttingsAt(0, outting1);
			change = true;
		}
		if(!outtings.get(1).equals(outting2)){
			plan.setOuttingsAt(1, outting2);
			change = true;
		}
		if(!outtings.get(2).equals(outting3)){
			plan.setOuttingsAt(2, outting3);
			change = true;
		}
		
		String lactator1 = request.getParameter("lactator1");
		String lactator2 = request.getParameter("lactator2");
		String lactator3 = request.getParameter("lactator3");
		ArrayList <String> lactators = plan.getLactators();
		if(!lactators.get(0).equals(lactator1)){
			plan.setLactactorsAt(0, lactator1);
			change = true;
		}
		if(!lactators.get(1).equals(lactator2)){
			plan.setLactactorsAt(1, lactator2);
			change = true;
		}
		if(!lactators.get(2).equals(lactator3)){
			plan.setLactactorsAt(2, lactator3);
			change = true;
		}
		
		String moodyPeople1 = request.getParameter("moodyPeople1");
		String moodyPeople2 = request.getParameter("moodyPeople2");
		String moodyPeople3 = request.getParameter("moodyPeople3");
		ArrayList <String> moodyPeople = plan.getMoodyPeople();
		if(!moodyPeople.get(0).equals(moodyPeople1)){
			plan.setMoodyPeopleAt(0, moodyPeople1);
			change = true;
		}
		if(!moodyPeople.get(1).equals(moodyPeople2)){
			plan.setMoodyPeopleAt(1, moodyPeople2);
			change = true;
		}
		if(!moodyPeople.get(2).equals(moodyPeople3)){
			plan.setMoodyPeopleAt(2, moodyPeople3);
			change = true;
		}
		
		
		model.addAttribute("plan", plan);
		if(change){
			planDao.save(plan);
		}
		return "plan";
	}
		
}
