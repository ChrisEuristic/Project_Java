package com.ruby.java.ch12;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileInputStreamTest {

	private static boolean bPrint = false;
	
	public static long test01() {
		
		long start = System.currentTimeMillis();
		try (InputStream is = new FileInputStream("test.dat");) {	// 1바이트씩 읽는 파일오픈 객체 생성
			int ch;
			while(0 <= (ch = is.read())) {							// 값이 존재하는 한 루프. ch에 읽은 1Byte 데이터 대입
				if (bPrint)											// 화면에 출력할지 말지?
					System.out.println(ch);
			}		
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}

	public static long test02() {
	
		byte[] buffer = new byte[1024];								// 버퍼 크기를 지정하기 위한 Byte Arr 정의

		long start = System.currentTimeMillis();
		try (InputStream is = new FileInputStream("test.dat");) {	// test.dat 파일을 오픈하여 상위클래스 타입의 참조변수에 할당.
			while(0 <= is.read(buffer)) {							// read() 함수에 파라미터로 buffer arr 대입하여 버퍼 크기 지정. read()로 읽어지는 데이터가 있는 한 루프.
				if (bPrint)
					System.out.println(new String(buffer));			// buffer에 담겨나오는 데이터를 String 객체로 만들어서 출력.
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}

	public static long test03() {
		
		byte[] buffer = new byte[1024];

		long start = System.currentTimeMillis();
		try (InputStream bis = new BufferedInputStream(new FileInputStream("test.dat"));) {
			// 버퍼를 지정하여 작업하는 것은 test02와 동일하나 BufferedInputStream 클래스를 사용한다는 점이 다름.
			while(0 <= bis.read(buffer)) {
				if (bPrint)
					System.out.println(new String(buffer));
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}

	public static long test04() {
		
		long start = System.currentTimeMillis();
		try (Reader fr = new FileReader("test.dat");) {
			int ch;
			while(0 <= (ch = fr.read())) {
				if (bPrint)
					System.out.println(ch);
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return -1L;
	}
	
	public static long test05() {
		
		char[] buffer = new char[1024];

		long start = System.currentTimeMillis();
		try (Reader fr = new FileReader("test.dat");) {
			while(0 <= fr.read(buffer)) {
				if (bPrint)
					System.out.println(buffer.toString());
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}	
	
	public static long test06() {
		
		char[] buffer = new char[1024];

		long start = System.currentTimeMillis();
		try (Reader br = new BufferedReader(new FileReader("test.dat"));) {
			while(0 <= br.read(buffer)) {
				if (bPrint)
					System.out.println(buffer.toString());
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}		
	
	public static long test07() {

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		long start = System.currentTimeMillis();
		try (RandomAccessFile raf = new RandomAccessFile("test.dat", "r");
				FileChannel channel = raf.getChannel();) {
			int len;
			while((len = channel.read(buffer)) > 0) {
				if (bPrint)
					System.out.println("-->" + len + ":" + new String(buffer.array(), 0, len, "UTF-8"));
				buffer.clear();
			}
			return System.currentTimeMillis() - start;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1L;
	}
	
	public static void main(String[] args) {

		System.out.println("-->test01");
		long t1 = test01();	// 1byte씩 읽어서 출력
		System.out.println("-->test02");
		long t2 = test02();	// 1024byte 버퍼를 생성해서 출력
		System.out.println("-->test03");
		long t3 = test03();
		System.out.println("-->test04");
		long t4 = test04();
		System.out.println("-->test05");
		long t5 = test05();
		System.out.println("-->test06");
		long t6 = test06();
		System.out.println("-->test07");
		long t7 = test07();

		System.out.printf("test01():FileInputStream:1byte :%dms\n", t1);
		System.out.printf("test02():FileInputStream:buffer:%dms\n", t2);
		System.out.printf("test03():BufferedInputStream   :%dms\n", t3);
		System.out.printf("test04():FileReader:1byte      :%dms\n", t4);
		System.out.printf("test05():FileReader:buffer     :%dms\n", t5);
		System.out.printf("test06():BuffredReader         :%dms\n", t6);
		System.out.printf("test07():FileChannel           :%dms\n", t7);

		System.out.println("Done");
	}
}
