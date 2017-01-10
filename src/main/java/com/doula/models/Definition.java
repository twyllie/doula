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
	private Date created;
	private Date updated;
	private String title;
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
	@Column(name = "title")
	public String getTitle(){
		return this.title;
	}
	@NotNull
	@Column(name = "body")
	public String getBody(){
		return this.body;
	}
	
	//SETTERS
	public void setCreated(Date created){
		this.created = created;
	}
	public void setUpdated(Date updated){
		this.updated = updated;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setBody(String body){
		this.body = body;
	}
	
	//METHODS
	public void modified(){
		this.updated = new Date();
	}
}
