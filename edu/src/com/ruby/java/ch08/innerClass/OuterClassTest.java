package com.ruby.java.ch08.innerClass;


public class OuterClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass outer = new OuterClass();
		OuterClass.InstanceClass inner01 = outer.new InstanceClass();
		inner01.a = 123;
		inner01.method2();
		OuterClass.StaticClass inner02 = new OuterClass.StaticClass();
		inner02.b = 456;
		inner02.method3();
		OuterClass.StaticClass.c = 789;
		OuterClass.StaticClass.method4();
		
		outer.method1();
	}

}
