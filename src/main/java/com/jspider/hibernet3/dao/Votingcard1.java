package com.jspider.hibernet3.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Votingcard1 {
	@Id
	private int id;
	private long voternumber;
	@OneToOne(mappedBy = "votingcard1")
	@JoinColumn(name="id")
	private Voter1 voter1;
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
	public Voter1 getVoter1() {
		return voter1;
	}
	public void setVoter1(Voter1 voter1) {
		this.voter1 = voter1;
	}
	@Override
	public String toString() {
		return "Votingcard1 [id=" + id + ", voternumber=" + voternumber + ", voter1=" + voter1 + ", getId()=" + getId()
				+ ", getVoternumber()=" + getVoternumber() + ", getVoter1()=" + getVoter1() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

}
