package com.doula.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class AbstractEntity {

	
	@Id
    @GeneratedValue
    @NotNull
    @Column(name = "uid", unique = true)
	private int uid;
	
	
	
	public int getUid() {
		return this.uid;
	}
	protected void setUid(int uid) {
        this.uid = uid;
    }
	
	
}