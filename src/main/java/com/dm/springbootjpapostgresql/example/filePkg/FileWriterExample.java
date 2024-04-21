package com.dm.springbootjpapostgresql.example.filePkg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class FileWriterExample {

	public static void main(String[] args) throws IOException {

		System.out.println("---------Writer-------------");
		Writer w = new FileWriter("src/main/resources/example/output.txt");
		w.write("prabhu sample");
		w.close();
		System.out.println("-----------------------");
		
		System.out.println("---------FileWriter-------------");
		FileWriter fw = new FileWriter("src/main/resources/example/output2.txt");
		fw.write("prabhu sample 222222222");
		fw.close();
		System.out.println("-----------------------");
		
		File f = new File("src/main/resources/example/output22.txt");
		FileWriter fw2 = new FileWriter(f);
		fw2.write("prabhu sample 222222222");
		fw2.close();
		System.out.println("-----------------------");
		
		System.out.println("---------BufferedWriter-------------");
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/example/output3.txt"));
		bw.write("bw test");
		bw.close();
		System.out.println("-----------BufferedWriter append------------");
		BufferedWriter bw2 = new BufferedWriter(new FileWriter("src/main/resources/example/output3.txt",true));//if true is not added its overwrite
		bw2.append("bw test 222222222");
		bw2.append("bw test 233332423434534523");
		bw2.close();
		System.out.println("-----------------------");	
		
		System.out.println("---------PrintWriter File-------------");
		PrintWriter pw = new PrintWriter("src/main/resources/example/output4.txt");
		pw.write("test PrintWriter");
		pw.close();
		System.out.println("-----------------------");	

		System.out.println("---------PrintWriter console-------------");
		PrintWriter pw2 = new PrintWriter(System.out);
		pw2.write("test PrintWriter");
		pw2.print("3534253");
		pw2.println("1111111111111135342534343");
		pw2.printf("Product name is %s and its price is %d $", "iPhone", 1000);
		pw2.flush();
		pw2.close();
		System.out.println("-----------------------");	
		
		System.out.println("---------FileOutputStream-------------");
		FileOutputStream fos = new FileOutputStream(new File("src/main/resources/example/output5.txt"));
		fos.write(65);
		String s = "test string";
		byte[] ba = s.getBytes();
		fos.write(ba);
		fos.close();
		System.out.println("-----------------------");	
		

	}

}
