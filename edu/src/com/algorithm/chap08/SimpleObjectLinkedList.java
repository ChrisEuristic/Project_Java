package com.algorithm.chap08;


import java.util.Comparator;
import java.util.Scanner;

class SimpleObject {
	private String num; // 회원번호
	private String name; // 이름
	
	SimpleObject(String num, String name) {
		this.num = num;
		this.name = name;
	}

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + num + ") " + name;
	}

	public String getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NUM_ORDER = new NumOrderComparator();

	private static class NumOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return (d1.num.compareTo(d2.num) > 0) ? 1 : (d1.num.compareTo(d2.num) < 0) ? -1 : 0;
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
	
	public boolean Delete(String element, Comparator<SimpleObject> comparator) { //delete the element
		ObjectNode p = first, q = null;
		
		if(p == null)
			return false;
		
		while(p != null) {
			if(comparator == SimpleObject.NUM_ORDER) {
				if(p.data.getNum().compareTo(element) == 0) {
					if(q == null)
						first = null;
					else
						q.link = p.link;
					
					return true;
				}
			} else {
				if(p.data.getName().compareTo(element) == 0) {
					if(q == null)
						first = null;
					else
						q.link = p.link;
					
					return true;
				}
			}
			
			q = p;
			p = p.link;
		}
		
		return false;
	}
	
	public void Show() { // 전체 리스트를 순서대로 출력한다.
		ObjectNode p = first, q = null;
		
		if(p == null) {
			System.out.println("리스트가 비어있음.");
			return;
		}
		System.out.println();
		do {
			System.out.print(p.data + " ");
			
			q = p;
			p = p.link;
		} while(p != null);
		System.out.println();
		System.out.println();
	}
	
	public void Add(SimpleObject element, Comparator<SimpleObject> comparator){ //임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다 
		ObjectNode newNode = new ObjectNode(element);
		ObjectNode p = first, q = null;
		
		if(p == null) {
			first = newNode;
			return;
		}
		
		while(true) {
			if(comparator == SimpleObject.NUM_ORDER) {
				if(p.data.getNum().compareTo(element.getNum()) > 0) {
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
			} else {
				if(p.data.getName().compareTo(element.getName()) > 0) {
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
	}
	
	public boolean Search(String target, Comparator<SimpleObject> comparator) { // 회원번호로 데이터 유무를 검색한다.
		ObjectNode p = first, q = null;
		
		while(p != null) {
			if(comparator == SimpleObject.NUM_ORDER) {
				if(p.data.getNum().compareTo(target) == 0)
					return true;
			} else {
				if(p.data.getName().compareTo(target) == 0)
					return true;
			}
			
			q = p;
			p = p.link;
		}
		return false;
	}
}


public class SimpleObjectLinkedList {

	 enum Menu {
	        Add("삽입"),
	        Delete("삭제"),
	        Show("인쇄"),
	        Search("검색"),
	        Exit("종료");

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
		Comparator<SimpleObject> comparator = null;
		
		System.out.println("inserted");
	     l.Show();		
	        do {
	            switch (menu = SelectMenu()) {	             
	             case Add :                           // 머리노드 삽입
	            	 System.out.print("회원번호로 정렬하시려면 1번, 회원명으로 정렬하시려면 2번을 눌러주세요. >> ");
	            	 int addType = sc.nextInt();
	            	 switch(addType) {
	            	 case 1:	comparator = SimpleObject.NUM_ORDER;
	            	 			break;
	            	 case 2:	comparator = SimpleObject.NAME_ORDER;
	            	 			break;
	            	 default: System.out.println("잘못 입력되었습니다. 초기 화면으로 돌아갑니다."); break;
	            	 }
	            	 
	            	 System.out.print("추가할 회원번호 입력 : ");
	            	 String addNum = sc.next();
	            	 System.out.print("추가할 회원명 입력 : ");
	            	 String addName = sc.next();
	    	         l.Add(new SimpleObject(addNum, addName), comparator);
	    	         break;
	             case Delete :                          // 머리 노드 삭제
	            	 System.out.print("회원번호로 삭제하시려면 1번, 회원명으로 삭제하시려면 2번을 눌러주세요. >> ");
	            	 int delType = sc.nextInt();
	            	 String delTarget = null;
	            	 switch(delType) {
	            	 case 1:	System.out.print("삭제할 회원번호 입력 : ");
	            	 			comparator = SimpleObject.NUM_ORDER;
	            	 			delTarget = sc.next();
	            	 			break;
	            	 case 2:	System.out.print("삭제할 회원명 입력 : ");
	            	 			comparator = SimpleObject.NAME_ORDER;
	            	 			delTarget = sc.next();
	            	 			break;
	            	 default: System.out.println("잘못 입력되었습니다. 초기 화면으로 돌아갑니다."); break;
	            	 }
	            	 
	            	 if(l.Delete(delTarget, comparator))
	            		 System.out.println("삭제된 데이터 : " + delTarget);
	            	 else
	            		 System.out.println("삭제할 데이터가 없습니다.");
	            	 break;
	             case Show :                           // 꼬리 노드 삭제
	                    l.Show();
	                    break;
	             case Search :                           // 회원 번호 검색
	            	 System.out.print("회원번호로 검색하시려면 1번, 회원명으로 검색하시려면 2번을 눌러주세요. >> ");
	            	 int searchType = sc.nextInt();
	            	 String searchTarget = null;
	            	 switch(searchType) {
	            	 case 1:	System.out.print("검색할 회원번호 입력 : ");
	            	 			comparator = SimpleObject.NUM_ORDER;
	            	 			searchTarget = sc.next();
	            	 			break;
	            	 case 2:	System.out.print("검색할 회원명 입력 : ");
	            	 			comparator = SimpleObject.NAME_ORDER;
	            	 			searchTarget = sc.next();
	            	 			break;
	            	 default: System.out.println("잘못 입력되었습니다. 초기 화면으로 돌아갑니다."); break;
	            	 }
	            	 if (!l.Search(searchTarget, comparator))
	            		 System.out.println(searchTarget + " 데이터가 없습니다.");
	            	 else
	            		 System.out.println(searchTarget + " 데이터가 존재합니다.");
	            	 break;
	             case Exit :                           // 꼬리 노드 삭제
	                    break;
	            }
	        } while (menu != Menu.Exit);
	    }
}


