package com.doula.models;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "plan")
public class Plan extends AbstractEntity {

	//ATTRIBUTES
	@NotNull
	@Column(name = "created")
	private Date created;
	
	@NotNull
	@Column(name = "updated")
	private Date updated;
	
	@Column(name = "doctor")
	private String doctor;
	
	@Column(name = "pedi")
	private String pedi;
	
	@Column(name = "doula")
	private String doula;
	
	@Column(name = "coordinator")
	private String coordinator;
	
	@Column(name = "doers")
	private ArrayList<String> doers;
	
	@Column(name = "encouragers")
	private ArrayList<String> encouragers;
	
	@Column(name = "emergency_food")
	private ArrayList<String> emergencyFood;
	
	@Column(name = "pantry")
	private ArrayList<String> pantry;
	
	@Column(name = "chores")
	private ArrayList<String> chores;
	
	@Column(name = "sitters")
	private ArrayList<String> sitters;
	
	@Column(name = "dates")
	private ArrayList<String> dates;
	
	@Column(name = "outtings")
	private ArrayList<String> outtings;
	
	@Column(name = "lactators")
	private ArrayList<String> lactators;
	
	@Column(name = "moody_people")
	private ArrayList<String> moodyPeople;
	
	//CONSTRUCTORS
	public Plan(){}
	
	public Plan(Date time){
		super();
		
		this.created = time;
		this.updated = this.created;
		
		for(int i = 0; i < 3; i++){
			this.doers.add("");
			this.encouragers.add("");
			this.emergencyFood.add("");
			this.pantry.add("");
			this.chores.add("");
			this.sitters.add("");
			this.dates.add("");
			this.outtings.add("");
			this.lactators.add("");
			this.moodyPeople.add("");
		}
		
	}
	
	//GETTERS / SETTERS
	public Date getCreated(){
		return this.created;
	}
	public void setCreated(Date created){
		this.created = created;
	}
	
	
	
	public Date getUpdated(){
		return this.updated;
	}
	public void setUpdated(Date updated){
		this.updated = updated;
	}
	
	
	
	public String getDoctor(){
		return this.doctor;
	}
	public void setDoctor(String doctor){
		this.doctor = doctor;
	}
	
	
	
	public String getPedi(){
		return this.pedi;
	}
	public void setPedi(String pedi){
		this.pedi = pedi;
	}
	
	
	
	public String getDoula(){
		return this.doula;
	}
	public void setDoula(String doula){
		this.doula = doula;
	}
	
	
	
	public String getCoordinator(){
		return this.coordinator;
	}
	public void setCoordinator(String coord){
		this.coordinator = coord;
	}
	
	
	
	public ArrayList<String> getDoers(){
		return this.doers;
	}
	public void setDoers(ArrayList<String> input){
		this.doers = input;
	}
	
	
	
	public ArrayList<String> getEncouragers(){
		return this.encouragers;
	}
	public void setEncouragers(ArrayList<String> input){
		this.encouragers = input;
	}
	
	
	
	public ArrayList<String> getEmergencyFood(){
		return this.emergencyFood;
	}
	public void setEmergencyFood(ArrayList<String> input){
		this.emergencyFood = input;
	}
	
	
	
	public ArrayList<String> getPantry(){
		return this.pantry;
	}
	public void setPantry(ArrayList<String> input){
		this.pantry = input;
	}
	
	
	
	public ArrayList<String> getChores(){
		return this.chores;
	}
	public void setChores(ArrayList<String> input){
		this.chores = input;
	}
	
	
	
	public ArrayList<String> getSitters(){
		return this.sitters;
	}
	public void setSitters(ArrayList<String> input){
		this.sitters = input;
	}
	
	
	
	public ArrayList<String> getDates(){
		return this.dates;
	}
	public void setDates(ArrayList<String> input){
		this.dates = input;
	}
	
	
	
	public ArrayList<String> getOuttings(){
		return this.outtings;
	}
	public void setOuttings(ArrayList<String> input){
		this.outtings = input;
	}
	
	
	
	public ArrayList<String> getLactators(){
		return this.lactators;
	}
	public void setLactators(ArrayList<String> input){
		this.lactators = input;
	}
	
	
	
	public ArrayList<String> getMoodyPeople(){
		return this.moodyPeople;
	}
	public void setMoodyPeople(ArrayList<String> input){
		this.moodyPeople = input;
	}
	
	
	
	
	//METHODS
	public void modified(){
		this.updated = new Date();
	}
	
	
	
	public void addDoers(String doer){
		this.doers.add(doer);
	}
	public void setDoersAt(int index, String doer){
		this.doers.set(index, doer);
	}
	
	
	
	public void addEncouragers(String encourager){
		this.encouragers.add(encourager);
	}
	public void setEncouragersAt(int index, String encourager){
		this.encouragers.set(index, encourager);
	}
	
	
	
	public void addEmergencyFood(String ef){
		this.emergencyFood.add(ef);
	}
	public void setEmergencyFoodAt(int index, String ef){
		this.emergencyFood.set(index, ef);
	}
	
	
	
	public void addPantry(String item){
		this.pantry.add(item);
	}
	public void setPantryAt(int index, String item){
		this.pantry.set(index, item);
	}
	
	
	
	public void addChores(String chore){
		this.chores.add(chore);
	}
	public void setChoresAt(int index, String chore){
		this.chores.set(index, chore);
	}
	
	
	
	public void addSitters(String sitter){
		this.sitters.add(sitter);
	}
	public void setSittersAt(int index, String sitter){
		this.sitters.set(index, sitter);
	}
	
	
	
	public void addDates(String date){
		this.dates.add(date);
	}
	public void setDatesAt(int index, String date){
		this.dates.set(index, date);
	}
	
	
	
	public void addOuttings(String outting){
		this.outtings.add(outting);
	}
	public void setOuttingsAt(int index, String outting){
		this.outtings.set(index, outting);
	}
	
	
	
	public void addLactators(String lactator){
		this.lactators.add(lactator);
	}
	public void setLactactorsAt(int index, String lactator){
		this.lactators.set(index, lactator);
	}
	
	
	
	public void addMoodyPeople(String moody){
		this.moodyPeople.add(moody);
	}
	public void setMoodyPeopleAt(int index, String moody){
		this.moodyPeople.set(index, moody);
	}
	
}
