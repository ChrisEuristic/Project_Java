package edu;

public class Test38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];
		int k = 0;
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				arr[i][j] = ++k;
				if(j <= i) System.out.printf("%d\t",arr[i][j]);
			}
			System.out.println();
		}
	}

}
