package com.doula.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doula.models.Plan;
import com.doula.models.User;
import com.doula.services.MySecurityService;

@Controller
public class PlanController extends AbstractController {
	
	
	
	@Autowired
	MySecurityService securityService;
	
	
	
	@RequestMapping(value = "/u/myplan", method = RequestMethod.GET)
	public String myplanForm(HttpServletRequest request, Model model){
		User user = userDao.findByEmail(securityService.findLoggedInUsername());
		Plan plan = user.getPlan();
		model.addAttribute("plan", plan);
		return "plan";
	}
	
	
	
	@RequestMapping(value = "/u/myplan", method = RequestMethod.POST)
	public String myplan(HttpServletRequest request, Model model){
		User user = userDao.findByEmail(securityService.findLoggedInUsername());
		Plan plan = user.getPlan();
		model.addAttribute("plan", plan);
		boolean change = false;
		
		
		
		//Get every field and check if they are different from existing fields, if so reset them.
		String doctor = request.getParameter("doctor");
		if(plan.getDoctor() == null){
			plan.setDoctor(doctor);
			change = true;
		}
		else if(!doctor.equals(plan.getDoctor())){
			plan.setDoctor(doctor);
			change = true;
		}
		
		
		
		String pedi = request.getParameter("pedi");
		if(plan.getPedi() == null){
			plan.setPedi(pedi);
			change = true;
		}
		else if(!pedi.equals(plan.getPedi())){
			plan.setPedi(pedi);
			change = true;
		}
		
		
		
		String doula = request.getParameter("doula");
		if(plan.getDoula() == null){
			plan.setDoula(doula);
			change = true;
		}
		else if(!doula.equals(plan.getDoula())){
			plan.setDoula(doula);
			change = true;
		}
		
		
		
		String coordinator = request.getParameter("coordinator");
		if(plan.getCoordinator() == null){
			plan.setCoordinator(coordinator);
			change = true;
		}
		else if(!coordinator.equals(plan.getCoordinator())){
			plan.setCoordinator(coordinator);
			change  = true;
		}
		
		
		//Protective null shield
		String doerCounterS = request.getParameter("doerCounter");
		if(doerCounterS != null){
			//Get the number of elements that the form has sent.
			int doerCounter = Integer.parseInt(doerCounterS);
			//Get the collection that Plan already has, for comparison
			ArrayList<String> doers = plan.getDoers();
			//Iterate through the received elements to see if they are different from the present ones.
			for(int i=0; i <= doerCounter; i++){
				String doer = request.getParameter("doer"+i);
				//See if the current received doer is in the collection already.
				if(doers.size() >= i){
					//If it is, see if it has changed and update accordingly.
					if(!doers.get(i).equals(doer)){
						plan.setDoersAt(i, doer);
						change = true;
					}
				}else{
					//If it isn't, add it.
					plan.addDoers(doer);
					change = true;
				}
				
			}
		}
		
		
		
		String encouragerCounterS = request.getParameter("encouragerCounter");
		if(encouragerCounterS != null){
			int encouragerCounter = Integer.parseInt(request.getParameter("encouragerCounter"));
			ArrayList<String> encouragers = plan.getEncouragers();
			for(int i=0; i <= encouragerCounter;i++){
				String encourager = request.getParameter("encourager"+i);
				if(encouragers.size() >= i){
					if(!encouragers.get(i).equals(encourager)){
						plan.setEncouragersAt(i, encourager);
						change = true;
					}
				}else{
					plan.addEncouragers(encourager);
					change = true;
				}
			}
		}
		
		
		
		String foodCounterS = request.getParameter("foodCounter");
		if(foodCounterS != null){
			int foodCounter = Integer.parseInt(request.getParameter("foodCounter"));
			ArrayList<String> emergencyFoods = plan.getEmergencyFoods();
			for(int i=0; i <= foodCounter; i++){
				String emergencyFood = request.getParameter("emergencyFood"+i);
				if(emergencyFoods.size() >= i){
					if(!emergencyFoods.get(i).equals(emergencyFood)){
						plan.setEmergencyFoodAt(i, emergencyFood);
						change = true;
					}
				}else{
					plan.addEmergencyFood(emergencyFood);
					change = true;
				}
			}
		}
		
		
		
		String pantryCounterS = request.getParameter("pantryCounter");
		if(pantryCounterS != null){
			int pantryCounter = Integer.parseInt(request.getParameter("pantryCounter"));
			ArrayList<String> pantry = plan.getPantry();
			for(int i=0; i <= pantryCounter; i++){
				String pantryItem = request.getParameter("pantryItem"+i);
				if(pantry.size() >= i){
					if(!pantry.get(i).equals(pantryItem)){
						plan.setPantryAt(i, pantryItem);
						change = true;
					}
				}else{
					plan.addPantry(pantryItem);
					change = true;
				}
			}
		}
		
		
		
		String choreCounterS = request.getParameter("choreCounter");
		if(choreCounterS != null){
			int choreCounter = Integer.parseInt(request.getParameter("choreCounter"));
			ArrayList<String> chores = plan.getChores();
			for(int i=0; i <= choreCounter; i++){
				String chore = request.getParameter("chore"+i);
				if(chores.size() >= i){
					if(!chores.get(i).equals(chore)){
						plan.setChoresAt(i, chore);
						change = true;
					}
				}else{
					plan.addChores(chore);
					change = true;
				}
			}
		}
		
		
		
		String sitterCounterS = request.getParameter("sitterCounter");
		if(sitterCounterS != null){
			int sitterCounter = Integer.parseInt(request.getParameter("sitterCounter"));
			ArrayList<String> sitters = plan.getSitters();
			for(int i =0; i <= sitterCounter; i++){
				String sitter = request.getParameter("sitter"+i);
				if(sitters.size() >= i){
					if(!sitters.get(i).equals(sitter)){
						plan.setSittersAt(i, sitter);
						change = true;
					}
				}else{
					plan.addSitters(sitter);
					change = true;
				}
			}
		}
		
		
		
		String dateCounterS = request.getParameter("dateCounter");
		if(dateCounterS != null){
			int dateCounter = Integer.parseInt(request.getParameter("dateCounter"));
			ArrayList<String> dates = plan.getDates();
			for(int i =0; i <= dateCounter; i++){
				String date = request.getParameter("date"+i);
				if(dates.size() >= i){
					if(!dates.get(i).equals(date)){
						plan.setDatesAt(i, date);
						change = true;
					}
				}else{
					plan.addDates(date);
					change = true;
				}
			}
		}
		
		
		
		String outCounterS = request.getParameter("outCounter");
		if(outCounterS != null){
			int outCounter = Integer.parseInt(request.getParameter("outCounter"));
			ArrayList<String> outtings = plan.getOuttings();
			for(int i =0; i <= outCounter; i++){
				String outting = request.getParameter("outting"+i);
				if(outtings.size() >= i){
					if(!outtings.get(i).equals(outting)){
						plan.setOuttingsAt(i, outting);
						change = true;
					}
				}else{
					plan.addOuttings(outting);
					change = true;
				}
			}
		}
		
		
		
		String lactCounterS = request.getParameter("lactCounter");
		if(lactCounterS != null){
			int lactCounter = Integer.parseInt(request.getParameter("lactCounter"));
			ArrayList<String> lactators = plan.getLactators();
			for(int i =0; i <= lactCounter; i++){
				String lactator = request.getParameter("lactator"+i);
				if(lactators.size() >= i){
					if(!lactators.get(i).equals(lactator)){
						plan.setLactactorsAt(i, lactator);
						change = true;
					}
				}else{
					plan.addLactators(lactator);
					change = true;
				}
			}
		}
		
		
		
		String moodyCounterS = request.getParameter("moodyCounter");
		if(moodyCounterS != null){
			int moodyCounter = Integer.parseInt(request.getParameter("moodyCounter"));
			ArrayList<String> moodyPeople = plan.getMoodyPeople();
			for(int i =0; i <= moodyCounter; i++){
				String moodyPerson = request.getParameter("moodyPerson"+i);
				if(moodyPeople.size() >= i){
					if(!moodyPeople.get(i).equals(moodyPerson)){
						plan.setMoodyPeopleAt(i, moodyPerson);
						change = true;
					}
				}else{
					plan.addMoodyPeople(moodyPerson);
					change = true;
				}
			}
		}
		
		
		
		model.addAttribute("plan", plan);
		if(change){
			planDao.save(plan);
		}
		return "plan";
	}
		
}
