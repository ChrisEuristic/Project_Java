package com.ruby.java.ch09;

public class Test01 {

	public static void main(String[] args) {

		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		MyObject obj4 = new MyObject(1);
		MyObject obj5 = new MyObject(2);
		
		//System.out.println(obj1.equals(obj2));
		System.out.println(obj4.equals(obj5));
		

	}

}
