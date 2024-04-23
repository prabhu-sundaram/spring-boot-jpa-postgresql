package com.dm.springbootjpapostgresql.example.testMD5;


//import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jakarta.xml.bind.DatatypeConverter;

import org.apache.commons.codec.digest.DigestUtils;
//import org.junit.Test;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

public class MD5HashGen {
    static String hash = "35454B055CC325EA1AF2126E27707052";
    static String password = "ILoveJava";

    static String filename = "src/main/resources/example/test_md5.txt";
    static String checksum = "5EB63BBBE01EEED093CB22BB8F5ACDC3";
    
    //@Test
    public void givenPassword_whenHashing_thenVerifying() throws NoSuchAlgorithmException {
	    System.out.println("---------------------MD5 Using MessageDigest Class-----------------------------");		    
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
	    System.out.println("myHash:"+myHash);
	    //assertThat(myHash.equals(hash)).isTrue();
	    System.out.println("--------------------------------------------------");
    }
    
    //@Test
    public void givenFile_generatingChecksum_thenVerifying() throws NoSuchAlgorithmException, IOException {
	    MessageDigest md2 = MessageDigest.getInstance("MD5");
	    md2.update(Files.readAllBytes(Paths.get(filename)));
	    byte[] digest2 = md2.digest();
	    String myChecksum = DatatypeConverter.printHexBinary(digest2).toUpperCase();
	    System.out.println("myChecksum:"+myChecksum);
	    //assertThat(myChecksum.equals(checksum)).isTrue();
	    System.out.println("--------------------------------------------------");	    	
    }
    
    //@Test
    public void givenPassword_whenHashingUsingCommons_thenVerifying() {
	    System.out.println("---------------------MD5 Using Apache Commons-----------------------------");		   
	    String md5Hex = DigestUtils.md5Hex(password).toUpperCase();		
	    System.out.println("md5Hex:"+md5Hex);
	    //assertThat(md5Hex.equals(hash)).isTrue();
	    System.out.println("--------------------------------------------------");	    	
    }
    
    //@Test
    public void givenFile_whenChecksumUsingGuava_thenVerifying() throws IOException {
	    System.out.println("---------------------MD5 Using Guava-----------------------------");		    		        
	    HashCode hash3 = com.google.common.io.Files.hash(new File(filename), Hashing.md5());
	    String myChecksum3 = hash3.toString().toUpperCase();		    
	    System.out.println("myChecksum3:"+myChecksum3);
	    //assertThat(myChecksum3.equals(checksum)).isTrue();
	    System.out.println("--------------------------------------------------");	    	
    }
    
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
	    System.out.println("-------------------------main-------------------------");	    	
	}

}
