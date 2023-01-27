package com.ruby.java.ch11;

import java.io.FileInputStream;

public class Test04 {
	/*
	public static void test4() throws Exception {
		FileInputStream fi = new FileInputStream("a.txt");
		int c = fi.read();
		System.out.println((char) c);
	}

	public static void main(String[] args) {

		try {
			test4();
			System.out.println("play");
		} catch(Exception e) {
			System.out.println("hi");
		}

	}*/
	
	public static void main(String[] args) {
		try {
			FileInputStream fi = new FileInputStream("a.txt");
			int c = fi.read();
			System.out.println((char) c);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
