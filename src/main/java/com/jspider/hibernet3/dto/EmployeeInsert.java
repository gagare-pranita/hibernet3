package com.jspider.hibernet3.dto;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Employeetable")
public class EmployeeInsert {
	@Id
	@Column(name="e_id")

	private int id;
	@Column(name="e_name")
	private String name;
	private String cname;
	private long salary;
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeInsert [id=" + id + ", name=" + name + ", cname=" + cname + ", salary=" + salary + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getCname()=" + getCname() + ", getSalary()=" + getSalary()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	

}
