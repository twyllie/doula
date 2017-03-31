package com.doula.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity{
	
	
	@Column(name="user")
	private String name;
	
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	
	
	
	protected Role(){}
	
	public Role(String name){
		super();
		
		this.name = name;
	}
	
	
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	
	
	public Set<User> getUsers(){
		return this.users;
	}
	public void setUsers(Set<User> users){
		this.users = users;
	}

}
