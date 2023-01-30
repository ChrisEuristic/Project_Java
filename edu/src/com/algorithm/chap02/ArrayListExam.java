package com.algorithm.chap02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

//10장 Collection, Test01, Test02를 사용

//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\
//file1: 서울,북경,상해,서울,도쿄, 뉴욕,부산
//file2: 런던, 로마,방콕, 도쿄,서울,부산
//file > string split() > 배열 > ArrayList > sort > iterator 사용하여 merge > 중복 제거 > string 배열 > file에 저장

public class ArrayListExam {
	/*
	static int binSearch(String[] s, int n, String key) {
		//자료구조 책 페이지 115 코드 사용한다.
	}
	*/
	public static void main(String[] args) {
		try {
				Path filePath = Paths.get("file1.txt");
				byte[] bytes1 = Files.readAllBytes(filePath);
				String fileToString1 = new String(bytes1);
				String[] fileToStringArr1 = fileToString1.split(",");
				
				filePath = Paths.get("file2.txt");
				byte[] bytes2 = Files.readAllBytes(filePath);
				String fileToString2 = new String(bytes2);
				String[] fileToStringArr2 = fileToString2.split(",|\r\n");
								
				for(int i=0; i<fileToStringArr1.length; i++) {
					fileToStringArr1[i] = fileToStringArr1[i].trim();
				}
				
				for(int i=0; i<fileToStringArr2.length; i++) {
					fileToStringArr2[i] = fileToStringArr2[i].trim();
				}
				
							
				
				String[] sarray = new String[20];
				// file1에서 read하여 list1.add()한다.
				// 배열을 list로 만드는 방법
				// 방법1:
				
				ArrayList<String> arrayList = new ArrayList<>();
				for (String temp : sarray) {
					arrayList.add(temp);
				}
				// 방법2
				ArrayList<String> list1 = new ArrayList<>();
				ArrayList<String> list2 = new ArrayList<String>();
				ArrayList<String> mergeList = new ArrayList<String>();

				int index = 0;
				
				for(int i = 0; i < fileToStringArr1.length; i++) {
					if(list1.size() == 0) {
						list1.add(fileToStringArr1[i]);
					}
					else {
						if (!fileToStringArr1[i].equals(list1.get(index))) {
							list1.add(fileToStringArr1[i]);
							index++;
						}
					}
				}
					
				index = 0;
				
				for(int i = 0; i < fileToStringArr2.length; i++) {
					if(list2.size() == 0) {
						list2.add(fileToStringArr2[i]);
					}
					else {
						if (!fileToStringArr2[i].equals(list2.get(index))) {
							list2.add(fileToStringArr2[i]);
							index++;
						}
					}
				}
				

				System.out.println(list1);
				System.out.println(list2);
				
				// file2에서 read하여 list1.add()한다.
	
				//
				System.out.println("Collections.sort -> ");
				Collections.sort(list1);
				Collections.sort(list2);
				

				System.out.println(list1);
				System.out.println(list2);


				ArrayList<String> list3 = new ArrayList<String>();
	
				
				// iterator를 사용하여 merge한다
				// ArrayList를 merge하는 코드 구현 list3 = list1 + list2(merge)
				
				Iterator<String> iter1 = list1.iterator();
				Iterator<String> iter2 = list2.iterator();
				String data1 = iter1.next();
				String data2 = iter2.next();
				
				while(true) {
					if(!(iter1.hasNext() || iter2.hasNext()))
						break;
					if(data1.equals(data2)) {
						list3.add(data1);
						if(iter1.hasNext())
							data1 = iter1.next();
						if(iter2.hasNext())
							data2 = iter2.next();
					}
					else {
						if(data1.compareTo(data2) < 0) {
							list3.add(data1);
							data1 = iter1.next();
						}
						else {
							list3.add(data2);
							data2 = iter2.next();
						}
					}
				}
				
				System.out.println(list3);
				
				
				/*	
				// binary search 구현
				// 방법1:
				//Arrays.binarySearch(null, null, null);// ArrayList에는 binarySearch()가 없다.
				// 방법2:
				// int result = Collections.binarySearch(list3, newFruit, cc);
	
				// 방법3:
	
				System.out.println();
				System.out.println("merge:: ");
				for (String city : list3)
					System.out.print(city + " ");
				// ArrayList를 배열로 전환
				String[] st = list3.toArray(new String[list3.size()]);
				// binary search 구현
				// binSearch(st, st.length, "key");
				
				
				*/
				
				// 정렬된 list3을 file에 출력하는 코드 완성
				int bufferSize = 10240;
				String b = " ";
				ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
				for (String sx : list3) {
					System.out.println(" " + sx);
					buffer.put(sx.getBytes());
					buffer.put(b.getBytes());
				}
				buffer.flip();
				FileOutputStream file = new FileOutputStream("c.txt");
				FileChannel channel = file.getChannel();
				channel.write(buffer);
				file.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
