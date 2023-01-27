package edu;

public class Test32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = new int[5];
		int[] arr;
		
		arr = new int[] {1,2,3,4,5};
		
		for(int i=0; i<5; i++) {
			arr[i] *= 10;
			System.out.println(arr[i]);
		}
		
		System.out.println(arr.hashCode());
	}

}
