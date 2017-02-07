package com.doula.models;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "plan")
public class Plan extends AbstractEntity {

	//ATTRIBUTES
	private Date created;
	private Date updated;
	private User owner;
	private String doctor;
	private String pedi;
	private String doula;
	private String coordinator;
	private ArrayList<String> doers;
	private ArrayList<String> encouragers;
	private ArrayList<String> emergencyFood;
	private ArrayList<String> pantry;
	private ArrayList<String> chores;
	private ArrayList<String> sitters;
	private ArrayList<String> dates;
	private ArrayList<String> outtings;
	private ArrayList<String> lactators;
	private ArrayList<String> moodyPeople;
	
	//CONSTRUCTORS
	public Plan(){}
	
	public Plan(User owner){
		super();
		
		this.created = new Date();
		this.updated = this.created;
		this.owner = owner;
		
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
	
	//GETTERS
	@NotNull
	@Column(name = "created")
	public Date getCreated(){
		return this.created;
	}
	@NotNull
	@Column(name = "updated")
	public Date getUpdated(){
		return this.updated;
	}
	@OneToOne(mappedBy = "plan")
	@NotNull
	@Column(name = "owner")
	public User getOwner(){
		return this.owner;
	}
	@Column(name = "doctor")
	public String getDoctor(){
		return this.doctor;
	}
	@Column(name = "pedi")
	public String getPedi(){
		return this.pedi;
	}
	@Column(name = "doula")
	public String getDoula(){
		return this.doula;
	}
	@Column(name = "coordinator")
	public String getCoordinator(){
		return this.coordinator;
	}
	@Column(name = "doers")
	public ArrayList<String> getDoers(){
		return this.doers;
	}
	@Column(name = "encouragers")
	public ArrayList<String> getEncouragers(){
		return this.encouragers;
	}
	@Column(name = "emergency_food")
	public ArrayList<String> getEmergencyFood(){
		return this.emergencyFood;
	}
	@Column(name = "pantry")
	public ArrayList<String> getPantry(){
		return this.pantry;
	}
	@Column(name = "chores")
	public ArrayList<String> getChores(){
		return this.chores;
	}
	@Column(name = "sitters")
	public ArrayList<String> getSitters(){
		return this.sitters;
	}
	@Column(name = "dates")
	public ArrayList<String> getDates(){
		return this.dates;
	}
	@Column(name = "outtings")
	public ArrayList<String> getOuttings(){
		return this.outtings;
	}
	@Column(name = "lactators")
	public ArrayList<String> getLactators(){
		return this.lactators;
	}
	@Column(name = "moody_people")
	public ArrayList<String> getMoodyPeople(){
		return this.moodyPeople;
	}
	
	//SETTERS
	public void setCreated(Date created){
		this.created = created;
	}
	public void setUpdated(Date updated){
		this.updated = updated;
	}
	public void setOwner(User owner){
		this.owner = owner;
	}
	public void setDoctor(String doctor){
		this.doctor = doctor;
	}
	public void setPedi(String pedi){
		this.pedi = pedi;
	}
	public void setDoula(String doula){
		this.doula = doula;
	}
	public void setCoordinator(String coord){
		this.coordinator = coord;
	}
	public void setDoers(ArrayList<String> input){
		this.doers = input;
	}
	public void setEncouragers(ArrayList<String> input){
		this.encouragers = input;
	}
	public void setEmergencyFood(ArrayList<String> input){
		this.emergencyFood = input;
	}
	public void setPantry(ArrayList<String> input){
		this.pantry = input;
	}
	public void setChores(ArrayList<String> input){
		this.chores = input;
	}
	public void setSitters(ArrayList<String> input){
		this.sitters = input;
	}
	public void setDates(ArrayList<String> input){
		this.dates = input;
	}
	public void setOuttings(ArrayList<String> input){
		this.outtings = input;
	}
	public void setLactators(ArrayList<String> input){
		this.lactators = input;
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
