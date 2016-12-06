package com.doula.models;

public class User extends AbstractEntity{
	
	
	//ATTRIBUTES
	private String username;
	private String email;
	private String pwHash;
	private String scope;
	
	//TODO: figure out some way of storing user information for the Doula Journey.
	//TODO: figure out some kind of image object for profile pics

	//CONSTRUCTORS
	//TODO: create constructors
	
	//GETTERS
	public String getUsername(){
		return this.username;
	}
	public String getEmail(){
		return this.email;
	}
	public String getPwHash(){
		return this.pwHash;
	}
	public String getScope(){
		return this.scope;
	}
	
	
	//SETTERS
	public void setUsername(String username){
		this.username = username;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setPwHash(String pw){
		this.pwHash = pw;
	}
	public void setScope(String scope){
		this.scope = scope;
	}
	
	//METHODS
	public static boolean isValidUsername(String username){
		//TODO: Implement some kind of username regex
	}
	public static boolean isValidPassword(String pw){
		//TODO: Implement some kind of password regex
	}
	public static boolean isValidEmail(String email){
		//TODO: Implement some kind of email regex
	}
}
