package com.doula.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "definition")
public class Definition extends AbstractEntity{
	
	
	//ATTRIBUTES
	@NotNull
	@Column(name = "created")
	private Date created;
	
	@NotNull
	@Column(name = "updated")
	private Date updated;
	
	@NotNull
	@Column(name = "title")
	private String title;
	
	@NotNull
	@Column(name = "body")
	private String body;

	
	
	//CONSTRUCTORS
	public Definition() {}
	
	public Definition(String title, String body){
		
		super();
		
		this.created = new Date();
		this.updated = this.created;
		this.body = body;
		this.title = title;
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
	
	
	
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	
	
	
	public String getBody(){
		return this.body;
	}
	public void setBody(String body){
		this.body = body;
	}
	
	
	
	//METHODS
	public void modified(){
		this.updated = new Date();
	}
}
