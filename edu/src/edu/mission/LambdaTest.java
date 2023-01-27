package edu.mission;

interface InterClass {
	public void sum(int a, int b);
}

public class LambdaTest {

	public static void main(String[] args) {
		
		InterClass inter = new InterClass() {
			public void sum(int a, int b) {
				System.out.println(a + b);
			}
		};
		

	}

}
