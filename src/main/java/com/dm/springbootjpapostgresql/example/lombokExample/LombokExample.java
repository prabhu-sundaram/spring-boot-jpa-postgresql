package com.dm.springbootjpapostgresql.example.lombokExample;

import com.dm.springbootjpapostgresql.example.beans.User;

public class LombokExample {

	public static void main(String[] args) {

		User u1 = new User();
		System.out.println(u1.toString());
		System.out.println(u1.hashCode());

	}

}
