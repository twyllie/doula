package com.doula.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "article")
public class Article extends AbstractEntity{

	//ATTRIBUTES
	private Date created;
	private Date updated;
	private String title;
	private String body;
	private String thumbnailRef;
	private String headerRef;
	private String bodyImageRef;

	
	//CONSTRUCTORS
	public Article(){}
	
	public Article(String title, String body){
		super();
		
		this.created = new Date();
		this.updated = this.created;
		this.title = title;
		this.body = body;
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
	@Column(name = "thumbnailRef")
	public String getThumbnailRef(){
		return this.thumbnailRef;
	}
	@Column(name = "headerRef")
	public String getHeaderRef(){
		return this.headerRef;
	}
	@Column(name = "bodyImageRef")
	public String getBodyImageRef(){
		return this.bodyImageRef;
	}
	
	//SETTERS
	public void setCreated(Date date){
		this.created = date;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setBody(String body){
		this.body = body;
	}
	public void setThumbnailRef(String ref){
		this.thumbnailRef = ref;
	}
	public void setHeaderRef(String ref){
		this.headerRef = ref;
	}
	public void setBodyImageRef(String ref){
		this.bodyImageRef = ref;
	}
	
	//METHODS
	public void modified(){
		this.updated = new Date();
	}
}
