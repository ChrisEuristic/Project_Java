package com.ruby.java.ch08.polymorphism;

class Father {
	public int a = 0;
	public void show() {
		System.out.println("Father!");
	}
}

class Child extends Father {
	public int a = 1;
	public int b = 2;
	public void show() {
		System.out.println("Child!");
	}
}

class Show {
	public void show(Father o) {
		System.out.println(o.a);
	}
}


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Show sh = new Show();
		Father f = new Father();
		Child c = new Child();
		Father df = new Father();
		
		sh.show(f);
		sh.show(c);
		Child dc = (Child)df; 
	}

}
