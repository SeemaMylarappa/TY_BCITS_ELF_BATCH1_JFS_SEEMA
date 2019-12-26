package com.ty.bcits.TreeSet;

public class Person implements Comparable{
	int age;
	String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Object o) {
		
		return 0;
	}

}
