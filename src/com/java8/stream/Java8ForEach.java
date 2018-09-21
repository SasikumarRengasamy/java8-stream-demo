package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8ForEach {
	
	public static void main(String[] args) {
		
		List<Integer> listValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		//listValues.forEach(listValue -> System.out.println(listValue));
		
		/*Consumer<Integer> consumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer i) {
				System.out.println(i);
			}
		};*/
		
		//Consumer<Integer> consumer = i -> System.out.println(i);
		
		listValues.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer i) {
				System.out.println(i);
			}
		});
	}
}
