package com.dm.springbootjpapostgresql.example.beans;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


public class Staff {

    private String name;
    private int age;
    private String[] position;              //  Array
    private List<String> skills;            //  List
    
    private Map<String, BigDecimal> salary; //  Map
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getPosition() {
		return position;
	}
	public void setPosition(String[] position) {
		this.position = position;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public Map<String, BigDecimal> getSalary() {
		return salary;
	}
	public void setSalary(Map<String, BigDecimal> salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Staff [name=" + name + ", age=" + age + ", position=" + Arrays.toString(position) + ", skills=" + skills
				+ ", salary=" + salary + ", getName()=" + getName() + ", getAge()=" + getAge() + ", getPosition()="
				+ Arrays.toString(getPosition()) + ", getSkills()=" + getSkills() + ", getSalary()=" + getSalary()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
