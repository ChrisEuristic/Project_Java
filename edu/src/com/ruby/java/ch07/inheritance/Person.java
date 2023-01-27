package com.ruby.java.ch07.inheritance;

public class Person {
	private String ssd_ID;
	public void setssd_ID(String ssd_ID) {
		this.ssd_ID = ssd_ID;
	}
	
	private String name;
	private int age;
	
	public Person() {
		System.out.println("Person() 생성자 실행");
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Super Class : Person(name, age) 생성자 실행!");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return name + ":" + age;
	}
}