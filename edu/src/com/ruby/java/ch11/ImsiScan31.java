package com.ruby.java.ch11;

public class ImsiScan31 {
	
	public static String primeNumber(String args[]) {
		int inputInt[] = new int[args.length];
		
		for(int i = 0; i < args.length; i++) {
			inputInt[i] = Integer.parseInt(args[i]);
		}
		
		try {			
			for(int i = 0; i < inputInt.length; i++) {
				for(int j = 2; j < inputInt[i]; j++) {
					if(inputInt[i] % j == 0)
						return inputInt[i] + "는 소수가 아닙니다.";
				}
				return inputInt[i] + "는 소수입니다.";
			}
		} catch(Exception e) {
			return "자연수를 입력하세요.";
		}
		
		return "";		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(primeNumber(args));

	}

}
