package edu.mission;

import java.util.Scanner;

// 바이너리 미션01 : Main 함수에 몰아서 구현하기

public class Binary01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int inputOct, oct;
		int[] binary;
		int maxIndex = 0;
		int index = 0;
		
		System.out.print("이진수로 변환할 십진수를 입력해주세요. => ");
		inputOct = sc.nextInt();
		oct = inputOct;
		
		while(inputOct > 0 ) {
			inputOct /= 2;
			maxIndex++;
		}
		
		binary = new int[maxIndex];
		
		while(oct > 0) {
			binary[index] = oct % 2;
			oct /= 2;
			index++;
		}
		
		for(int i = maxIndex-1; i >= 0; i--) {
			System.out.print(binary[i]);
		}

	}

}
