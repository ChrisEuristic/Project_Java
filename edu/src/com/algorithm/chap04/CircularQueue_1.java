package com.algorithm.chap04;

import java.util.Scanner;


class Item {
	int data;
	
	public Item(int data) {
		this.data = data;
	}
	
	public String toString() {
		return " < " + this.data + " > ";
	}
}
public class CircularQueue_1 {

	static final int QUEUE_SIZE = 4;
	Item circleQueue[]; 
	int front, rear;
	static boolean isEmpty;
	
	public CircularQueue_1() {
		front = rear = -1;
		circleQueue = new Item[QUEUE_SIZE];
		isEmpty = true;
	}
	void push(int data) {
		if(rear == front && !isEmpty) {
			System.out.println("원형 큐가 꽉찼습니다.");
		}
		else {
		isEmpty = false;
		rear ++;
		rear %= QUEUE_SIZE;
		circleQueue[rear] = new Item(data);
		}
		System.out.println("push() ::: front = " + front + ", rear = " + rear);
	}
	
	Item pop() {
		System.out.println("front = " + front + ", rear = " + rear);
		if(front == rear && isEmpty) {
			System.out.println("원형 큐가 비어있습니다.");
			return null;
		}
		front++;
		front %= QUEUE_SIZE;
		Item x = circleQueue[front];
		if (front == rear) isEmpty = true;
		return x;

	}
	
	 void clear() {
		for(int i = 0; i < circleQueue.length; i++) {
			circleQueue[i] = null;
			front = rear = 0;
		}
		isEmpty = true;
		System.out.println("원형 큐가 비었습니다.");
	}
	
	 void print() {
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
		CircularQueue_1 cq = new CircularQueue_1();
		while(true) {
	
			System.out.println("1. Push   2. Pop   3. Clear   4. Print");
			System.out.print("명령을 선택해주세요. => ");
			pick = sc.nextInt();
			Item result = null;
			switch(pick){
			case 1: cq.push((int)Math.round(Math.random() * 10)); break;
			case 2: 
				result= cq.pop(); 
				System.out.println("pop: result = " + result);
				break;
			case 3: cq.clear(); break;
			case 4: cq.print(); break;
			default: continue;
			}
		}

	}
}
