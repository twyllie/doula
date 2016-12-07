package com.doula.models;

public class Article extends AbstractEntity{

	//ATTRIBUTES
	private String title;
	private String body;
	
	//TODO:Article: Some way of implementing thumbnail image
	//TODO:Article: Some way of implementing header image
	//TODO:Article: Some way of implementing in-content images.
	
	//CONSTRUCTORS
	//TODO:Article: Implement constructor
		
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
