package com.luxoft.jva008.module09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MappingTutor {
	
	public static void main(String[] args) {

		List<String> list1 = Arrays.asList("One", "Two");
        List<String> list2 = Arrays.asList("Three", "Four");
        Stream.of(list1, list2).flatMap(list -> list.stream()).forEach(s->System.out.println(s));
        Stream.of(list1, list2).map(list -> list).forEach(s->System.out.println(s));

	}
}
