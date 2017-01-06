package com.doula.models;

public class User extends AbstractEntity{
	
	
	//ATTRIBUTES
	private String email;
	private String pwHash;
	//TODO:User: figure out some way of storing user information for the Doula Journey.

	//CONSTRUCTORS
	public User(){}
	
	public User(String email, String password){
		this.email = email;
		this.pwHash = password;
		
	}
	//TODO:User: create constructors
	
	//GETTERS
	public String getEmail(){
		return this.email;
	}
	public String getPwHash(){
		return this.pwHash;
	}
	
	
	//SETTERS
	public void setEmail(String email){
		this.email = email;
	}
	public void setPwHash(String pw){
		this.pwHash = pw;
	}

	
	//METHODS
	public static boolean isValidPassword(String pw){
		//TODO:User: Implement some kind of password regex
	}
	public static boolean isValidEmail(String email){
		//TODO:User: Implement some kind of email regex
	}
	
	public boolean isMatchingPassword(String password){
		//TODO:User: Implement password check.
	}
}
