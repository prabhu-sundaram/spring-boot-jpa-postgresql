package com.dm.springbootjpapostgresql.example.msgDigestGenerator;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import com.google.common.hash.Hashing;

public class hash1 {

	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	    
    private static String get_SHA_256_SecurePassword(String passwordToHash, byte[] salt)
    {   	
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            
            //Convert byte[] into a string
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return generatedPassword;    	
    }
    
    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
    
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		String originalString="prabhu";
		
		//MessageDigest Class in Java
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(
		  originalString.getBytes(StandardCharsets.UTF_8));
		System.out.println("encodedhash:"+encodedhash);
		
		String hexString = bytesToHex(encodedhash);
		System.out.println("hexString:"+hexString);
		
		//Guava Library
		String sha256hex3 = Hashing.sha256()
				  .hashString(originalString, StandardCharsets.UTF_8)
				  .toString();
		System.out.println("sha256hex3:"+sha256hex3);
		
		//Apache Commons Codecs
		String sha256hex = DigestUtils.sha256Hex(originalString);
		System.out.println("sha256hex:"+sha256hex);
		
		//Bouncy Castle Library
		MessageDigest digest2 = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest2.digest(
		  originalString.getBytes(StandardCharsets.UTF_8));
		System.out.println("hash:"+hash);
		//String sha256hex2 = new String(Hex.encode(hash));
		//System.out.println("sha256hex2:"+sha256hex2);
		
		//Java SHA Hashing
        String passwordToHash = "prabhu";
        byte[] salt = getSalt();
         
        String securePassword = get_SHA_256_SecurePassword(passwordToHash, salt);
        System.out.println(securePassword);	
        
        //Java HMAC SHA256
       
        try {
            String secret = "secret";
            String message = "Message";

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            String hash5InBase64 = Base64.encodeBase64String(sha256_HMAC.doFinal(message.getBytes("UTF-8")));
            System.out.println(hash5InBase64);
            
            String hash6 = new String(Hex.encodeHex(sha256_HMAC.doFinal(message.getBytes("UTF-8"))));
            System.out.println(hash6);   
            System.out.println(hash6.toUpperCase()); 
            //----------------
            
            String password = "1u93vc2s56";
            String data = "1u93vc2s56&10000&B5B0B00906A6BZ0F&Servicefee&EN&Test939900V002&RETL&https://pgtservices.cbuaepay.ae/PGMerchantSimulator/HttpRequestDemoServer/Index&AED&20200906162305&-1&5B0B00906A6BZ0F&DD&1.1&1&2&3&4&5&1&2&3&4&5";

            SecretKeySpec secret_key2 = new SecretKeySpec(password.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key2);

            String hashInBase64 = Base64.encodeBase64String(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
            System.out.println(hashInBase64);
            
            String hash8 = new String(Hex.encodeHex(sha256_HMAC.doFinal(data.getBytes("UTF-8"))));
            System.out.println(hash8);   
            System.out.println(hash8.toUpperCase()); 
            
           }
           catch (Exception e){
            System.out.println("Error");
           }
        
	}

}
