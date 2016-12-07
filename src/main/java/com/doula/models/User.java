package com.doula.models;

import java.awt.Image;

public class User extends AbstractEntity{
	
	
	//ATTRIBUTES
	private String username;
	private String email;
	private String pwHash;
	private String scope;
	private Image profilePic;
	//TODO: figure out some way of storing user information for the Doula Journey.

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
	public Image getProfilePic(){
		return this.profilePic;
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
	public void setProfilePic(Image profilePic){
		this.profilePic = profilePic;
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
