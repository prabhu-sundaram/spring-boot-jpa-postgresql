package com.dm.springbootjpapostgresql.example.test_HMAC_SHA512;

import java.awt.RenderingHints.Key;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMACSHA512Generator {

	private static String generateHMAC(String msg, String signKey) {
		try {
		SecretKeySpec key = new SecretKeySpec(signKey.getBytes(),"HmacSHA512");
		
		Mac mac = Mac.getInstance("HmacSHA512");
		
		mac.init(key);
		
		byte[] rawHmac = mac.doFinal(msg.getBytes());
		return toHex(rawHmac);
		} catch (Exception e) {
		System.err.println("Failed to generate HMAC - " +
		e.getMessage());
		return null;
		}
		}
		/**
		* Converts the specified data to hexa decimal representation
		* @param data data to be converted
		* @return A hexa decimal representation of the specified data
		*/
	private static String toHex(byte[] data) {
		if (data == null) {
		return null;
		}
		char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder(data.length * 2);
		for(int i = 0; i < data.length; i++) {
		sb.append(HEX_CHARS[(data[i] >> 4) & 0xf]);
		sb.append(HEX_CHARS[data[i] & 0xf]);
		}
		return sb.toString();
		}
		
		public static void main(String[] args) throws Exception {
			System.out.println(generateHMAC("{\"header\":{\"spCode\":\"SDG\",\"servCode\":\"TEST\",\"paymentMode\":\"EPAY\",\"paymentType\":\"APPLE_PAY\"},\"body\":{\"transaction\":{\"spCode\":\"SDG\",\"servCode\":\"TEST\",\"spTrn\":\"20180215-00001\"}}}","B6580C45398B1F297F86666E91EA836E65C9B7B37B6818BE272997ABB20F561FF1C612172F19A2FC9CB8F1DD345EAC2D6C42DC6A48E17F4217703191BA67F59E"));

		}		
		
}
