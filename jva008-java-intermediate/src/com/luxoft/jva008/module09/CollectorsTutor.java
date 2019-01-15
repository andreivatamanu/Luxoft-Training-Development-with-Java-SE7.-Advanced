package com.luxoft.jva008.module09;

import java.util.stream.Stream;

public class CollectorsTutor {

	public static Stream<String> getStream() {
		return Stream.of("John Lennon", "Paul McCartney", 
				"George Harrison", "Ringo Star");
	}
	
	/**
	 * Find the longest text in the stream in 2 ways and print it:
	 * - Using getStream().collect()
	 * - Using getStream().reduce()
	 */
	public static void main(String[] args) {

	}
	
}
