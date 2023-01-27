package com.ruby.java.test1;

import java.util.Scanner;

public class TestArmor {
	
	static int testFunction(int...var) {
		return var.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;

		a = testFunction(1);
		System.out.println(a);
		a = testFunction(1,2);
		System.out.println(a);
		a = testFunction(1,2,3);
		System.out.println(a);
	}

}
