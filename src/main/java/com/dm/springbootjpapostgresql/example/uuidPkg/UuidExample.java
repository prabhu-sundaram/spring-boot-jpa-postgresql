package com.dm.springbootjpapostgresql.example.uuidPkg;

import java.security.MessageDigest;
import java.util.UUID;

public class UuidExample {

	public static void main(String[] args) {
		//UUID uuid = UUID.nameUUIDFromBytes(byte[] bytes);

		UUID uuid4 = UUID.randomUUID();
		System.out.println("uuid4:"+uuid4);
		System.out.println("uuid4 variant:"+uuid4.variant());
		System.out.println("uuid4 version:"+uuid4.version());
		System.out.println("uuid4 string:"+uuid4.toString());

		/*
		 * MessageDigest salt = MessageDigest.getInstance("SHA-256");
		 * salt.update(UUID.randomUUID().toString().getBytes("UTF-8")); String digest =
		 * bytesToHex(salt.digest());
		 */
		
	}

}
