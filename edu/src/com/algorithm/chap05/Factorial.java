package com.algorithm.chap05;

import java.util.Scanner;

public class Factorial {
	
	static int factorial(int a) {
		return (a == 0) ? 1 : a * factorial(a-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println(factorial(sc.nextInt()));
	}

}
