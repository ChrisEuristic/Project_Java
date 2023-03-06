package com.algorithm.chap10;


//체인법에 의한 해시

public class ChainHash<V> {

	 //--- 해시를 구성하는 노드 ---//
	 class Node<V> {
	     private V data;                // 데이터
	     private Node<V> next;        // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)
	
	     //--- 생성자(constructor) ---//
	     Node(V data, Node<V> next) {
	         this.data = data;
	         this.next = next;
	     }
	
	     //--- 데이터를 반환 ---//
	     V getValue() {
	         return data;
	     }
	
	     //--- 키의 해시값을 반환 ---//
	     public int hashCode() {
	         return Integer.parseInt(data.toString());
	     }
	     
	     public String toString() {
	    	 return ("(" + data.toString() + ") ");
	     }
	 }
	
	 private int    size;              // 해시 테이블의 크기
	 private Node<V>[] table;        // 해시 테이블
	
	 //--- 생성자(constructor) ---//
	 public ChainHash(int capacity) {
	     try {
	         table = new Node[capacity];
	         this.size = capacity;
	     } catch (OutOfMemoryError e) {        // 테이블을 생성할 수 없음
	         this.size = 0;
	     }
	 }
	
	 //--- 해시값을 구함 ---//
	 public int hashValue(Object key) {
	     return key.hashCode() % size;
	 }
	
	 //--- 키값이 key인 요소를 검색(데이터를 반환) ---//
	 public V search(V key) {
	     int hash = hashValue(key);            // 검색할 데이터의 해시값
	     Node<V> p = table[hash];            // 선택 노드
	
	     while (p != null) {
	         if (p.getValue().equals(key))
	             return p.getValue();                // 검색 성공
	         p = p.next;                             // 다음 노드를 선택
	     }
	     return null;                                // 검색 실패
	 }
	
	 //--- 키값이 key인 데이터를 data의 요소로 추가 ---//
	 public void add(V data) {
		 int key = Integer.parseInt(data.toString());
		 
		 if(table[key % this.size] == null) {
			 table[key % this.size] = new Node(data, null);
		 } else {
			 Node temp = toNext(table[key % this.size]);
			 temp.next = new Node(data, null);
		 }
	     return;
	 }
	 
	 private Node toNext(Node temp) {
		 if(temp.next == null)
			 return temp;
		 else {
			 return toNext(temp.next);
		 }
	 }
	
	 //--- 키값이 key인 요소를 삭제 ---//
	 public void remove(V data) {
		 int key = Integer.parseInt(data.toString());
		 Node temp = table[key % this.size];
		 
		 while(temp != null) {
			 if(temp.data.toString().equals(data.toString())) { // 정확하게 찾았으면
	    		 System.out.println(data.toString() + " 데이터를 삭제합니다.");
				 if(temp.next != null) {
	    			 table[key % this.size] = temp.next;
	    			 return;
	    		 }
	    		 else {
	    			 table[key % this.size] = null;
	    			 return;
	    		 }
	    	 } else {					   // 안맞으면
	    		 if(temp.next != null) {
	    			 temp = temp.next;
	    			 continue;
	    		 }
	    		 else {
	    			 break;
	    		 }
	    	 }
		 }
		 
		 System.out.println("해당 데이터가 없습니다.");
	     return;
	 }
	
	 //--- 해시 테이블을 덤프(dump) ---//
	 public void dump() {
	     for(int i = 0; i < this.size; i++) {
	    	 System.out.print("Table" + i + " : ");
	    	 if(table[i] == null) {
	    		 System.out.println("Null");
	    		 continue;
	    	 }
	    	 System.out.print(table[i].toString());
	    	 Node temp = null;
	    	 
	    	 if(table[i].next != null)
	    		 temp = table[i].next;
	    	 
	    	 while(temp != null) {
	    		 System.out.print(temp.toString());
	    		 temp = temp.next;
	    	 }
	    	 System.out.println();
	     }
	 }
}