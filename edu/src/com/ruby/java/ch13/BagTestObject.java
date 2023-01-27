package com.ruby.java.ch13;

class Bag2 {
	private Object thing;

	public Bag2(Object thing) {
		this.thing = thing;
	}

	public Object getThing() {
		return thing;
	}

	public void setThing(Object thing) {
		this.thing = thing;
	}

	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}

class Book2 {
}

class PencilCase2 {
}

class Notebook2 {
}

public class BagTestObject {

	public static void main(String[] args) {
		Bag2 bag = new Bag2(new Book2());
		Bag2 bag2 = new Bag2(new PencilCase2());
		Bag2 bag3 = new Bag2(new Notebook2());

		bag.showType();
		bag2.showType();
		bag3.showType();
		
		bag = bag2;//error를 발생시키지 않지만 잘 못된 코드이다 
		/*
		Book book = bag.getThing();
		PencilCase pc = bag2.getThing();
		Notebook nb = bag3.getThing();
		*/
		Book book = (Book)bag.getThing();
		PencilCase pc = (PencilCase)bag2.getThing();
		Notebook nb = (Notebook)bag3.getThing();
	}
}