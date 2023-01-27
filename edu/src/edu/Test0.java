package edu;

import java.util.Scanner;

public class Test0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class Apple {
			String color;
			int price;
		}
		
		System.out.println("사과를 몇 개 ");
		Scanner sc = new Scanner(System.in);
		
		Apple a = new Apple();
		Apple b = new Apple();
		
		a.color = "Red";
		a.price = 18000;
		
		b.color = "Yellow";
		b.price = 5000;
		
		System.out.println(a.color + " Apple\'s price is " + a.price);
		System.out.println(b.color + " Apple\'s price is " + b.price);
		
	}

}
