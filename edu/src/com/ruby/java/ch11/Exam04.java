package com.ruby.java.ch11;

import java.util.Scanner;

public class Exam04 {
	
	public static String sosu() {
		Scanner sc = new Scanner(System.in);
		int inputInt;
		
		System.out.print("소수를 판독합니다. 수를 입력해주세요 => ");
		try {
			inputInt = sc.nextInt();
			
			for(int i = 2; i < inputInt; i++) {
				if(inputInt % i == 0)
					return "소수가 아닙니다.";
			}
			return "소수입니다.";
		} catch(Exception e) {
			return "자연수를 입력하세요.";
		} finally {
			sc.close();
		}
		
	}

	public static void main(String[] args) {

		
		System.out.println(sosu());

	}

}
