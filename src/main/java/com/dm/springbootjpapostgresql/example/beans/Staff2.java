package com.dm.springbootjpapostgresql.example.beans;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL) 
@JsonIgnoreProperties({"salary", "position"})
public class Staff2 {
	@JsonProperty("staff_name") @JsonInclude(JsonInclude.Include.NON_NULL) 
    private String name;
	
    private int age;
    private String[] position;              //  Array
    private List<String> skills;            //  List    
	//@JsonIgnore
    private Map<String, BigDecimal> salary; //  Map	
	
    public Staff2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Staff2() {
		// TODO Auto-generated constructor stub
	}

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
}
