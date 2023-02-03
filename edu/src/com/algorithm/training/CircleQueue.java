package com.algorithm.training;

import java.util.Scanner;

class Item {
	int data;
	
	Item(int data){
		this.data = data;
	}
	
	public String toString() {
		return " < " + this.data + " > ";
	}
}

public class CircleQueue {
	
	static final int QUEUE_SIZE = 10;
	static Item circleQueue[] = new Item[QUEUE_SIZE];
	static int front, rear;
	static boolean isEmpty = true;
	
	static void push(int data) {
		if(rear == front && !isEmpty) {
			System.out.println("원형 큐가 꽉찼습니다.");
			return;
		}
		isEmpty = false;
		circleQueue[rear] = new Item(data);
		rear++; rear %= QUEUE_SIZE;
	}
	
	static void pop() {
		if(isEmpty) {
			System.out.println("원형 큐가 비어있습니다.");
			return;
		}
		circleQueue[front] = null;
		front++; front %= QUEUE_SIZE;
		if(front == rear) {
			isEmpty = true;
			System.out.println("원형 큐가 비었습니다.");
		}
	}
	
	static void clear() {
		for(int i = 0; i < circleQueue.length; i++) {
			circleQueue[i] = null;
			front = rear = 0;
		}
		isEmpty = true;
		System.out.println("원형 큐가 비었습니다.");
	}
	
	static void print() {
		int cursor = front;
		
		if(isEmpty) {
			System.out.println("원형 큐가 비어있습니다.");
			return;
		}
		
		do {
			System.out.print(circleQueue[cursor] + " ");
			cursor++; cursor %= QUEUE_SIZE;
		} while(cursor != rear);
		System.out.println();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int pick;
		
		while(true) {
			System.out.println("1. Push   2. Pop   3. Clear   4. Print");
			System.out.print("명령을 선택해주세요. => ");
			pick = sc.nextInt();
			
			switch(pick){
			case 1: push((int)Math.round(Math.random() * 10)); break;
			case 2: pop(); break;
			case 3: clear(); break;
			case 4: print(); break;
			default: continue;
			}
		}

	}

}
