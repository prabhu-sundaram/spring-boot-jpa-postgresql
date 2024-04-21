package com.dm.springbootjpapostgresql.example.randomPkg;

import java.util.Random;

import org.apache.commons.math3.random.RandomDataGenerator;

public class RandomNumber2 {

	public static void main(String[] args) {
		System.out.println("-------------Generate an Unbounded Long-----------------");
		long generatedLong = new Random().nextLong();
	    System.out.println(generatedLong);
		
		System.out.println("------------------------------");
		System.out.println("-------------Generate a Long Within a Range-----------------");
		System.out.println("--------------Random Long With Plain Java----------------");
	    long leftLimit = 1L;
	    long rightLimit = 10L;
	    long generatedLong2 = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));		
	    System.out.println(generatedLong2);
		
		System.out.println("-------------Random Long With Apache Commons Math-----------------");
	    long leftLimit3 = 10L;
	    long rightLimit3 = 100L;
	    long generatedLong3 = new RandomDataGenerator().nextLong(leftLimit3, rightLimit3);
	    System.out.println(generatedLong3);
		System.out.println("------------------------------");
	    
		System.out.println("--------------Generate an Unbounded Integer----------------");
	    int generatedInteger = new Random().nextInt();
	    System.out.println(generatedInteger);
		
		
		System.out.println("------------------------------");
		System.out.println("-----------Generate an Integer Within a Range-------------------");
		System.out.println("-----------Random Integer With Plain Java-------------------");
	    int leftLimit5 = 1;
	    int rightLimit5 = 10;
	    int generatedInteger5 = leftLimit5 + (int) (new Random().nextFloat() * (rightLimit5 - leftLimit5));		
	    System.out.println(generatedInteger5);
		
		System.out.println("--------------Random Integer With Commons Math----------------");
	    int leftLimit6 = 1;
	    int rightLimit6 = 10;
	    int generatedInteger6 = new RandomDataGenerator().nextInt(leftLimit6, rightLimit6);	
	    System.out.println(generatedInteger6);
	    
		System.out.println("------------------------------");
		
		System.out.println("-------------Generate an Unbounded Float-----------------");
	    float generatedFloat = new Random().nextFloat();
	    System.out.println(generatedFloat);

		System.out.println("------------------------------");	
		System.out.println("------------Generate a Float Within a Range------------------");	
		System.out.println("------------Random Float With Plain Java------------------");
	    float leftLimit8 = 1F;
	    float rightLimit8 = 10F;
	    float generatedFloat8 = leftLimit8 + new Random().nextFloat() * (rightLimit8 - leftLimit8);		
	    System.out.println(generatedFloat8);
		
		System.out.println("--------------Random Float With Commons Math----------------");
	    float leftLimit9 = 1F;
	    float rightLimit9 = 10F;
	    float randomFloat = new RandomDataGenerator().getRandomGenerator().nextFloat();
	    float generatedFloat9 = leftLimit + randomFloat * (rightLimit9 - leftLimit9);	
	    System.out.println(generatedFloat9);
	    
		System.out.println("--------------Generate an Unbounded Double----------------");
		
		
		System.out.println("---------------Random Unbounded Double With Plain Java---------------");
	    double generatedDouble = Math.random();
	    System.out.println(generatedDouble);
		
		System.out.println("--------------Random Unbounded Double With Commons Math----------------");
	    double generatedDouble2 = new RandomDataGenerator().getRandomGenerator().nextDouble();
	    System.out.println(generatedDouble2);
		
		
		System.out.println("------------------------------");
		System.out.println("---------------Generate a Double Within a Range---------------");
		
		
		System.out.println("-----------------Random Bounded Double With Plain Java-------------");
	    double leftLimit11 = 1D;
	    double rightLimit11 = 10D;
	    double generatedDouble11 = leftLimit + new Random().nextDouble() * (rightLimit11 - leftLimit11);
	    System.out.println(generatedDouble11);
	    
		System.out.println("-------------Random Bounded Double With Commons Math-----------------");
	    double leftLimit12 = 1D;
	    double rightLimit12 = 100D;
	    double generatedDouble12 = new RandomDataGenerator().nextUniform(leftLimit12, rightLimit12);
	    System.out.println(generatedDouble12);
	    
		System.out.println("------------------------------");

		
		

	}

}
