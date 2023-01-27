package edu;

public class Test37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = {90, 85, 78, 100, 98};
		int sum = 0;		// 총점
		double avg = 0.0;	// 평균
		int max = 0;		// 최대값
		int min = 999;		// 최소값
		
		for(int i=0; i<score.length; i++) {
			sum += score[i];
			
			if(score[i] > max) max = score[i];
			if(score[i] < min) min = score[i];
		}
		avg = sum / score.length;		
		
		System.out.println("총점 : "+ sum);
		System.out.println("평균 : "+ avg);
		System.out.println("최대 : "+ max);
		System.out.println("최소 : "+ min);
		
		System.out.println();
	}

}
