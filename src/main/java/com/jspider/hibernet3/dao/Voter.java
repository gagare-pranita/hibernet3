package com.jspider.hibernet3.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Voter {
	@Id
	private int id;
	private String name;
	private  String address;
	@OneToOne
	private VotingCard votingcard;
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
	public VotingCard getVotingcard() {
		return votingcard;
	}
	public void setVotingcard(VotingCard votingcard) {
		this.votingcard = votingcard;
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", name=" + name + ", address=" + address + ", votingcard=" + votingcard
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getAddress()=" + getAddress()
				+ ", getVotingcard()=" + getVotingcard() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
