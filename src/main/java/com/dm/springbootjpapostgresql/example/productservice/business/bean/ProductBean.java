package com.dm.springbootjpapostgresql.example.productservice.business.bean;

public class ProductBean {

	private int id;
	private String name;    
	private String description;
	private Double price;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductBean [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getDescription()=" + getDescription()
				+ ", getPrice()=" + getPrice() + "]";
	}
	
}
