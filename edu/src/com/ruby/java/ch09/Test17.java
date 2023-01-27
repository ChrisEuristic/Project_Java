package com.ruby.java.ch09;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class Timer {
	void printDate(Date d, int i) throws InterruptedException {
		for(int j = 0; j < i; j++) {
			System.out.println((d.getYear()+1900)+"년 "+(d.getMonth()+1)+"월 "+d.getDate()+"일 "+(d.getHours()-12)+"시 "+(d.getMinutes()-8)+"분 "+d.getSeconds()+"초 ");
			Thread.sleep(1000);
		}
	}
}

public class Test17 {

	public static void main(String[] args) throws InterruptedException {

		Date d = new Date();
		Timer t = new Timer();
		//System.out.println(d);
		
		/*Calendar c = Calendar.getInstance();
		
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH) + 1);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));*/
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		
		for(int j = 0; j < time; j++) {
			Calendar c = Calendar.getInstance();
			System.out.println((c.get(Calendar.YEAR))+"년 "+(c.get(Calendar.MONTH)+1)+"월 "+c.get(Calendar.DAY_OF_MONTH)+"일 "+c.get(Calendar.HOUR)+"시 "+c.get(Calendar.MINUTE)+"분 "+c.get(Calendar.SECOND)+"초 " + c.get(Calendar.MILLISECOND));
			Thread.sleep(10);
		}
		
	}

}
