package com.doula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "definition")
public class Definition extends AbstractEntity{
	
	
	//ATTRIBUTES
	private String title;
	private String body;

	
	//CONSTRUCTORS
	public Definition() {}
	
	public Definition(String title, String body){
		
		super();
		
		this.body = body;
		this.title = title;
	}
	
	//GETTERS
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
	public void setTitle(String title){
		this.title = title;
	}
	public void setBody(String body){
		this.body = body;
	}
	
	//METHODS
}
