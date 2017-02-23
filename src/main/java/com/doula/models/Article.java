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
	@Column(name = "headline")
	private String headline;
	
	@NotNull
	@Column(name = "body")
	private String body;
	
	@Column(name = "thumbnailRef")
	private String thumbnailRef;
	
	@Column(name = "headerRef")
	private String headerRef;
	
	@Column(name = "bodyImageRef")
	private String bodyImageRef;

	
	//CONSTRUCTORS
	public Article(){}
	
	public Article(String title, String headline, String body){
		super();
		
		this.created = new Date();
		this.updated = this.created;
		this.title = title;
		this.headline = headline;
		this.body = body;
	}
	
	
	
	//GETTERS / SETTERS
	public Date getCreated(){
		return this.created;
	}
	public void setCreated(Date date){
		this.created = date;
	}
	
	
	public Date getUpdated(){
		return this.updated;
	}
	public void setUpdated(Date date){
		this.updated = date;
	}
	
	
	
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	
	
	
	public String getHeadline(){
		return this.headline;
	}
	public void setHeadline(String headline){
		this.headline = headline;
	}
	
	
	public String getBody(){
		return this.body;
	}
	public void setBody(String body){
		this.body = body;
	}
	
	
	
	public String getThumbnailRef(){
		return this.thumbnailRef;
	}
	public void setThumbnailRef(String ref){
		this.thumbnailRef = ref;
	}
	
	
	
	public String getHeaderRef(){
		return this.headerRef;
	}
	public void setHeaderRef(String ref){
		this.headerRef = ref;
	}
	
	
	
	public String getBodyImageRef(){
		return this.bodyImageRef;
	}
	public void setBodyImageRef(String ref){
		this.bodyImageRef = ref;
	}
	
	
	
	//METHODS
	public void modified(){
		this.updated = new Date();
	}
}
