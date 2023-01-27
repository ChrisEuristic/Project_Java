package edu.mission;

import java.util.Scanner;

class Boss {
	private int hp = 1000;
	private int power = 10;
	
	public int getHP() {
		return this.hp;
	}
	
	public void setHP(int damage) {
		if(this.hp < damage)
			this.hp = 0;
		else
			this.hp -= damage;
	}
	
	public int getPower() {
		return (int)(this.power * (1 + Math.random()));
	}
}

class Player {
	public String name;
	private int hp = 100;
	private int mp = 100;
	private int power = 10;
	
	public Player() {
		this.name = "당신";
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public void setHP(int damage) {
		if(this.hp < damage)
			this.hp = 0;
		else
			this.hp -= damage;
	}
	
	public int getPower(int skill) {
		switch(skill){
		case 2:
			return (int)(this.power * (1 + (Math.random()*10)));
		case 3: 
			return (int)(this.power * (Math.random()*20));
		default:
			return (int)(this.power * (1 + (Math.random()/2)));
		}		
	}
}

public class Game {

	public static void main(String[] args) {
 
		Player player = new Player();
		Boss boss = new Boss();
		Scanner sc = new Scanner(System.in);
		
		int playerSkill;
		int playerDamage, bossDamage;
		
		System.out.println("보스를 만났습니다. 보스의 HP는 " + boss.getHP() + "입니다.");
		System.out.println();
		
		while(true) {
			System.out.println("공격을 선택하십시오.");
			System.out.println("1 : 일반 공격");
			System.out.println("2 : 스매시");
			System.out.println("3 : 번개 공격");
			playerSkill = sc.nextInt();
			switch(playerSkill){
			case 2:
				System.out.print("스매시로 보스를 공격합니다. ");
				break;
			case 3: 
				System.out.print("번개로 보스를 공격합니다. ");
				break;
			default:
				System.out.print("보스를 공격합니다. ");
				break;
			}
			playerDamage = player.getPower(playerSkill);
			System.out.println(playerDamage + "의 대미지를 입혔습니다.");
			boss.setHP(playerDamage);
			System.out.println("보스의 남은 HP는 " + boss.getHP() + "입니다.");
			System.out.println();
			
			if(boss.getHP() <= 0) {
				System.out.println("보스가 사망하였습니다. 승리를 축하합니다.");
				break;
			}
			
			System.out.println("보스가 공격합니다.");
			bossDamage = boss.getPower();
			System.out.println(bossDamage + "의 대미지를 입었습니다.");
			player.setHP(bossDamage);
			System.out.println(player.name + "의 남은 HP는 " + player.getHP() + "입니다.");
			System.out.println();
			
			
			if(player.getHP() <= 0) {
				System.out.println(player.name + "이 사망하여 게임을 종료합니다.");
				break;
			}
		}

	}

}
