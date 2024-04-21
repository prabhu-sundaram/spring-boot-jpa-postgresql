package com.dm.springbootjpapostgresql.example.streamExample;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dm.springbootjpapostgresql.example.beans.Product;

public class StreamExample {

	public static void main(String[] args) {
		
		List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));
        
		  //Stream Creation 
		System.out.println("---------------");
		String[] arr = new String[]{"a", "b", "c"}; 
		Stream<String> stream = Arrays.stream(arr);
  	    stream = Stream.of("a", "b", "c");
		  
		LinkedList<String> ll2=new LinkedList<String>();
		  ll2.add("Ravi");  
		  ll2.add("Vijay");    
		  ll2.add("Ravi");  
		  ll2.add("Ajay"); 		  
		  Stream<String> stream22 = ll2.stream();
		  
		  //Multi-threading With Streams 
		  System.out.println("---------------");
		  ll2.parallelStream().forEach(element -> doWork(element));
		  
		  //Stream Operations 
		  System.out.println("---------------");
		  long count = ll2.stream().distinct().count();
		  System.out.println("count:"+count);

	        long count3 = productsList.stream()  
                    .count();  
        System.out.println("count3:"+count3); 
        
	       // count number of products based on the filter  
	        long count2 = productsList.stream()  
	                    .filter(product->product.getPrice()<30000)  
	                    .count();  
	        System.out.println("count2:"+count2);  
	        
		  
		LinkedList<String> ll=new LinkedList<String>();
		  ll.add("Ravi");  
		  ll.add("Vijay");  
		  ll.add("Ravi");  
		  ll.add("Ajay"); 
		  
		//Iterating
		  System.out.println("---------------");
		for (String string : ll) {
		    if (string.contains("a")) {
		        //return true;
		    	System.out.println("true");
		    }
		}
		
		boolean isExist = ll.stream().anyMatch(element -> element.contains("a"));

		System.out.println("isExist:"+isExist);
		
	       Stream.iterate(1, element->element+1)  
	        .filter(element->element%5==0)  
	        .limit(5)  
	        .forEach(System.out::println);
	       
		//Filtering
		System.out.println("---------------");
		ArrayList<String> list = new ArrayList<>();
		list.add("One");
		list.add("OneAndOnly");
		list.add("Derek");
		//list.add("Change");
		list.add("factory");
		list.add("justBefore");
		list.add("Italy");
		list.add("Italy");
		//list.add("Thursday");
		list.add("");
		list.add("");
		
		
		Stream<String> stream4 = list.stream().filter(element -> element.contains("d"));
		
		System.out.println("-------------------");
  
        List<Float> productPriceList = new ArrayList<Float>();  
        for(Product product: productsList){  
              
            // filtering data of list  
            if(product.getPrice()<30000){  
                productPriceList.add(product.getPrice());    // adding price to a productPriceList  
            }  
        }  
        System.out.println("productPriceList:"+productPriceList);   // displaying data  
        
        List<Float> productPriceList2 =productsList.stream()  
                .filter(p -> p.getPrice() > 30000)// filtering data  
                .map(p->p.getPrice())        // fetching price  
                .collect(Collectors.toList()); // collecting as list  
        System.out.println("productPriceList2:"+productPriceList2);  

        productsList.stream()  
        .filter(product -> product.getPrice() == 30000)  
        .forEach(product -> System.out.println(product.getName()));    
        
		//Mapping
		System.out.println("---------------");
		List<String> uris = new ArrayList<>();
		uris.add("C:\\My.txt");
		Stream<Path> stream5 = uris.stream().map(uri -> Paths.get(uri));
		
		/*
		 * List<Detail> details = new ArrayList<>(); details.add(new Detail());
		 * Stream<String> stream3 = details.stream().flatMap(detail ->
		 * detail.getParts().stream());
		 */
		
		//Matching
		System.out.println("---------------");
		boolean isValid = list.stream().anyMatch(element -> element.contains("h")); // true
		boolean isValidOne = list.stream().allMatch(element -> element.contains("h")); // false
		boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h")); // false
		System.out.println("isValid:"+isValid);
		System.out.println("isValidOne:"+isValidOne);
		System.out.println("isValidTwo:"+isValidTwo);
		
		
		//Reduction
		System.out.println("---------------");
		List<Integer> integers = Arrays.asList(1, 1, 1);
		Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
		System.out.println("reduced:"+reduced);
		
		System.out.println("---------------");
        Float totalPrice = productsList.stream()  
                .map(product->product.getPrice())  
                .reduce(0.0f,(sum, price)->sum+price);   // accumulating price  
    System.out.println("totalPrice:"+totalPrice);  
    
    System.out.println("---------------");   
    float totalPrice2 = productsList.stream()  
            .map(product->product.getPrice())  
            .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class  
    System.out.println("totalPrice2:"+totalPrice2);  
    
    
		
		//Collecting
		System.out.println("---------------");
		List<String> resultList = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
		System.out.println("resultList:"+resultList);
		
        // Using Collectors's method to sum the prices.  
        double totalPrice3 = productsList.stream()  
                        .collect(Collectors.summingDouble(product->product.getPrice()));  		
        System.out.println("totalPrice3:"+totalPrice3);  
        
        // max() method to get max Product price   
        Product productA = productsList.stream()  
                        .max((product1, product2)->   
                        product1.getPrice() > product2.getPrice() ? 1: -1).get();  
          
        System.out.println("max:"+productA.getPrice());  
        // min() method to get min Product price  
        Product productB = productsList.stream()  
                .max((product1, product2)->   
                product1.getPrice() < product2.getPrice() ? 1: -1).get();  
        System.out.println("min:"+productB.getPrice());          
		
	}

	public static String doWork(String element) {
		System.out.println("element:"+element);
		return 1+element;
		
	}
	
}
