package com.dm.springbootjpapostgresql.example.apiClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Base64;

/*import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.tomcat.util.http.parser.Host;*/

public class APIClient {

	public static void main(String[] args) {
		String username = "username";
		String password = "password";
		String url = "url";
		String metadata = "metadata";
		String filepath = "filepath";
		String content = "content";

		/*
		 * CloseableHttpClient httpClient = HttpClients.createDefault();
		 * 
		 * String boundary = "*****" + Long.toString(System.currentTimeMillis()) +
		 * "*****";
		 * 
		 * Host uploadFile = new Host(url);
		 * 
		 * 
		 * String userCredentials = username+":"+password; String basicAuth = "Basic " +
		 * new String(Base64.getEncoder().encode(userCredentials.getBytes()));
		 * uploadFile.addHeader("Authorization", basicAuth);
		 * 
		 * MimeMultipart c = new MimeMultipart();
		 * 
		 * MimeBodyPart textPart = new MimeBodyPart();
		 * 
		 * try { textPart.setText(metadata, "text/plain"); } catch (MessagingException
		 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 * 
		 * 
		 * MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		 * builder.addTextBody("metadata", metadata, ContentType.TEXT_PLAIN);
		 * 
		 * content=
		 * "RequestReferenceNumber,ConsigneeNameEnglish,CategoryName,SubCategory,ItemBarCode,Weight,WeightUnit,ShelfLife,Brand,CountryOfOrigin,TotalWeight,ProcessName,HSCode,MainItem,Type\r\n"
		 * +
		 * "FIRS-07042020-0591,WAREEN INDUSTRIES LLC,Sugar,cane sugar,DM78409085069165,50,kg,730,Al Khaleej,United Arab Emirates,2250000,refined,ABCD,Sugar,Import\r\n"
		 * +
		 * "FIRS-01042020-0150,NESTLE DUBAI MANUFACTURING (L.L.C),Milk,powdered milk,DM554010370719932,25,kg,365,Fonterra,New Zealand,532000,,ABCD,Milk,Import\r\n"
		 * +
		 * "FIRS-11042020-0346,AL GHURAIR FOODS L L C,Wheat And Products,whole wheat,DM64305059083468,0,no weight,730,No Brand,Russian Federation,43000000,,ABCD,Wheat,Import\r\n"
		 * +
		 * "FIRS-04042020-0293,AL AHLI GENERAL TRADING CO.(L.L.C) DUBAI BR.,Fish,tuna,8.85E+12,185,g,365,Al Rabee,Thailand,193303.2,canned,ABCD,Seafood,Import\r\n"
		 * +
		 * "FIRS-27022020-0369,QUALPRO DISTRIBUTION (L.L.C),Leaf And Flower Vegetables,grape leaves,6.18E+11,908,g,540,Al Alali,Vietnam,57347.96,,ABCD,Leafy Vegetable,Import\r\n"
		 * +
		 * "FIRS-20022020-0627,TRANSMED OVERSEAS INCORPORATED S.A.,Baby Foods,growing up formula,8.72E+12,900,g,365,Aptamil,Netherlands,54122,,ABCD,Baby Milk,Import\r\n"
		 * +
		 * "FIRS-05032020-0556,FARZANA TRADING L.L.C.,Citrus Fruit,orange,DM8180808206712,0,no weight,0,No Brand,Egypt,312000,fresh,ABCD,Orange,Import\r\n"
		 * +
		 * "FIRS-09042020-0394,ALBAKRAWE GENERAL TRADING LLC,Pome Fruit,apples,DM710080780649308,0,no weight,0,No Brand,South Africa,309342.5,fresh,ABCD,Apple,Import\r\n"
		 * +
		 * "FIRS-29032020-0022,BAQUBAH FOODSTUFF TRADING L L C,Stone Fruit,date,DM6820807912801309,0,no weight,365,no brand,Saudi Arabia,100000,,ABCD,Dates,Import\r\n"
		 * +
		 * "FIRS-13022020-0584,FARZANA TRADING L.L.C.,Eggs and products,whole eggs,DM6430204907801223,360,pieces,90,Sinyavinskaya,Russian Federation,317391.36,,ABCD,Eggs,Import\r\n"
		 * +
		 * "FIRS-30032020-0456,MOMIN OIL INDUSTRY FZCO,Vegetable Oil,palmolein oil,DM360040561859336,0,no weight,365,No Brand,Indonesia,2999948,refined,ABCD,Cooking Oil,Import\r\n"
		 * +
		 * "FIRS-04032020-0588,DHIRANI FOODSTUFF CO. (L.L.C),Rice And Products,basmati rice,8.91E+12,39,kg,365,Gautam XXL,India,628875,,ABCD,Rice,Import\r\n"
		 * +
		 * "FIRS-16012020-0505,ARAB INDIA SPICES(L.L.C),Pulses And Products,gram,DM834060671185770,50,kg,730,No Brand,Tanzania,1202400,,ABCD,Pulses,Import\r\n"
		 * +
		 * "FIRS-09052019-1125,AL WAHA AL GHANNAA FOODSTUFF,Underground Vegetables,potato,DM8180707306091998,0,no weight,0,no brand,Egypt,675024,fresh,ABCD,Potato,Import\r\n"
		 * +
		 * "FIRS-04122019-0318,MHP FOOD TRADING LLC,Chicken and products,chicken breast,4.82E+12,2.5,kg,365,Qualiko,Ukraine,198800,frozen,ABCD,Poultry,Import\r\n"
		 * +
		 * "FIRS-24082019-0743,PADENA GENERAL TRADING,Fruit Of Vegetables,cucumber,DM36407074062728,0,no weight,0,No Brand,Iran,29788,fresh,ABCD,Cucumber,Import\r\n"
		 * +
		 * "FIRS-27112019-0308,MALWAN STAR GENERAL TRADING LLC,Beef and products,veal meat,DM356020444896126,900,g,365,Kamil,India,53946,frozen,ABCD,Beef Meat,Import\r\n"
		 * +
		 * "FIRS-01042020-0602,DEL MONTE FOODS UAE FZE,Tropical Fruit (Common and Exotic),banana,DM60808083022676,0,no weight,0,Del Monte,Philippines,293306,fresh,ABCD,Banana,Import\r\n"
		 * +
		 * "FIRS-13062019-1009,NRTC DUBAI INTERNATIONAL VEG.AND FRUIT TRADING LLC,Fruit Of Vegetables,tomato,DM79207074062617,0,no weight,0,No Brand,Turkey,82705,fresh,ABCD,Tomato,Import\r\n"
		 * +
		 * "FIRS-23022019-0365,CLASSIC FINE FOODSTUFF TRADING LLC,\"Sheep, Goats and Products\",lamb meat,DM792020462134211,0,no weight,365,Namet,Turkey,2.44,frozen,ABCD,Lamb Meat,Import\r\n"
		 * + "";
		 * 
		 * String dataLines[]=content.split("\\r\\n");
		 * System.out.println("data"+dataLines[0]);
		 * 
		 * File csvOutputFile = new File("test.csv");
		 * 
		 * PrintWriter writer; try { writer = new PrintWriter(csvOutputFile);
		 * 
		 * 
		 * for(int i=0;i<dataLines.length;i++)
		 * 
		 * { StringBuilder sb = new StringBuilder(); sb.append(dataLines[i]);
		 * sb.append('\n'); writer.write(sb.toString()); System.out.println("done!"); }
		 * writer.flush(); writer.close(); } catch (FileNotFoundException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 * // This attaches the file to the POST:
		 * 
		 * builder.setCharset(Consts.UTF_8); builder.setStrictMode(); try {
		 * builder.addBinaryBody( "file", new
		 * FileInputStream(csvOutputFile),ContentType.create("text/csv"),
		 * csvOutputFile.getName() ); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 * 
		 * HttpEntity multipart = builder.build(); uploadFile.setEntity(multipart);
		 * CloseableHttpResponse response; try { response =
		 * httpClient.execute(uploadFile); HttpEntity responseEntity =
		 * response.getEntity();
		 * System.out.println("status:"+response.getStatusLine().toString());
		 * 
		 * System.out.println("status:"+responseEntity.getContent()); InputStream
		 * inputStream;
		 * 
		 * inputStream = responseEntity.getContent(); InputStreamReader isReader = new
		 * InputStreamReader(inputStream); BufferedReader reader = new
		 * BufferedReader(isReader); StringBuffer sb = new StringBuffer(); String str;
		 * try { while((str = reader.readLine())!= null){ sb.append(str); } } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * System.out.println(sb.toString());
		 * 
		 * } catch (IllegalStateException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

	}

}
