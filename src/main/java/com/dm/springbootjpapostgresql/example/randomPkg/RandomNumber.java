package com.dm.springbootjpapostgresql.example.randomPkg;

import java.security.SecureRandom;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.apache.commons.math3.random.RandomDataGenerator;

import it.unimi.dsi.util.XoRoShiRo128PlusRandom;

public class RandomNumber {

	public static void main(String[] args) {
		
		int min=100;
		int max=1000;
		
		//java.lang.Math
		//System.out.println("Math.random():"+Math.random());
		int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
		System.out.println("randomWithMathRandom:"+randomWithMathRandom);
		System.out.println("------------------------------");

		//java.util.Random
		Random random = new Random();
		int randomWithNextInt = random.nextInt();
		System.out.println("randomWithNextInt:"+randomWithNextInt);
		int randomWintNextIntWithinARange = random.nextInt(max - min) + min;
		System.out.println("randomWintNextIntWithinARange:"+randomWintNextIntWithinARange);
		IntStream unlimitedIntStream = random.ints();
		System.out.println("unlimitedIntStream:"+unlimitedIntStream);
		System.out.println("2:"+random.ints(min, max).findFirst().getAsInt());
		
		int streamSize=100;
		IntStream limitedIntStream = random.ints(streamSize);
		System.out.println("limitedIntStream:"+limitedIntStream);
		IntStream limitedIntStreamWithinARange = random.ints(streamSize, min, max);
		System.out.println("limitedIntStreamWithinARange:"+limitedIntStreamWithinARange);
		System.out.println("------------------------------");

		//java.util.concurrent.ThreadLocalRandom
		int randomWithThreadLocalRandomInARange = ThreadLocalRandom.current().nextInt(min, max);
		System.out.println("randomWithThreadLocalRandomInARange:"+randomWithThreadLocalRandomInARange);
		int randomWithThreadLocalRandom = ThreadLocalRandom.current().nextInt();
		System.out.println("randomWithThreadLocalRandom:"+randomWithThreadLocalRandom);
		int randomWithThreadLocalRandomFromZero = ThreadLocalRandom.current().nextInt(max);
		System.out.println("randomWithThreadLocalRandomFromZero:"+randomWithThreadLocalRandomFromZero);
		IntStream streamWithThreadLocalRandom = ThreadLocalRandom.current().ints();
		System.out.println("streamWithThreadLocalRandom:"+streamWithThreadLocalRandom);
		System.out.println("------------------------------");
		
		//java.util.SplittableRandom
		SplittableRandom splittableRandom = new SplittableRandom();
		int randomWithSplittableRandom = splittableRandom.nextInt(min, max);
		System.out.println("randomWithSplittableRandom:"+randomWithSplittableRandom);
		IntStream limitedIntStreamWithinARangeWithSplittableRandom = splittableRandom.ints(streamSize, min, max);
		System.out.println("limitedIntStreamWithinARangeWithSplittableRandom:"+limitedIntStreamWithinARangeWithSplittableRandom);
		System.out.println("------------------------------");
		
		//java.security.SecureRandom
		SecureRandom secureRandom = new SecureRandom();
		int randomWithSecureRandom = secureRandom.nextInt();
		System.out.println("randomWithSecureRandom:"+randomWithSecureRandom);
		int randomWithSecureRandomWithinARange = secureRandom.nextInt(max - min) + min;
		System.out.println("randomWithSecureRandomWithinARange:"+randomWithSecureRandomWithinARange);
		System.out.println("------------------------------");
	
		//org.apache.commons.math3.random.RandomDataGenerator
		RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
		int randomWithRandomDataGenerator = randomDataGenerator.nextInt(min, max);
		System.out.println("randomWithRandomDataGenerator:"+randomWithRandomDataGenerator);
		System.out.println("------------------------------");
		
		//it.unimi.dsi.util.XoRoShiRo128PlusRandom
		XoRoShiRo128PlusRandom xoroRandom = new XoRoShiRo128PlusRandom();
		int randomWithXoRoShiRo128PlusRandom = xoroRandom.nextInt(max - min) + min;
		System.out.println("randomWithXoRoShiRo128PlusRandom:"+randomWithXoRoShiRo128PlusRandom);
		System.out.println("------------------------------");		
		
	}
	

}
