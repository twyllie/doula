package com.doula.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "user")
public class User extends AbstractEntity{
	
	
	//ATTRIBUTES
	private String email;
	private String pwHash;
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	//TODO:User: figure out some way of storing user information for the Doula Journey.

	//CONSTRUCTORS
	public User(){}
	
	public User(String email, String password){
		
		super();
		
		this.email = email;
		this.pwHash = hashPassword(password);
		
	}
		
	//GETTERS
	@NotNull
    @Column(name = "email", unique = true)
	public String getEmail(){
		return this.email;
	}
	@NotNull
    @Column(name = "pwhash")
	public String getPwHash(){
		return this.pwHash;
	}
	
	
	//SETTERS
	@SuppressWarnings("unused")
	public void setEmail(String email){
		this.email = email;
	}
	@SuppressWarnings("unused")
	public void setPwHash(String pw){
		this.pwHash = pw;
	}

	
	//METHODS
	public static boolean isValidPassword(String password){
		Pattern validUsernamePattern = Pattern.compile("(\\S){6,30}");
		Matcher matcher = validUsernamePattern.matcher(password);
		return matcher.matches();
	}
	public static boolean isValidEmail(String email){
		Pattern validEmailPattern = Pattern.compile("^[A-Z0-9+_.-]+@[A-Z0-9.-]+$");
		Matcher matcher = validEmailPattern.matcher(email);
		return matcher.matches();
	}
	private static String hashPassword(String password) {		
		return encoder.encode(password);
	}
	public boolean isMatchingPassword(String password){
		return encoder.matches(password, pwHash);
	}
}
