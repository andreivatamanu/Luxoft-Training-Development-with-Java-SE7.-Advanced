package com.luxoft.jva008.module08;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class Person {
	
	public enum Sex {
        MALE, FEMALE
    }

    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    
    public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	private static int setRandomYear(){
		return (int) (2000 + 14* Math.random());
	}
	
	private static int setRandomMonth(){
		return (int) (12* Math.random());
	}

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
    
    public void printPerson() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	System.out.format("%s %s%n", this.name, dateFormat.format(this.birthday));
    }
    
    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(SOURCE sourceCollection,
       Supplier<DEST> collectionFactory) {
            
       DEST result = collectionFactory.get();
       for (T t : sourceCollection) {
            result.add(t);
       }
       return result;
    }
    
    public static void main(String[] args) {
    	String[] stringArray = { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };
    	orderAndDisplayStrings(stringArray);
    	
    	Person[] personArray = new Person[stringArray.length];
    	populatePersons(stringArray, personArray);
    	
    	Arrays.sort(personArray, (a, b) -> {
    		return a.getBirthday().compareTo(b.getBirthday());
    	});
    	displayPersonsAndBirthdays(personArray);
    	
    	Arrays.sort(personArray, (a, b) -> Person.compareByAge(a, b));
    	displayPersonsAndBirthdays(personArray);

    	Arrays.sort(personArray, Person::compareByAge);
    	displayPersonsAndBirthdays(personArray);
    	
    	transferElements(personArray);
    	transferElementsWithLambda(personArray);
    	
    }

	public static void transferElements(Person[] personArray) {
		List<Person> personList = Arrays.asList(personArray);
    	Set<Person> rosterSet = transferElements(personList, HashSet::new);
    	System.out.println("Printing rosterSet:");
        rosterSet.stream().forEach(p -> p.printPerson());
        System.out.println();
	}
	
	public static void transferElementsWithLambda(Person[] personArray) {
		List<Person> personList = Arrays.asList(personArray);
    	Set<Person> rosterSetLambda = transferElements(personList, () -> { return new HashSet<>(); });
    	System.out.println("Printing rosterSetLambda:");
        rosterSetLambda.stream().forEach(p -> p.printPerson());
        System.out.println();
	}

	private static void populatePersons(String[] stringArray, Person[] personArray) {
		Calendar cal = Calendar.getInstance();
		
		for(int i=0; i<stringArray.length;  i++) {
    		personArray[i] = new Person();
    		cal.set(Calendar.YEAR, setRandomYear());
    		cal.set(Calendar.MONTH, setRandomMonth());
    		cal.set(Calendar.DAY_OF_MONTH, 1);
    		personArray[i].name = stringArray[i];
    		personArray[i].birthday = cal.getTime();
    	}
		System.out.println();
	}

	private static void displayPersonsAndBirthdays(Person[] personArray) {
		for (Person person : personArray) {
			person.printPerson();
     	}
		System.out.println();
	}

	private static void orderAndDisplayStrings(String[] stringArray) {
		Arrays.sort(stringArray, String::compareToIgnoreCase);
    	
    	for (String name : stringArray) {
    		System.out.println(name);
    	}
	}


}
