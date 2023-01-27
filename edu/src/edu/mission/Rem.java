package edu.mission;

import java.util.Scanner;

public class Rem { // 최대공약수와 최소공배수 구하기

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int max, min, rem;
		int const_max, const_min;
		int resultMax, resultMin;
		
		System.out.println("최대공약수와 최소공배수를 구할 두 수를 입력해주세요.");
		max = sc.nextInt();
		min = sc.nextInt();
		const_max = max;
		const_min = min;
		
		if(max < min) {
			rem = max;
			max = min;
			min = rem;
		}
		
		while(true) {
			rem = max % min;
			
			if(rem == 0) {
				resultMax = min;
				resultMin = (const_max * const_min) / resultMax;
				break;
			}
			else {
				max = min;
				min = rem;
			}
		}
		System.out.println("최대공약수 : " + resultMax + ", 최소공배수 : " + resultMin);
	}

}
