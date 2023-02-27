package com.algorithm.chap08;


import java.util.Comparator;
import java.util.Scanner;

class SimpleObject {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요."+ sw);

		if ((sw & NO) == NO) { //& 는 bit 연산자임 
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}

class ObjectNode {
	SimpleObject data;
	ObjectNode link;
	public ObjectNode(SimpleObject element) {
		link = null;
		data = element;
	}
}

class ObjectLinkedList {
	ObjectNode first;
	public ObjectLinkedList() {
		first = null;
	}
	
	public boolean Delete(SimpleObject element) //delete the element
	{
		return true;
	}
	
	public void Show() { // 전체 리스트를 순서대로 출력한다.

	}
	
	public void Add(SimpleObject element){ //임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다 
		ObjectNode newNode = new ObjectNode(element);
		ObjectNode p = first, q = null;
		
		if(p == null) {
			first = newNode;
			return;
		}
		
		while(true) {
			if(p.data  element) {
				newNode.link = p;
				if(q == null)
					first = newNode;
				else
					q.link = newNode;
				break;
			} else {
				q = p;
				p = p.link;
				if(p == null) {
					q.link = newNode;
					break;
				}
			}
		}
	}
	
	public boolean Search(int number) { // 회원번호로 데이터 유무를 검색한다.
		return true;
	}
	
	public boolean Search(String data) { // 회원 이름으로 데이터 유무를 검색한다.
		return true;
	}
}


public class SimpleObjectLinkedList {

	 enum Menu {
	        Add( "삽입"),
	        Delete( "삭제"),
	        Show( "인쇄"),
	        Search( "검색"),
	        Exit( "종료");

	        private final String message;                // 표시할 문자열

	        static Menu MenuAt(int idx) {                // 순서가 idx번째인 열거를 반환
	            for (Menu m : Menu.values())
	                if (m.ordinal() == idx)
	                    return m;
	            return null;
	        }

	        Menu(String string) {                        // 생성자(constructor)
	            message = string;
	        }

	        String getMessage() {                        // 표시할 문자열을 반환
	            return message;
	        }
	    }

	    //--- 메뉴 선택 ---//
	    static Menu SelectMenu() {
			Scanner sc = new Scanner(System.in);
	        int key;
	        do {
	            for (Menu m : Menu.values()) {
	                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
	                if ((m.ordinal() % 3) == 2 &&
	                      m.ordinal() != Menu.Exit.ordinal())
	                    System.out.println();
	            }
	            System.out.print(" : ");
	            key = sc.nextInt();
	        } while (key < Menu.Add.ordinal() || 
	                                            key > Menu.Exit.ordinal());
	        return Menu.MenuAt(key);
	    }

	public static void main(String[] args) {
       Menu menu;                                // 메뉴 
		System.out.println("Linked List");
		ObjectLinkedList l = new ObjectLinkedList();
		Scanner sc = new Scanner(System.in);
		SimpleObject data = null;
		System.out.println("inserted");
	     l.Show();		
	        do {
	            switch (menu = SelectMenu()) {	             
	             case Add :                           // 머리노드 삽입

	    	         l.Add(data);
	                     break;
	             case Delete :                          // 머리 노드 삭제
	            	 System.out.print("삭제할 회원번호 입력 : ");
	            	 int num = sc.nextInt();
	            	 if(l.Delete(num))
	            		 System.out.println("삭제된 회원은 " + num);
	            	 else
	            		 System.out.println("삭제할 데이터가 없습니다.");
	            	 break;
	             case Show :                           // 꼬리 노드 삭제
	                    l.Show();
	                    break;
	             case Search :                           // 회원 번호 검색
	            	 System.out.println("회원번호와 이름 중 무엇으로 검색하시겠습니까?");
	            	 System.out.print("1. 회원번호   2. 이름 >> ");
	            	 switch(sc.nextInt()) {
	            	 case 1: l.Search(sc.nextInt()); break;
	            	 case 2: l.Search(sc.next());; break;
	            	 default: break;
	            	 }
	                boolean result = l.search(n);
	                    if (result == false)
	                        System.out.println("검색 값 = " + n + "데이터가 없습니다.");
	                    else
	                        System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
	                     break;
	             case Exit :                           // 꼬리 노드 삭제
	                    break;
	            }
	        } while (menu != Menu.Exit);
	    }
}


