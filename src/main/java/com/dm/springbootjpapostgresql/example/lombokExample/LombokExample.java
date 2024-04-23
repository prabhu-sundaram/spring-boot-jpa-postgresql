package com.dm.springbootjpapostgresql.example.lombokExample;

import com.dm.springbootjpapostgresql.example.beans.User3;

public class LombokExample {

	public static void main(String[] args) {

		User3 u1 = new User3();
		System.out.println(u1.toString());
		System.out.println(u1.hashCode());

	}

}
