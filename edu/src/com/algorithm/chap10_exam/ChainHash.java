package com.algorithm.chap10_exam;

import java.util.Comparator;
//hash node가 student 객체일 때를 구현하는 과제
//체인법에 의한 해시
import java.util.Scanner;

class SimpleObject {

	String sno; // 회원번호
	String sname; // 이름

	public SimpleObject(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}
	
	public String getSno() {
		return this.sno;
	}

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + sno + ") " + sname;
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return (d1.sno.compareTo(d2.sno) > 0) ? 1 : ((d1.sno.compareTo(d2.sno) < 0)) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return (d1.sname.compareTo(d2.sname) > 0) ? 1 : ((d1.sname.compareTo(d2.sname) < 0)) ? -1 : 0;
		}
	}
}

class ChainHash2 {
//--- 해시를 구성하는 노드 ---//
	class Node2 {
	   private SimpleObject data;                 // 키값
	   private Node2 next;        // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)
	
	   //--- 생성자(constructor) ---//
	   public Node2(SimpleObject s) {
	       this.data  = s;
	       this.next = null;
	   }
	   Node2(SimpleObject s, Node2 p) {
	       this.data  = s;
	       this.next = p;
	
	   }
	   Node2() {
	       this.data  = null;
	       this.next = null;
	   }
	   //--- 키값을 반환 ---//
	   String getKey() {
	       return data.getSno();
	   }
	
	   //--- 키의 해시값을 반환 ---//
	   public int hashCode() {
	   	int hash = 11;
	   	hash = 31 * hash * Integer.parseInt(getKey());
	   	hash = hash * hash;
	       return hash;
	   }
	}
	
	private int    size;              // 해시 테이블의 크기
	private Node2[] table;        // 해시 테이블
	
	//--- 생성자(constructor) ---//
	public ChainHash2(int capacity) {
	   try {
	       table = new Node2[capacity];
	       this.size = capacity;
	       
	   } catch (OutOfMemoryError e) {        // 테이블을 생성할 수 없음
	       this.size = 0;
	   }
	}
	
	//--- 해시값을 구함 ---//
	public int hashValue(String key) {
		int hash = 31 * Integer.parseInt(key);
		hash = (hash * hash) % this.size;
	   return hash;
	
	
	}
	
	//--- 키값이 key인 요소를 검색(데이터를 반환) ---//
	public String search(String sno) {
	   int hash = hashValue(sno);            // 검색할 데이터의 해시값
	   Node2 p = table[hash];            // 선택 노드
	
	   while (p != null) {
	       if (p.getKey().equals(sno))
	           return p.getKey();                // 검색 성공
	       p = p.next;                             // 다음 노드를 선택
	   }
	   return null;                                // 검색 실패
	}
	
	//--- 키값이 key인 데이터를 data의 요소로 추가 ---//
	public int add(SimpleObject st) {
		if(search(st.sno) != null) {
			System.out.println("이미 있는 데이터입니다.");
			System.out.println();
			return 1; // 비정상 종료
		}
		int hash = hashValue(st.getSno());            // 추가할 데이터의 해시값
		
		if(table[hash] == null) {
			table[hash] = new Node2(st);
			return 0; // 정상 입력 완료
		}
		
		Node2 p = table[hash];            // 선택 노드
		
		while(p.next != null) {
			p = p.next;
		}
		
		p.next = new Node2(st);
		System.out.println("(" + st.sno + ") " + st.sname + "이 정상 등록되었습니다.");
		System.out.println();
		return 0; // 정상 입력 완료
	}
	
	//--- 키값이 key인 요소를 삭제 ---//
	public int remove(String sno) {
		int hash = hashValue(sno);            // 삭제할 데이터의 해시값
		Node2 p = table[hash];            // 선택 노드
		Node2 pp = null;                  // 바로 앞의 선택 노드
		//구현실습
				
		while(p != null) {
			if(p.data.sno.equals(sno)) { // 찾음. 삭제해야.
				if(pp == null) { // 전단계 노드가 없는 데이터 삭제.
					p = null;
				} else { // 전단계 노드가 있는 데이터 삭제.
					pp.next = p.next;
				}
				System.out.println(sno + " 데이터를 삭제하였습니다.");
				return 0; // 삭제 완료
			}
			pp = p;
			p = p.next;
		}
		System.out.println("삭제하려는 데이터를 찾을 수 없습니다.");
		return 1;                             // 찾는 키값이 없음
	}
	
	//--- 해시 테이블을 덤프(dump) ---//
	public void dump() {
	   for (int i = 0; i < size; i++) {
	       Node2 p = table[i];
	       System.out.printf("%02d  ", i);
	       while (p != null) {
	           System.out.printf("→ %s ", p.getKey());
	           p = p.next;
	       }
	       System.out.println();
	   }
	}
}


public class ChainHash {
	static Scanner stdIn = new Scanner(System.in);

	public static void main(String[] args) {
		ChainHash2 hash = new ChainHash2(10);
		SimpleObject data;
		int select = 0;
		//final int count = 3;
		while (select != 6) {
			System.out.println(
					"SimpleChainHash. Select 1:Add, 2. Delete, 3:Search, 4. PrintDump, 5. Quit =>");

			select = stdIn.nextInt();
			switch (select) {
			case 1:
				//SimpleObject[] input = new SimpleObject[count];
				String sno = null;
				String sname = null;

	            System.out.println("입력 데이터(sno, sname):: ");
	
	            System.out.print("번호: ");
	            sno = stdIn.next();
	
	            System.out.print("이름: ");
	            sname = stdIn.next();
	            hash.add(new SimpleObject(sno, sname));
				break;
			case 2:
				System.out.println("Delete Value:: ");
				String removeSNO = stdIn.next();
				hash.remove(removeSNO);
				break;
			case 3:
				System.out.println("Search Value:: ");
				String val = stdIn.next();
				val = hash.search(val);
				if(val == null)
					System.out.println("없는 번호입니다.");
				else
					System.out.println(val + "번 데이터 있습니다.");
				System.out.println();
				break;
			case 4:
				hash.dump();
				break;
			case 5:
				System.out.println("Quit");
				return;

			default:
				System.out.println("WRONG INPUT  ");
				System.out.println("Re-Enter");
				break;
			}
		}
	}
}
