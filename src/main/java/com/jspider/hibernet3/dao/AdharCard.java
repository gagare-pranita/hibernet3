package com.jspider.hibernet3.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class AdharCard {
	@Id
	private int id;
	private long adharno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAdharno() {
		return adharno;
	}
	public void setAdharno(long adharno) {
		this.adharno = adharno;
	}
	@Override
	public String toString() {
		return "AdharCard [id=" + id + ", adharno=" + adharno + ", getId()=" + getId() + ", getAdharno()="
				+ getAdharno() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
