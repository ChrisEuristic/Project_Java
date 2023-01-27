package edu;

public class Test38_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix1, matrix2, sumproduct;
		matrix1 = new int[2][3];
		matrix2 = new int[3][2];
		sumproduct = new int[2][2];
		int sum = 0;
		
		for(int i=0;i<2;i++) {
			for(int j=0;j<3;j++) {
				matrix1[i][j] = (int) (Math.random() * 10);
				matrix2[j][i] = (int) (Math.random() * 10);
			}
		}
		
		for(int i=0;i<2;i++) {
			for(int j=0;j<3;j++) {
				System.out.printf("%d\t",matrix1[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				System.out.printf("%d\t",matrix2[i][j]);
			}
			System.out.println();
		}
		
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<3;k++) {
					sum += matrix1[i][k] * matrix2[k][j];
				}
				sumproduct[i][j] = sum;
				sum = 0;
			}
		}
		
		System.out.println();
		
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				System.out.printf("%d\t",sumproduct[i][j]);
			}
			System.out.println();
		}
		
	}

}
