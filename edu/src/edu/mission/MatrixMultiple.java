package edu.mission;

public class MatrixMultiple {
	
	public static void printArray (int sumMatrix[][]) {
		for(int i=0; i<sumMatrix.length; i++) {
			for(int j=0; j<sumMatrix[0].length; j++) {
				System.out.printf("%d\t", sumMatrix[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int matrix1[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		int matrix2[][] = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
		int sumMatrix[][] = new int[3][3];
		
		for(int row=0; row<matrix1.length; row++) {
			for(int col=0; col<matrix2[0].length; col++) {
				int sum = 0;
				for(int sumIndex=0; sumIndex<matrix2.length; sumIndex++) {
					sumMatrix[row][col] += matrix1[row][sumIndex] * matrix2[sumIndex][col];
				}
			} // for col
		} // for row
		
		printArray(sumMatrix);

	}

}
