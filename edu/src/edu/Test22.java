package edu;

public class Test22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 12, b = 2;
		char op = '!';
		
		switch(op) {
		case '+':
			System.out.println(a + b); break;
		case '-':
			System.out.println(a - b); break;
		case '*':
			System.out.println(a * b); break;
		case '/':
			System.out.println(a / b); break;
		default:
			System.out.println("잘못된 입력");
		}
	}

}
