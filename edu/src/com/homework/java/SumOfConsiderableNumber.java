package com.homework.java;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SumOfConsiderableNumber {
	
	static String[] reverse(String[] arr) {
		for(int i = 0; i < arr.length/2; i++) {
			String temp = arr[i];
			arr[i] = arr[(arr.length - 1) - i];
			arr[(arr.length - 1) - i] = temp;
		}		
		return arr;
	}
	
	static ArrayList<Integer> sumArray(String[] arr1, String[] arr2) {
		int		loopSizeSmall	= arr1.length < arr2.length ? arr1.length : arr2.length;
		int		loopSizeBig 	= arr1.length < arr2.length ? arr2.length : arr1.length;
		
		 // 덧셈시 올림 계산 변수;
		int upNumber = 0;
		
		ArrayList<Integer> sumArr = new ArrayList<Integer>();
		
		for(int i = 0; i < loopSizeSmall; i++)
			sumArr.add(Integer.parseInt(arr1[i]) + Integer.parseInt(arr2[i]));
		
		if(arr1.length < arr2.length ? true : false)
			for(int i = loopSizeSmall; i < loopSizeBig; i++)
				sumArr.add(Integer.parseInt(arr2[i]));
		else
			for(int i = loopSizeSmall; i < loopSizeBig; i++)
				sumArr.add(Integer.parseInt(arr1[i]));
		
		for(int i = 0; i < sumArr.size(); i++) {
			
			upNumber += sumArr.get(i);
			
			if(upNumber >= 10) {
				upNumber %= 10;
				sumArr.set(i, upNumber);
				upNumber = 1;
			}
			else {
				sumArr.set(i, upNumber);
				upNumber = 0;
			}
		}
		
		if(upNumber > 0) sumArr.add(upNumber);
		
		return sumArr;
	}

	public static void main(String[] args) {
		try {
			
			//파일 Loading
			Path filePath = Paths.get("number1.txt");
			byte[] bytes1 = Files.readAllBytes(filePath);
			String number1 = new String(bytes1);
			
			filePath = Paths.get("number2.txt");
			byte[] bytes2 = Files.readAllBytes(filePath);
			String number2 = new String(bytes2);
	
			//String number1 = "654684645289347678995689237455132158";
			//String number2 = "654684742380958092347809576513218";
			String numberArr1[]	= number1.split("");
			String numberArr2[]	= number2.split("");
						
			// 결과 ArrayList
			ArrayList<Integer> summary = new ArrayList<Integer>();
			
			// 덧셈을 위해 두 수의 배열을 뒤집음.
			reverse(numberArr1);
			reverse(numberArr2);
			
			// 계산 함수
			summary = sumArray(numberArr1, numberArr2);
			
			Collections.reverse(summary);
			
			// Console 출력부
			System.out.println(number1);
			System.out.println(number2);
			Iterator iter = summary.iterator();
			while(iter.hasNext())
				System.out.print(iter.next());
			
			ArrayList<String> summaryString = new ArrayList<String>();
			
			for(int i = 0; i < summary.size(); i++)
				summaryString.add(summary.get(i).toString());
			
			
			// throw GC
			summary = null;
			iter = null;
			
			
			// 파일로 Output
			int bufferSize = 10240;
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			for (String sx : summaryString) {
				buffer.put(sx.getBytes());
			}
			buffer.flip();
			FileOutputStream file = new FileOutputStream("result.txt");
			FileChannel channel = file.getChannel();
			channel.write(buffer);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main()
} // class
