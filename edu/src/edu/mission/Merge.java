package edu.mission;

import java.util.Scanner;

public class Merge {
	
	public static int[] merge(int array1[], int array2[]) {
		int mergeArray[] = new int[array1.length + array2.length];
		
		for(int i=0; i<mergeArray.length; i++) {
			if(i % 2 == 0)
				mergeArray[i] = array1[i/2];
			else
				mergeArray[i] = array2[i/2];
		}		
		return mergeArray;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 정해주세요 => ");
		int arraySize = sc.nextInt();		
		int array1[] = new int[arraySize];
		int array2[] = new int[arraySize];
		int mergeArray[];
		
		
		for(int i=0; i<arraySize; i++) {
			array1[i] = (int)(Math.random() * 10);
			array2[i] = (int)(Math.random() * 10);
		}
		
		mergeArray = merge(array1, array2);
		
		for(int i=0; i<3; i++) {
			int arrayLength = 0;
			
			switch(i) {
			case 0: arrayLength = array1.length; break;
			case 1: arrayLength = array2.length; break;
			case 2: arrayLength = mergeArray.length; break;
			default : break;
			}
			for(int j=0; j<arrayLength; j++) {
				switch(i) {
				case 0: System.out.print(array1[j] + " "); break;
				case 1: System.out.print(array2[j] + " "); break;
				case 2: System.out.print(mergeArray[j] + " "); break;
				default : break;
				}
			}
			System.out.println();
		}

	}

}
