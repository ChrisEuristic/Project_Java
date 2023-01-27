package edu;


public class Test20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 70;
		char grade;
		
		if(score >= 90) grade = 'A';
		else if(score >= 80) grade = 'B';
		else if(score >= 70) grade = 'C';
		else if(score >= 60) grade = 'D';
		else grade = 'F';
		
		System.out.println(grade);
	}

}
