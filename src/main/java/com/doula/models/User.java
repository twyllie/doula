package com.doula.models;

import java.util.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	@ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	
	
	//CONSTRUCTORS
	public User(){}
	
	public User(String email, String password){
		
		super();
		
		this.created = new Date();
		this.updated = created;
		this.email = email;
		this.pwHash = password;
		this.plan = new Plan(this.created);
		
		
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
	
	
	
	public Set<Role> getRoles(){
		return this.roles;
	}
	public void setRoles(Set<Role> roles){
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
	
}
