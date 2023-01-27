package com.ruby.java.test1;

import com.ruby.java.test2.*;
import java.util.List;
import java.io.*;

public class Armor {
	private String name;
	private int height;
	private int weight;
	private String color;
	private boolean isFly;
	
	public void setHeight(int value) {
		height = value;
	}
	
	public void setName() {
		String value = "mark6";
		name = value;
	}
	
	public int takeOff(int value) {
		System.out.println("엔진을 시동하다");
		return value - 50;
	}
}
