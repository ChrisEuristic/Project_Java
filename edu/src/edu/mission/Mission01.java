package edu.mission;



public class Mission01 {

	public static void main(String[] args) {
		
		int time;	// 임의의 시간
		double a = 9.81;	// 중력 가속도		
		double x;	// 정답
		
		time = 5;
		
		x = (0.5 * (a * Math.pow(time, 2))) + 0 * a + 0;

		System.out.printf("%d초 후 위치 : %.2fm", time, 1000 - x);
		
	}

}
