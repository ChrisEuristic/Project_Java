package edu.mission;

import java.util.Scanner;

public class Mission02 {

	public static void main(String[] args) {

		int price;
		int bill50, bill10, bill5, bill1;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			price = sc.nextInt();
			
			bill50 = price / 50000;
			price %= 50000;
			bill10 = price / 10000;
			price %= 10000;
			bill5 = price / 5000;
			price %= 5000;
			bill1 = price / 1000;
			price %= 1000;
			
			System.out.println("5만원 : " + bill50 + "장");
			System.out.println("1만원 : " + bill10 + "장");
			System.out.println("5천원 : " + bill5 + "장");
			System.out.println("1천원 : " + bill1 + "장");
			System.out.println("할인 금액은 " + price + "원입니다.");
		}
		
	}

}
