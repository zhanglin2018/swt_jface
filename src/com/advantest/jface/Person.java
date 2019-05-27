package com.advantest.jface;

import java.util.Arrays;

public class Person {
	public String firstName = "John";
	public String lastName = "Doe";
	public int age = 37;
	public Person[] children = new Person[0];
	public Person parent = null;
	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	public Person(String firstName, String lastName, int age, Person[] children) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.children = children;
		
		for (int i=0; i<children.length; ++i){
			children[i].parent = this;
		}
	}
	
	public static Person[] example() {
		return new Person[] {
				new Person("Dan", "Rubel", 41, new Person[] {
						new Person("Beth", "Rubel", 11),
						new Person("David", "Rubel", 6)
				}),
				new Person("Dan1", "Rubel1", 41, new Person[] {
						new Person("Beth1", "Rubel1", 11),
						new Person("David1", "Rubel1", 6)
				}),
				new Person("Mike", "Taylor", 55)
				
		};
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", children="
				+ Arrays.toString(children) + ", parent=" + parent + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
