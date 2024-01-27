package com.jspider.hibernet3.dao;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="BookData")
public class Book {
	@Id
	@Column(name="b_id")
	private int id;

	@Column(name="b_name")
	private String name;

	private long price;
	private int pages;
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", pages=" + pages + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	

}
