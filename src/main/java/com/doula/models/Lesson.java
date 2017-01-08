package com.doula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lesson")
public class Lesson extends AbstractEntity{

	
	//ATTRIBUTES
	private String title;
	private String body;
	private int orderId;
	private	String videoRef;
	
	//CONSTRUCTORS
	public Lesson(){}
	
	public Lesson(String title, String body, int oid, String videoRef){
		super();
		
		this.title = title;
		this.body = body;
		this.orderId = oid;
		this.videoRef = videoRef;
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
	@NotNull
	@Column(name = "orderId")
	public int getOrderId(){
		return this.orderId;
	}
	@NotNull
	@Column(name = "videoRef")
	public String getVideoRef(){
		return this.videoRef;
	}
	
	//SETTERS
	public void setTitle(String title){
		this.title = title;
	}
	public void setBody(String body){
		this.body = body;
	}
	public void setOrderId(int oid){
		this.orderId = oid;
	}
	public void setVideoRef(String ref){
		this.videoRef = ref;
	}
	
	
	//METHODS
}
