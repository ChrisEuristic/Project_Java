package com.algorithm.chap10;

//체인법에 의한 해시 사용 예

import java.util.Scanner;

class ChainHashTester {
 static Scanner stdIn = new Scanner(System.in);

 static class SimpleObject {
		private String name;
		
		Integer keyCode() {
			return Integer.parseInt(name);
		}
		
		public String toString() {
			return name;
		}
		
		void scanData(String guide) {
	         System.out.println(guide + "할 데이터를 입력하세요.");

	         name = stdIn.next();	         
	     }
	}

 //--- 메뉴 열거형 ---//
 enum Menu {
     ADD(      "추가"),
     REMOVE(   "삭제"),
     SEARCH(   "검색"),
     DUMP(     "표시"),
     TERMINATE("종료");

     private final String message;            // 표시할 문자열

     static Menu MenuAt(int idx) {            // 순서가 idx번째인 열거를 반환
         for (Menu m : Menu.values())
             if (m.ordinal() == idx)
                 return m;
         return null;
     }

     Menu(String string) {                // 생성자(constructor)
         message = string;
     }

     String getMessage() {                // 표시할 문자열을 반환
         return message;
     }
 }

 //--- 메뉴 선택 ---//
 static Menu SelectMenu() {
     int key;
     do {
         for (Menu m : Menu.values())
             System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
         System.out.print(" : ");
         key = stdIn.nextInt();
     } while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

     return Menu.MenuAt(key);
 }

 public static void main(String[] args) {
     Menu menu;                                // 메뉴 
     SimpleObject data;                                // 추가용 데이터 참조
     SimpleObject temp = new SimpleObject();        // 읽어 들일 데이터

     ChainHash<SimpleObject> hash = new ChainHash<SimpleObject>(13);

     do {
         switch (menu = SelectMenu()) {
          case ADD :                               // 추가
                 data = new SimpleObject();
                 data.scanData("추가");
                  hash.add(data);
                  break;

          case REMOVE :                       // 삭제
                  temp.scanData("삭제");
                  hash.remove(temp);
                  break;

          case SEARCH :                       // 검색
                 temp.scanData("검색");
                 SimpleObject t = hash.search(temp);
                  if (t != null)
                      System.out.println("그 키를 갖는 데이터는 " + t + "입니다.");
                 else
                      System.out.println("해당 데이터가 없습니다.");
                  break;

          case DUMP :                            // 표시
                  hash.dump();
                  break;
         }
     } while (menu != Menu.TERMINATE);
 }
}
