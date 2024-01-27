package com.jspider.hibernet3.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Team {
	@Id
	private int id;
	private String tName;
	private  int noofplayer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public int getNoofplayer() {
		return noofplayer;
	}
	public void setNoofplayer(int noofplayer) {
		this.noofplayer = noofplayer;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", tName=" + tName + ", noofplayer=" + noofplayer + ", getId()=" + getId()
				+ ", gettName()=" + gettName() + ", getNoofplayer()=" + getNoofplayer() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
