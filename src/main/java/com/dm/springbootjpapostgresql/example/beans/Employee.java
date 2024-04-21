package com.dm.springbootjpapostgresql.example.beans;

import java.util.List;

public class Employee {
private long id;
private String name;
private int age;
private float salary;
private List<Integer> pincodes;
private List<String> banks;
private List<Order> orders;

public Employee()
{
	}
public Employee(int id, String name, int age, float salary) {
	this.id=id;	
	this.name=name;
	this.age=age;
	this.salary=salary;		
}

public void setId(long id)
{
this.id=id;	
}

public long getId()
{return this.id;
}

public void setName(String name)
{
this.name=name;	
}

public String getName()
{return this.name;
}

public void setAge(int age)
{
this.age=age;	
}

public int getAge()
{return this.age;
}

public void setSalary(float salary)
{
this.salary=salary;	
}

public float getSalary()
{return this.salary;
}

public List<Integer> getPincodes()
{return this.pincodes;
}

public void setPincodes(List<Integer> pincodes)
{
this.pincodes=pincodes;	
}

public List<String> getBanks()
{
return banks;	
}
public void setBanks(List<String> banks)
{
this.banks=banks;	
}

public List<Order> getOrder()
{
	return orders;
	}
public void setOrder(List<Order> orders)
{
	this.orders = orders;
	}

@Override
public String toString()
{
return 	"id="+this.id+" name="+this.name+" age="+this.age+" salary="+this.salary
		+" Pincodes="+this.pincodes
		+" Banks="+this.banks
		+" Orders="+this.orders;
}
}
