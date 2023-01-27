package com.ruby.java.ch10;

import java.util.Scanner;

class Gugudan {
	void printGugudan(int dan, int column) {
		if(dan == 0)
			dan = 9;
		int iterNumber = (int)(Math.ceil((dan - 1) / (double)column));
		int guguGrade = 2; // 몇단인지?
		
		for(int i = 0; i < iterNumber; i++) {
			for(int j = 1; j <= dan; j++) {
				for(int k = 1; k <= column; k++) {
					if(guguGrade + (k - 1) > dan)
						continue;
					else
						System.out.printf("%d * %d = %2d\t", guguGrade + (k - 1), j, (guguGrade + (k - 1)) * j);
				}
				System.out.println();
				System.out.println("─".repeat(column * 16));
			}
			guguGrade += column;
		}
		
	}
}

public class Exam03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Gugudan gugu = new Gugudan();
		int column = 1;
		int dan = 9;
		
		while(column > 0) {
			System.out.print("구구단을 출력합니다. 몇 단, 몇 열로 출력할까요?(0 입력시 구구단이 출력됩니다) => ");
			dan = sc.nextInt();
			column = sc.nextInt();
			gugu.printGugudan(dan, column);
		}
		

	}

}
