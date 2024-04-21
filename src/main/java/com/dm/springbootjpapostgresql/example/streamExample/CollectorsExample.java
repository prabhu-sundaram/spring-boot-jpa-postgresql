package com.dm.springbootjpapostgresql.example.streamExample;

import static java.util.stream.Collectors.*;
//import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.dm.springbootjpapostgresql.example.beans.Product;

public class CollectorsExample {

	public static void main(String[] args) {
		
        List<Product> productsList = new ArrayList<Product>();  
        
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
        
        
		List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
		
		List<String> result = givenList.stream().collect(toList());
		//List<String> result = givenList.stream().collect(toUnmodifiableList());
		//assertThatThrownBy(() -> result.add("foo")).isInstanceOf(UnsupportedOperationException.class);
		
		Set<String> result3 = givenList.stream().collect(toSet());
		
		List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
		Set<String> result4 = listWithDuplicates.stream().collect(toSet());
		//assertThat(result4).hasSize(4);
		
        // Converting product List into Set  
        Set<Float> productPriceList =   
            productsList.stream()  
            .filter(product->product.getPrice() < 30000)   // filter product on the base of price  
            .map(product->product.getPrice())  
            .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)  
        System.out.println("productPriceList:"+productPriceList);  
        
		//Set<String> result5 = givenList.stream().collect(toUnmodifiableSet());
		//assertThatThrownBy(() -> result.add("foo")).isInstanceOf(UnsupportedOperationException.class);
		
		List<String> result6 = givenList.stream().collect(toCollection(LinkedList::new));
		
		
		Map<String, Integer> result7 = givenList.stream().collect(toMap(Function.identity(), String::length));
		List<String> listWithDuplicates2 = Arrays.asList("a", "bb", "c", "d", "bb");
		/*
		 * assertThatThrownBy(() -> {
		 * listWithDuplicates2.stream().collect(toMap(Function.identity(),
		 * String::length)); }).isInstanceOf(IllegalStateException.class);
		 */		  
		
		Map<String, Integer> result8 = givenList.stream()
				  .collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));
		
		Map<String, Integer> result9 = givenList.stream()
				  .collect(toMap(Function.identity(), String::length));
		//assertThatThrownBy(() -> result9.put("foo", 3)).isInstanceOf(UnsupportedOperationException.class);
		
		
        // Converting Product List into a Map  
        Map<Integer,String> productPriceMap =   
            productsList.stream()  
                        .collect(Collectors.toMap(p->p.getId(), p->p.getName()));  
              
        System.out.println("productPriceMap:"+productPriceMap);  
        
		
		//List<String> result10 = givenList.stream().collect(collectingAndThen(toList(), ImmutableList::copyOf));
		
		
		String result11 = givenList.stream()
				  .collect(joining());//"abbcccdd"
		String result12 = givenList.stream()
				  .collect(joining(" "));//"a bb ccc dd"
		
		String result13 = givenList.stream()
				  .collect(joining(" ", "PRE-", "-POST"));//"PRE-a bb ccc dd-POST"

		
		Long result14 = givenList.stream().collect(counting());
		
		DoubleSummaryStatistics result15 = givenList.stream()
				  .collect(summarizingDouble(String::length));
		
		/*
		 * assertThat(result15.getAverage()).isEqualTo(2);
		 * assertThat(result15.getCount()).isEqualTo(4);
		 * assertThat(result15.getMax()).isEqualTo(3);
		 * assertThat(result15.getMin()).isEqualTo(1);
		 * assertThat(result15.getSum()).isEqualTo(8);
		 */
		
		Double result16 = givenList.stream()
				  .collect(averagingDouble(String::length));
		
		Double result17 = givenList.stream()
				  .collect(summingDouble(String::length));
		Optional<String> result18 = givenList.stream()
				  .collect(maxBy(Comparator.naturalOrder()));
		
		Map<Integer, Set<String>> result19 = givenList.stream()
				  .collect(groupingBy(String::length, toSet()));
		/*
		 * assertThat(result19) .containsEntry(1, newHashSet("a")) .containsEntry(2,
		 * newHashSet("bb", "dd")) .containsEntry(3, newHashSet("ccc"));
		 */
		
		Map<Boolean, List<String>> result20 = givenList.stream()
				  .collect(partitioningBy(s -> s.length() > 2));//{false=["a", "bb", "dd"], true=["ccc"]}

		List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
		Optional<Integer> min = numbers.stream().collect(minBy(Integer::compareTo));
		Optional<Integer> max = numbers.stream().collect(maxBy(Integer::compareTo));
		// do something useful with min and max		  
		/*
		 * numbers.stream().collect(teeing( minBy(Integer::compareTo), // The first
		 * collector maxBy(Integer::compareTo), // The second collector (min, max) -> //
		 * Receives the result from those collectors and combines them ));
		 */
		
		
		//Method Reference in stream
        List<Float> productPriceList2 =   
                productsList.stream()  
                            .filter(p -> p.getPrice() > 30000) // filtering data  
                            .map(Product::getPrice)         // fetching price by referring getPrice method  
                            .collect(Collectors.toList());  // collecting as list  
        System.out.println(productPriceList2);  
		
		
	}

}
