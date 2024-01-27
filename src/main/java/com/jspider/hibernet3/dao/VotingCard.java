package com.jspider.hibernet3.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class VotingCard {
	@Id
	private int id;
	private long voternumber;
	@OneToOne(mappedBy = "votingcard")
	@JoinColumn(name="id")
	private Voter voter;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getVoternumber() {
		return voternumber;
	}
	public void setVoternumber(long voternumber) {
		this.voternumber = voternumber;
	}
	public Voter getVoter() {
		return voter;
	}
	public void setVoter(Voter voter) {
		this.voter = voter;
	}
	@Override
	public String toString() {
		return "VotingCard [id=" + id + ", voternumber=" + voternumber + ", voter=" + voter + ", getId()=" + getId()
				+ ", getVoternumber()=" + getVoternumber() + ", getVoter()=" + getVoter() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
