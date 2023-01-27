package com.ruby.java.test1;

interface Apple {
	public static int a = 0;
}

public class Exam02_1 {
	
	public static void main(String[] args) {
		
		Apple apple = new Apple() {
			void getAppleCount(){
				System.out.println(a);
			}
		};
		
		
	}
}
