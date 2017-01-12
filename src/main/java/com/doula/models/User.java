package com.doula.models;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "user")
public class User extends AbstractEntity{
	
	
	//ATTRIBUTES
	private Date created;
	private Date updated;
	private String email;
	private String pwHash;
	private Plan plan;	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	//CONSTRUCTORS
	public User(){}
	
	public User(String email, String password){
		
		super();
		
		this.email = email;
		this.pwHash = hashPassword(password);
		this.plan = new Plan(this);
		
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
	@OneToOne
	@JoinColumn(name = "plan_uid")
	public Plan getPlan(){
		return this.plan;
	}
	
	
	//SETTERS
	public void setCreated(Date created){
		this.created = created;
	}
	public void setUpdated(Date updated){
		this.updated = updated;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setPwHash(String pw){
		this.pwHash = pw;
	}
	public void setPlan(Plan plan){
		this.plan = plan;
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
