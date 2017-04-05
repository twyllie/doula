package com.doula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "headline")
public class Headline extends AbstractEntity {
	
	@Column(name = "title")
	private String title;
	
	
	
	@Column(name = "body")
	private String body;
	
	
	
	protected Headline(){}
	
	
	
	public Headline(String title, String body){
		super();
		
		this.title = title;
		this.body = body;
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

}
