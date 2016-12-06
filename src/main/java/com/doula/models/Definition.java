package com.doula.models;

public class Definition extends AbstractEntity{
	
	
	//ATTRIBUTES
	private String title;
	private String body;
	//TODO: Some method of indexing these items for search
	
	//CONSTRUCTORS
	//TODO: Implement constructors
	
	//GETTERS
	public String getTitle(){
		return this.title;
	}
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
