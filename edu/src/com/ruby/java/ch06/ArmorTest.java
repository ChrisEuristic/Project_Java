package com.ruby.java.ch06;

public class ArmorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Armor suit1 = new Armor();
		Armor suit2 = new Armor();
		Armor suit3 = new Armor();

		suit1.setName("mark6");
		suit1.setHeight(180);
		
		suit2.setName("mark16");
		suit2.setHeight(190);
		
		suit3.setName("mark116");
		suit3.setHeight(200);

		System.out.println(suit1.getName() + " : " + suit1.getHeight());
		System.out.println(suit2.getName() + " : " + suit2.getHeight());
		System.out.println(suit3.getName() + " : " + suit3.getHeight());
		
		System.out.println(Armor.total);
	}

}
