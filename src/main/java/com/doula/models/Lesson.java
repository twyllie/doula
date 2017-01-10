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
	private Date created;
	private Date updated;
	private String title;
	private String body;
	private int orderId;
	private	String videoRef;
	
	//CONSTRUCTORS
	public Lesson(){}
	
	public Lesson(String title, String body, int oid, String videoRef){
		super();
		
		this.created = new Date();
		this.updated = this.created;
		this.title = title;
		this.orderId = oid;
		this.videoRef = videoRef;
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
	@Column(name = "orderId", unique = true)
	public int getOrderId(){
		return this.orderId;
	}
	@NotNull
	@Column(name = "videoRef")
	public String getVideoRef(){
		return this.videoRef;
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
	public void setOrderId(int oid){
		this.orderId = oid;
	}
	public void setVideoRef(String ref){
		this.videoRef = ref;
	}
	public void setBody(String body){
		this.body = body;
	}
	
	
	//METHODS
	public void modified(){
		this.updated = new Date();
	}
}
