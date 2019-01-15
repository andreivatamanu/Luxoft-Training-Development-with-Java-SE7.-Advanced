package com.luxoft.jva008.module09;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceTutor {
	
	public static void main(String[] args) {
		Integer id = 0; // identity element
		BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;
		BinaryOperator<Integer> max = (i1, i2) -> i1 > i2 ? i1 : i2;

		Stream<Integer> stream = Stream.empty();
		int red = stream.reduce(id, sum);
		System.out.println(red);
		
		stream = Stream.of(1);
		red = stream.reduce(id, sum);
		System.out.println(red);
		
		stream = Stream.of(1, 2, 3, 4);
		red = stream.reduce(id, sum);
		System.out.println(red);
		
		stream = Stream.empty();
		red = stream.reduce(id, max);
		System.out.println(red);
		
		stream = Stream.of(1);
		red = stream.reduce(id, max);
		System.out.println(red);
		
		stream = Stream.of(1, 2, 3, 4);
		red = stream.reduce(id, max);
		System.out.println(red);
		
	}

}
