package com.doula.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lesson")
public class Lesson extends AbstractEntity{

	
	
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
	@Column(name = "body", columnDefinition="TEXT")
	private String body;
	
	@NotNull
	@Column(name = "orderId")
	private int orderId;
	
	@NotNull
	@Column(name = "videoRef")
	private	String videoRef;
	
	
	
	//CONSTRUCTORS
	public Lesson(){}
	
	public Lesson(String title, String body, int oid, String videoRef){
		super();
		
		this.created = new Date();
		this.updated = this.created;
		this.title = title;
		this.body = body;
		this.orderId = oid;
		this.videoRef = videoRef;
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
	
	
	
	public int getOrderId(){
		return this.orderId;
	}
	public void setOrderId(int oid){
		this.orderId = oid;
	}
	
	
	
	public String getVideoRef(){
		return this.videoRef;
	}
	public void setVideoRef(String ref){
		this.videoRef = ref;
	}
	
	
	
	
	//METHODS
	public void modified(){
		this.updated = new Date();
	}
}
