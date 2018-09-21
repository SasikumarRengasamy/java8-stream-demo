package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author srengasamy
 * Program for filter method (Print the values which are divisible by 5)
 *
 */
public class Java8Filter {
	
	public static void main(String[] args) {
		
		List<Integer> listValues = Arrays.asList(12, 25, 30, 46, 55, 67, 70);
		
		// below Java 8
		int result = 0;
		for (int i : listValues) {
			if (i % 5 == 0) {
				//result = result + i;
				result += i;
			}
		}
		System.out.println(result);
		
		// Java 8
		System.out.println(listValues.stream()
									 .filter(i -> i%5 == 0)
									 .reduce(0, (i,j) -> (i+j)));
		
		// Internal working of filter() in java 8
		Predicate<Integer> p = new Predicate<Integer>() {

			@Override
			public boolean test(Integer i) {
				return i % 5 == 0;
			}
		};
		
		System.out.println(listValues.stream()
									 .filter(p)
									 .reduce(0, (i,j) -> i+j));
		
		// Simplify method
		System.out.println(listValues.stream()
				 .filter(new Predicate<Integer>() {

						@Override
						public boolean test(Integer i) {
							return i % 5 == 0;
						}
					})
				 .reduce(0, (i,j) -> i+j));
		
		
	}

}
