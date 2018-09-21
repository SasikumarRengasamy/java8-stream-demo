package com.java8.stream;

import java.util.Arrays;
import java.util.List;

public class Java8MethodReference {

	public static void main(String[] args) {
		
		List<Integer> listValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		//listValues.forEach(System.out :: println);
		listValues.forEach(Java8MethodReference :: doubleListValues);
	}
	
	public static void doubleListValues(int i) {
		System.out.println(i*2); 
	}
}
