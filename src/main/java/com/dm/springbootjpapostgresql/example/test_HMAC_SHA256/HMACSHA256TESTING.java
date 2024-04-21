package com.dm.springbootjpapostgresql.example.test_HMAC_SHA256;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

public class HMACSHA256TESTING {

	public static String encode(String key,String data) throws Exception
	{
		Mac sha256_HMAC=Mac.getInstance("HmacSHA256");
		
		System.out.println("key in bytes:"+key.getBytes("UTF-8"));		
		SecretKeySpec secret_key=new SecretKeySpec(key.getBytes("UTF-8"),"HmacSHA256");
		
		sha256_HMAC.init(secret_key);
		
		System.out.println("data in bytes:"+data.getBytes("UTF-8"));
		return new String(Hex.encodeHex(sha256_HMAC.doFinal(data.getBytes("UTF-8")))).toUpperCase();
	}
	
	public static void main(String[] args) throws Exception {
		//Payment Simulator
		//System.out.println(encode("0123456789","0123456789&10000&123456&0005&billRef&EN&9999001002&RETL&000&100000000001&20160714092737&AED&20160714082422&0BBF907A408B4BB&DD&1.1&Return1&Return2&Return3&Return4&Return5&1&2&3&4&5"));
		//System.out.println(encode("1u93vc2s56","1u93vc2s56&10000&B5B0B00906A6BZ0F&Servicefee&EN&Test939900V002&RETL&https://pgtservices.cbuaepay.ae/PGMerchantSimulator/HttpRequestDemoServer/Index&AED&20200906162305&-1&5B0B00906A6BZ0F&DD&1.1&1&2&3&4&5&1&2&3&4&5"));
		System.out.println(encode("1u93vc2s56","1u93vc2s56&10000&billRef&Descriptionof transaction&EN&Test939900V002&RETL&https://dibuat.ae/wallet/txnResponse&AED&20200907125554&-1&4B0B00906A7B0B4&DD&1.1&1&2&3&4&5&1&2&3&4&5"));
		System.out.println(encode("1u93vc2s56","1u93vc2s56&10000&&billRef&Descriptionof transaction&EN&Test939900V002&RETL&https://dibuat.ae/wallet/txnResponse&&AED&20200907125554&-1&4B0B00906A7B0B4&DD&1.1&1&2&3&4&5&1&2&3&4&5"));

		System.out.println(encode("1u93vc2s56","1u93vc2s56&10000&billRef&Descriptionof transaction&EN&Test939900V002&RETL&https://dibuat.ae/wallet/txnResponse&AED&20200907125554&-1&4B0B00906A7B0B4&DD&1.1&1&2&3&4&5&1&2&3&4&5"));
		
		//Inquiry Simulator
		//System.out.println(encode("1u93vc2s56","1u93vc2s56&Test939900V002&t0x38xy2a5&20200907125554&4B0B00907ABFFF4&DD&1.1"));
		
		//DeliveryStatusUpdate Simulator
		//System.out.println(encode("1u93vc2s56","1u93vc2s56&CFM&Test939900V002&t0x38xy2a5&20200907125554&4B0B00907ABFFF4&DD&1.1"));

	}

}
