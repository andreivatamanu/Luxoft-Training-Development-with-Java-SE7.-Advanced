package com.luxoft.jva008.module09;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {
    
	/**
	 * Find only elements with length > 3, which are equal to "two" or "three" 
	 * using predefined predicates.
	 * 
	 * Program should print "three"
	 */
	@SuppressWarnings("unused")
    public static void main(String[] args) {
        
		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        
        Predicate<String> p1 = s -> s.length() > 3 ;
        
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");
        
    }
}
