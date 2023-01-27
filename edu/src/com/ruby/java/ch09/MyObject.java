package com.ruby.java.ch09;

public class MyObject {
	
	private int num;
	
	MyObject(int i) {
		this.num = i;
	}
	
	public boolean equals(Object obj) {
		
		MyObject mobj = (MyObject) obj;
		
		if(this.num == mobj.num)
			return true;
		else
			return false;
		
	}
}
