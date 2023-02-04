package com.algorithm.training;

import java.util.ArrayList;

class CustomArrayList<T> {
	T list[];
	T tempCopyList[];
	int listSize = 5;
	int howMany;
	
	CustomArrayList() { resizeList(); }
	
	private void resizeList() {
		tempCopyList = list;
		list = (T[]) new Object[listSize];
		if(!isEmpty()) {
			for(int i = 0; i < howMany; i++)
				list[i] = tempCopyList[i];
			tempCopyList = null;
		}
	}
	
	public void add(T item) {
		if(howMany >= listSize) {
			listSize *= 1.5;
			resizeList();
		}
		list[howMany++] = item;
	}
	
	public void add(int i, T item) throws Exception {
		if(howMany >= listSize) {
			listSize *= 1.5;
			resizeList();
		}
		if(i < 0 || i >= listSize)
			throw new Exception();
		list[i] = item;
		howMany++;
	}
	
	public void remove() { if(howMany > 0) howMany--; }
	
	public void remove(int i) {
		if(howMany > 0 && i < howMany) {
			for(int j = i + 1; j < howMany; j++)
				list[j - 1] = list[j];
			howMany--;
		}
	}
	
	// 리스트 크기 최적화
	public void listSizeOptimization() {
		listSize = (int) ((howMany * 1.5 <= 5) ? 5 : (howMany * 1.5));
		resizeList();
	}
	
	public void clear() {
		list = null;
		listSize = 5;
		howMany = 0;
		resizeList();
	}
	
	public String toString() {
		for(int i = 0; i < howMany; i++) {
			System.out.print("< " + list[i] + (i == (howMany - 1) ? " >" : " >, "));
		}
		return "\n";
	}
	
	public int size() { return howMany; }
	public boolean isEmpty() { return howMany <= 0; }
	public T get(int i) { return list[i]; }
	public int getLength() { return listSize; } // 테스트용 메소드
}

public class ExampleArrayList {

	public static void main(String[] args) {

		CustomArrayList<String> arr = new CustomArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			arr.add("Hello!");
			System.out.println(arr.getLength());
			System.out.println(arr);
		}
		
		System.out.println(arr.get(2));
		arr.clear();
		System.out.println(arr.getLength());
		System.out.println(arr);
		
		for(int i = 0; i < 10; i++) {
			arr.add("Hello!");
			System.out.println(arr.getLength());
			System.out.println(arr);
		}
		
		for(int i = 0; i < 3; i++) {
			arr.add("Ho!");
			System.out.println(arr.getLength());
			System.out.println(arr);
		}
		
		for(int i = 0; i < 7; i++) {
			arr.remove(0);
			System.out.println(arr.getLength());
			System.out.println(arr);
		}
		arr.listSizeOptimization();
		System.out.println(arr.getLength());
		System.out.println(arr);
	}

}
