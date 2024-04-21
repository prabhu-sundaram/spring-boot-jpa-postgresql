package com.dm.springbootjpapostgresql.example.beans;

import java.util.Date;

public class Car2 {
    private String brand;
    private int doors;
    private String color;
    private String type;
    private int year;
    private Date date = null;
    private boolean status;

//    public enum MonthNumber
//    {
//        A1, A2, A3;
//    };
//    private MonthNumber month;
    
//	public Car2(String brand, String doors, String color, String type, String year) {
//		super();
//		this.brand = brand;
//		this.doors = doors;
//		this.color = color;
//		this.type = type;
//		this.year = year;
//	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getDoors() {
		return doors;
	}
	public void setDoors(int doors) {
		this.doors = doors;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Car2 [brand=" + brand + ", doors=" + doors + ", color=" + color + ", type=" + type + ", year=" + year
				+ ", date=" + date + ", status=" + status + ", getBrand()=" + getBrand() + ", getDoors()=" + getDoors()
				+ ", getColor()=" + getColor() + ", getType()=" + getType() + ", getYear()=" + getYear()
				+ ", getDate()=" + getDate() + ", isStatus()=" + isStatus() + "]";
	}	
}
