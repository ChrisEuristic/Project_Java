package com.ruby.java.ch12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static long test01() {
		
		long start = System.currentTimeMillis();						// 시스템타이머 - 시작시간 등록
		try (FileInputStream fi = new FileInputStream("text.txt");) {	// text.txt 파일을 열어서 인스턴스로 만듦. 
			int ch;														// 한글자씩 읽기 위한 변수 선언
			while(0 <= (ch = fi.read())) {								// fi.read()를 통해 1바이트씩 값을 읽어 ch에 대입. 해당 값이 0보다 크거나 같은 동안 루프.
				System.out.println(ch + ":" + (char)ch);				// 읽은 1바이트의 값을 char 캐스팅하여 출력
			}
			return System.currentTimeMillis() - start;					// 종료 시간 - 시작 시간 계산하여 시간차 return
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}
	
	public static long test02() {
		
		long start = System.currentTimeMillis();
		try (BufferedReader br = new BufferedReader(new FileReader("text.txt"));) {	// 글자 단위로 읽는 FileReader 객체로 text.txt 파일을 만듦.
			int ch;																	// 한글자씩 읽기 위한 변수 선언 - 그러나 유니코드 레벨의 데이터가 들어가면 에러가 날 것.
			while(0 <= (ch = br.read())) {											// 루프.
				System.out.println(ch + ":" + (char)ch);							// 위 메소드와 동일
			}
			return System.currentTimeMillis() - start;								// 동일
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}
	
	public static long test03() {
		
		long start = System.currentTimeMillis();
		try (BufferedReader br = new BufferedReader(new FileReader("text.txt"));) {	// 여기까진 동일
			String str;																// 읽는 단위가 String.
			while((str = br.readLine()) != null) {									// readLine()으로 읽은 문자열을 str에 할당, 해당 값이 Null이면 종료
																					// readLine의 return 타입은 String이며, 1 work 단위 구분은 '\n'으로 함.
				System.out.println(str);											// 문자열 출력.
			}		
			return System.currentTimeMillis() - start;								// 동일
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}

	public static void main(String[] args) {

		System.out.println("-->test01 : 1byte씩 읽어서 출력");
		long t1 = test01();
		
		System.out.println("-->test02 : 1글자씩 읽어서 출력");
		long t2 = test02();

		System.out.println("-->test03 : 1줄씩 읽어서 출력");
		long t3 = test03();
		
		System.out.println("=".repeat(30));
		System.out.printf("test01():FileReader:1char :%dms\n", t1);
		System.out.println("=".repeat(30));
		System.out.printf("test02():FileReader:1char :%dms\n", t2);
		System.out.println("=".repeat(30));
		System.out.printf("test03():FileReader:1line :%dms\n", t3);
		System.out.println("=".repeat(30));
		System.out.println("Done");
	}
}
