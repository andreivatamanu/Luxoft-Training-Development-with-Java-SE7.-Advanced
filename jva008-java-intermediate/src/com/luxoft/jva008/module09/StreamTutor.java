package com.luxoft.jva008.module09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTutor {
	 public static void main(String[] args) {
		 List<String> stringsList = new ArrayList<String>();
	     stringsList.add("Alpha");
	     stringsList.add("Beta");
	     stringsList.add("Gamma");  
	     Stream<String> stream = stringsList.stream();
	     stream.forEach(s -> System.out.println(s));
		 
		 Stream.of("One","Two","Three").forEach(s->System.out.println(s));
	 }
}
