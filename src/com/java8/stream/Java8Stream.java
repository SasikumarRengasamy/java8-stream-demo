package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;


/**
 * @author srengasamy
 * Multiply list of values and add each other using stream and map
 * 
 */
public class Java8Stream {
	
	public void internallyHowStreamIsWorking(List<Integer> list) {
		
		Function<Integer, Integer> function = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer i) {
				return i * 2;
			}
		};
		
		BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer i, Integer j) {
				return i+j;
			}
		};
		
		Stream<Integer> s1 = list.stream(); // getting list of values as stream
		
		Stream<Integer> s2 = s1.map(function); // map the values (ie.. value * 2)
		
		Integer result = (Integer)s2.reduce(0, binaryOperator);
		
		System.out.println(result);
	}
	
	public void simplifyMethodOne(List<Integer> list) {
		
		Stream<Integer> s1 = list.stream();
		
		Stream<Integer> s2 = s1.map(new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer i) {
				return i * 2;
			}
		});
		
		Integer result = (Integer)s2.reduce(0, new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer i, Integer j) {
				return i+j;
			}
		});
		
		System.out.println(result);
	}
	
	public void simplifyMethodTwo(List<Integer> list) {
		
		Stream<Integer> s1 = list.stream();
		
		Stream<Integer> s2 = s1.map(i -> i*2);
		
		Integer result = (Integer)s2.reduce(0, (i, j) -> i+j);
		
		System.out.println(result);
	}
	
	public void simplifyMethodThree(List<Integer> list) {
		
		Stream<Integer> s1 = list.stream();
		Integer result = s1.map(i -> i*2).reduce(0, (i, j) -> i+j);
		System.out.println(result);
	}
	
	public void simplifyMethodFour(List<Integer> list) {
		
		Integer result = list.stream().map(i -> i*2).reduce(0, (i, j) -> i+j);
		System.out.println(result);
		//System.out.println(listValues.stream().map(i -> i*2).reduce(0, (i, j) -> i+j));
	}
	
	public static void main(String[] args) {
		
		List<Integer> listValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		Java8Stream obj = new Java8Stream();
		obj.internallyHowStreamIsWorking(listValues);
		obj.simplifyMethodOne(listValues);
		obj.simplifyMethodTwo(listValues);
		obj.simplifyMethodThree(listValues);
		obj.simplifyMethodFour(listValues);
	}

}
