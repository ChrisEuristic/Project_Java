package com.ruby.java.ch09;

public class Test02 {

	public static void main(String[] args) {

		String s1 = new String("Java");
		String s2 = "Java";
		
		String s3 = new String("Java");
		String s4 = "Java";
		/*
		if(s1 == s3)
			System.out.println(true);
		else
			System.out.println(false);
		
		if(s2 == s4)
			System.out.println(true);
		else
			System.out.println(false);
		*/
		
		if(s1.equals(s3))
			System.out.println(true);
		else
			System.out.println(false);
		
		if(s2.equals(s4))
			System.out.println(true);
		else
			System.out.println(false);
		
		String s5 = "JAVA";
		
		if(s1.equals(s5))
			System.out.println(true);
		else
			System.out.println(false);
		
		if(s1.equalsIgnoreCase(s5))
			System.out.println(true);
		else
			System.out.println(false);

	}

}
