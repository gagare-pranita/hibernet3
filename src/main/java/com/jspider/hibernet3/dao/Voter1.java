package com.jspider.hibernet3.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Voter1 {
	@Id
	private int id;
	private String name;
	private  String address;
	@OneToOne
	private Votingcard1 votingcard1;
	@Override
	public String toString() {
		return "Voter1 [id=" + id + ", name=" + name + ", address=" + address + ", votingcard1=" + votingcard1
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Votingcard1 getVotingcard1() {
		return votingcard1;
	}
	public void setVotingcard1(Votingcard1 votingcard1) {
		this.votingcard1 = votingcard1;
	}
	
	
	

}
