package com.binit.study.java8;

import java.util.Arrays;
import java.util.List;

public class NowJava8_1 {
	
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(  new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40));
		
		Person result = persons.stream()
						.filter(x -> "jack".equals(x.getName()))
						.findAny()
						.orElse(null);
		
		System.out.println(result);
						
	}

}
