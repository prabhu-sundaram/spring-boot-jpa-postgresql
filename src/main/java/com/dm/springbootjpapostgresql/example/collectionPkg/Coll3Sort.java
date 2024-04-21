package com.dm.springbootjpapostgresql.example.collectionPkg;

import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable<Employee> {
	public String name;

	public Employee(String name) {
		this.name = name;
	}

	public int compareTo(Employee person) {
		return name.compareTo(person.name);

	}
}

public class Coll3Sort {

	public static void main(String[] args) {
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(new Employee("Viru"));
		al.add(new Employee("Saurav"));
		al.add(new Employee("Mukesh"));
		al.add(new Employee("Tahir"));

		Collections.sort(al);
		for (Employee s : al) {	
			System.out.println(s.name);
		}

	}

}
