package com.algorithm.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class TrainingArray {
	
	public static ArrayList merge(ArrayList<Integer> arrList1, ArrayList<Integer> arrList2) {
		ArrayList<Integer> mergeList = new ArrayList<Integer>();
		
		mergeList.addAll(arrList1);
		mergeList.addAll(arrList2);
		mergeList.sort(null);
		
		Iterator<Integer> iter = mergeList.iterator();
		
		int a=0, b=0;
		
		while(iter.hasNext()) {
			a = b;
			b = iter.next();
			if(a == b) {
				iter.remove();
				continue;
			}
		}
		
		return mergeList;
	}

	public static void main(String[] args) {

		int arr[] = {3, 4, 2, 5, 7, 1, 9, 6, 8};
		int arr1[] = {3, 3, 4, 2, 5, 7, 1, 9, 6, 8};
		
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		ArrayList<Integer> mergeList = new ArrayList<Integer>();
		
		for(int i=0;i<10;i++) {
			arrayList1.add((int)Math.ceil(Math.random() * 10));
			arrayList2.add((int)Math.ceil(Math.random() * 10));
		}
		
		mergeList = merge(arrayList1, arrayList2);
		
		System.out.println("List1: " + arrayList1);
		System.out.println("List2: " + arrayList2);
		System.out.println("Merge: " + mergeList);

	}

}
