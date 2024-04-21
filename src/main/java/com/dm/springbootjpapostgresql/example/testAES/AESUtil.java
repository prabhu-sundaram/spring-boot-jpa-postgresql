package com.dm.springbootjpapostgresql.example.testAES;

//import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import jakarta.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

//import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.dm.springbootjpapostgresql.example.beans.Student4;

public class AESUtil {

	/*
	 * public static void main(String[] args) {
	 * System.out.println("-------------------------main-------------------------");
	 * 
	 * }
	 */
	//------------------String-----------------------------
	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
	    System.out.println("-------------------------Secret Key-------------------------");	    	
		
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	    keyGenerator.init(n);
	    SecretKey key = keyGenerator.generateKey();
	    return key;
	}
	public static SecretKey getKeyFromPassword(String password, String salt)
		    throws NoSuchAlgorithmException, InvalidKeySpecException {
	    System.out.println("-------------------------Secret Key-------------------------");	    	
				    
		    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
		    SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
		    return secret;
		}	
	public static IvParameterSpec generateIv() {
	    System.out.println("-------------------------Initialization Vector (IV)-------------------------");	    	
		
	    byte[] iv = new byte[16];
	    new SecureRandom().nextBytes(iv);
	    return new IvParameterSpec(iv);
	}
	public static String encrypt(String algorithm, String input, SecretKey key,
		    IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
		    InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException {
	    System.out.println("-------------------------encrypt-------------------------");	    	
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		    byte[] cipherText = cipher.doFinal(input.getBytes());
		    return Base64.getEncoder().encodeToString(cipherText);
		}	
	public static String decrypt(String algorithm, String cipherText, SecretKey key,
		    IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
		    InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException {
	    System.out.println("-------------------------decrypt-------------------------");	    	
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.DECRYPT_MODE, key, iv);
		    byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
		    return new String(plainText);
		}	
	//@Test
	void givenString_whenEncrypt_thenSuccess()
	    throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
	    BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException { 
	    
	    String input = "prabhu";
	    SecretKey key = AESUtil.generateKey(128);
	    IvParameterSpec ivParameterSpec = AESUtil.generateIv();
	    String algorithm = "AES/CBC/PKCS5Padding";
	    
	    String cipherText = AESUtil.encrypt(algorithm, input, key, ivParameterSpec);
	    System.out.println("cipherText:"+cipherText);
	    
	    String plainText = AESUtil.decrypt(algorithm, cipherText, key, ivParameterSpec);
	    System.out.println("plainText:"+plainText);
	    
	    //Assertions.//assertEquals(input, plainText);
	}
	//------------------File-----------------------------
	public static void encryptFile(String algorithm, SecretKey key, IvParameterSpec iv,
		    File inputFile, File outputFile) throws IOException, NoSuchPaddingException,
		    NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		    FileInputStream inputStream = new FileInputStream(inputFile);
		    FileOutputStream outputStream = new FileOutputStream(outputFile);
		    byte[] buffer = new byte[64];
		    int bytesRead;
		    while ((bytesRead = inputStream.read(buffer)) != -1) {
		        byte[] output = cipher.update(buffer, 0, bytesRead);
		        if (output != null) {
		            outputStream.write(output);
		        }
		    }
		    byte[] outputBytes = cipher.doFinal();
		    if (outputBytes != null) {
		        outputStream.write(outputBytes);
		    }
		    inputStream.close();
		    outputStream.close();
		}	
    public static void decryptFile(String algorithm, SecretKey key, IvParameterSpec iv,
            File encryptedFile, File decryptedFile) throws IOException, NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            FileInputStream inputStream = new FileInputStream(encryptedFile);
            FileOutputStream outputStream = new FileOutputStream(decryptedFile);
            byte[] buffer = new byte[64];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byte[] output = cipher.update(buffer, 0, bytesRead);
                if (output != null) {
                    outputStream.write(output);
                }
            }
            byte[] output = cipher.doFinal();
            if (output != null) {
                outputStream.write(output);
            }
            inputStream.close();
            outputStream.close();
        }	
	//@Test
	void givenFile_whenEncrypt_thenSuccess() 
	    throws NoSuchAlgorithmException, IOException, IllegalBlockSizeException, 
	    InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, 
	    NoSuchPaddingException {
	    
	    SecretKey key = AESUtil.generateKey(128);
	    String algorithm = "AES/CBC/PKCS5Padding";
	    IvParameterSpec ivParameterSpec = AESUtil.generateIv();
	    ClassPathResource resource = new ClassPathResource("src/test/resources/prabhu.txt");
	    File inputFile = resource.getFile();
	    File encryptedFile = new File("classpath:baeldung.encrypted");
	    File decryptedFile = new File("document.decrypted");
	    AESUtil.encryptFile(algorithm, key, ivParameterSpec, inputFile, encryptedFile);
	    AESUtil.decryptFile(
	      algorithm, key, ivParameterSpec, encryptedFile, decryptedFile);
	    //assertThat(inputFile).hasSameTextualContentAs(decryptedFile);
	}	
	//------------------Password-Based-----------------------------
    public static String encryptPasswordBased(String plainText, SecretKey key, IvParameterSpec iv)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            return Base64.getEncoder()
                .encodeToString(cipher.doFinal(plainText.getBytes()));
        }

        public static String decryptPasswordBased(String cipherText, SecretKey key, IvParameterSpec iv)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            return new String(cipher.doFinal(Base64.getDecoder()
                .decode(cipherText)));
        }	
	//@Test
	void givenPassword_whenEncrypt_thenSuccess() 
	    throws InvalidKeySpecException, NoSuchAlgorithmException, 
	    IllegalBlockSizeException, InvalidKeyException, BadPaddingException, 
	    InvalidAlgorithmParameterException, NoSuchPaddingException {
	    
	    String plainText = "www.baeldung.com";
	    String password = "baeldung";
	    String salt = "12345678";
	    IvParameterSpec ivParameterSpec = AESUtil.generateIv();
	    SecretKey key = AESUtil.getKeyFromPassword(password,salt);
	    String cipherText = AESUtil.encryptPasswordBased(plainText, key, ivParameterSpec);
	    String decryptedCipherText = AESUtil.decryptPasswordBased(
	      cipherText, key, ivParameterSpec);
	    //Assertions.//assertEquals(plainText, decryptedCipherText);
	}	
	//------------------Object----------------------------
	public static SealedObject encryptObject(String algorithm, Serializable object,
		    SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException,
		    NoSuchAlgorithmException, InvalidAlgorithmParameterException, 
		    InvalidKeyException, IOException, IllegalBlockSizeException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		    SealedObject sealedObject = new SealedObject(object, cipher);
		    return sealedObject;
		}	
	public static Serializable decryptObject(String algorithm, SealedObject sealedObject,
		    SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException,
		    NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,
		    ClassNotFoundException, BadPaddingException, IllegalBlockSizeException,
		    IOException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.DECRYPT_MODE, key, iv);
		    Serializable unsealObject = (Serializable) sealedObject.getObject(cipher);
		    return unsealObject;
		}	
	//@Test
	void givenObject_whenEncrypt_thenSuccess() 
	    throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
	    InvalidAlgorithmParameterException, NoSuchPaddingException, IOException, 
	    BadPaddingException, ClassNotFoundException {
	    
	    Student4 student4 = new Student4("Baeldung", 20);
	    SecretKey key = AESUtil.generateKey(128);
	    IvParameterSpec ivParameterSpec = AESUtil.generateIv();
	    String algorithm = "AES/CBC/PKCS5Padding";
	    SealedObject sealedObject = AESUtil.encryptObject(
	      algorithm, student4, key, ivParameterSpec);
	    Student4 object = (Student4) AESUtil.decryptObject(
	      algorithm, sealedObject, key, ivParameterSpec);
	    //assertThat(student).isEqualToComparingFieldByField(object);
	}	
}
