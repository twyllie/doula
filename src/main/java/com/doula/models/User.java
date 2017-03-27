package com.doula.models;

import java.util.ArrayList;
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
	@NotNull
	@Column(name = "created")
	private Date created;
	
	@NotNull
	@Column(name = "updated")
	private Date updated;
	
	@NotNull
    @Column(name = "email", unique = true)
	private String email;
	
	@NotNull
    @Column(name = "pwhash")
	private String pwHash;
	
	@OneToOne
	@JoinColumn(name = "plan_uid")
	private Plan plan;
	
	
	@Column(name = "roles")
	private ArrayList<String> roles;
	
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	
	
	//CONSTRUCTORS
	public User(){}
	
	public User(String email, String password, boolean admin){
		
		super();
		
		this.created = new Date();
		this.updated = created;
		this.email = email;
		this.pwHash = hashPassword(password);
		this.plan = new Plan(this.created);
		this.roles = new ArrayList<String>();
		this.roles.add("ROLE_USER");
		if(admin){
			this.roles.add("ROLE_ADMIN");
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
	
	
	
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	
	
	public String getPwHash(){
		return this.pwHash;
	}
	public void setPwHash(String pw){
		this.pwHash = pw;
	}
	
	
	
	public Plan getPlan(){
		return this.plan;
	}
	public void setPlan(Plan plan){
		this.plan = plan;
	}
	
	public ArrayList<String> getRoles(){
		return this.roles;
	}
	public void setRoles(ArrayList<String> roles){
		this.roles = roles;
	}
	

	
	//METHODS
	public static boolean isValidPassword(String password){
		Pattern validPasswordPattern = Pattern.compile("(\\S){6,30}");
		Matcher matcher = validPasswordPattern.matcher(password);
		return matcher.matches();
	}
	
	
	
	public static boolean isValidEmail(String email){
		Pattern validEmailPattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
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
