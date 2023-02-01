package com.homework.java;

class pnusw33Exception extends RuntimeException {
	public pnusw33Exception(){
		
	}
}

public class TempClass {

	public static void main(String[] args) throws Exception {

		System.out.println("Exception:: ");
		try {
			throw new pnusw33Exception();
			
			//throw new RuntimeException();
			//throw new Exception();
		} catch(pnusw33Exception e) {
			e.printStackTrace();
		}
	}

}
