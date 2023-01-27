package com.ruby.java.ch12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Exam01 {

	public static void main(String[] args) {
		
		ArrayList input1 = new ArrayList();
		ArrayList input2 = new ArrayList();
		ArrayList temp = new ArrayList();
		ArrayList sum = new ArrayList();
		int olim = 0;
		

		try {
			String number[] = new String[2];
			BufferedReader bi = new BufferedReader(new FileReader("input.txt"));
			BufferedWriter fo = new BufferedWriter(new FileWriter("output.txt"));
			
			for(int i = 0; i < number.length; i++) {
				number[i] = bi.readLine();			// number[0]에 1번 줄, [1]에 2번 줄 대입.
			}
			String arr1[] = number[0].split("");
			String arr2[] = number[1].split("");
			
			
			for(int i = arr1.length - 1; i >= 0 ; i--) {
				input1.add(arr1[i]);
			}
			System.out.println(input1);
			for(int i = arr2.length - 1; i >= 0 ; i--) {
				input2.add(arr2[i]);
			}
			System.out.println(input2);
			
			if(input1.size() < input2.size()) {	// Swap
				temp = input1;
				input1 = input2;
				input2 = temp;				
			}
			
			for(int i = 0; i < input2.size(); i++) {
				int tempSum = Integer.parseInt((String) input1.get(i)) + Integer.parseInt((String) input2.get(i)) + olim;
				if(tempSum >= 10) {					
					tempSum %= 10;
					sum.add(tempSum);
					olim = 1;
				}
				else {
					sum.add(tempSum);
					olim = 0;
				}
			}
			
			for(int i = input2.size(); i < input1.size(); i++) {
				sum.add(Integer.parseInt((String) input1.get(i)));
			}
			
			fo.write("12345");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
