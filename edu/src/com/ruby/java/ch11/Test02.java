package com.ruby.java.ch11;

public class Test02 {
	
	static int test2() {
		int a[] = new int[3];
		
		try {
			System.out.println(1);
			System.out.println(2);
			System.out.println(a[3]);
		} catch(Exception e) {
			System.out.println("Error!");
			return 0;
		} finally {
			System.out.println("OK!");
		}
		System.out.println(4);
		return 0;

	}

	public static void main(String[] args) {

		int a = test2();
		
	}

}
