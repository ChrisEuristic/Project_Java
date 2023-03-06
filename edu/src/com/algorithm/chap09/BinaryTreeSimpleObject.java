package com.algorithm.chap09;

import java.util.Scanner;

//객체 저장 이진트리 실습

class SimpleObject implements Comparable{
	private int data;
	
	SimpleObject(int data){
		this.data = data;
	}

	@Override
	public int compareTo(Object o) {
		SimpleObject temp = (SimpleObject) o;
		return this.data - temp.data;
	}
	
	public String toString() {
		return String.valueOf(this.data);
	}
}

class TreeNode2 {
	TreeNode2 LeftChild;
	SimpleObject data;
	TreeNode2 RightChild;
	public TreeNode2() {
		LeftChild = RightChild = null;
	}
	public TreeNode2(SimpleObject x) {
		LeftChild = RightChild = null;
		this.data = x; 
	}
}

class Tree2 {
	TreeNode2 root;
	
	enum Branch {
		LEFT, RIGHT, ROOT
	}
	
	
	Tree2() {
		root = null;
	}
	TreeNode2 inorderSucc(TreeNode2 current) {
		TreeNode2 temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}
	boolean isLeafNode(TreeNode2 current) {
		if (current.LeftChild == null && current.RightChild == null) return true;
		else return false;
	}
	void inorder() {
		inorder(root);
	}
	void preorder() {
		preorder(root);
	}
	void postorder() {
		postorder(root);
	}
	void inorder(TreeNode2 CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}
	void preorder(TreeNode2 CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}
	void postorder(TreeNode2 CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int n) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
							// 설계하여 구현
		TreeNode2 p = root;
		TreeNode2 q = null;
		
		SimpleObject x = new SimpleObject(n);
		
		if(p == null) {
			root = new TreeNode2(x);
			return true;
		}
		
		while(p != null) {
			if(p.data.compareTo(x) > 0) {
				if(p.LeftChild == null) {
					p.LeftChild = new TreeNode2(x);
					return true;
				}
				q = p;
				p = p.LeftChild;
			} else if(p.data.compareTo(x) < 0) {
				if(p.RightChild == null) {
					p.RightChild = new TreeNode2(x);
					return true;
				}
				q = p;
				p = p.RightChild;
			} else {
				return false;
			}
		}

		return true;
	}
	boolean delete(int n) {
		TreeNode2 p = root, q = null;
		SimpleObject x = new SimpleObject(n);
		
		Branch branchMode = Branch.ROOT;
		
		if(p == null) {
			System.out.println("삭제할 데이터가 없습니다.");
			return false;
		}
		
		while(p != null) {
			if(p.data.compareTo(x) > 0) {
				if(p.LeftChild != null) {
					q = p;
					p = p.LeftChild;
					branchMode = Branch.LEFT;
					continue;
				}
				System.out.println("삭제할 데이터가 없습니다.");
				return false;
			} else if(p.data.compareTo(x) < 0) {
				if(p.RightChild != null) {
					q = p;
					p = p.RightChild;
					branchMode = Branch.RIGHT;
					continue;
				}
				System.out.println("삭제할 데이터가 없습니다.");
				return false;
			} else { // 삭제할 대상을 찾음
				TreeNode2 temp = null;
				
				if(p.RightChild == null) {
					switch(branchMode) {
					case LEFT:
						q.LeftChild = p.LeftChild;
						return true;
					case RIGHT:
						q.RightChild = p.LeftChild; 
						return true;
					case ROOT:
						root = p.LeftChild;
						return true;
					}
				}
				switch(branchMode) {
				case LEFT:
					q.LeftChild = beChildBreadwinner(p.RightChild, p);
					return true;
				case RIGHT:
					q.RightChild = beChildBreadwinner(p.RightChild, p); 
					return true;
				case ROOT:
					temp = root;
					root = beChildBreadwinner(p.RightChild, p);
					root.LeftChild = temp.LeftChild;
					if(root == temp.RightChild) root.RightChild = null;
					else root.RightChild = temp.RightChild;	// 무한루프 부분
					return true;
				}
			}
		}
	
		return false;	
	}
	
	TreeNode2 beChildBreadwinner (TreeNode2 beChildBWTarget, TreeNode2 targetOfParent) {
		if(beChildBWTarget.LeftChild != null) {
			return beChildBreadwinner(beChildBWTarget.LeftChild, beChildBWTarget);
		} else {
			if(beChildBWTarget.RightChild != null) {
				targetOfParent.LeftChild = beChildBWTarget.RightChild;
			}
			beChildBWTarget.LeftChild = null;
			beChildBWTarget.RightChild = null;
			return beChildBWTarget;
		}
	}
	
	boolean search(int n) {
		TreeNode2 p = root, q = null;
		SimpleObject x = new SimpleObject(n);
		
		if(p == null)
			return false;
		
		
		while(p != null) {
			if(p.data.compareTo(x) > 0) {
				q = p;
				p = p.LeftChild;
			} else if(p.data.compareTo(x) < 0) {
				q = p;
				p = p.RightChild;
			} else {
				return true;
			}
		}
		
		return false;
	}
}
public class BinaryTreeSimpleObject {
	enum Menu {
	     Add(      "삽입"),
	     Delete(   "삭제"),
	     Search(   "검색"),
	     InorderPrint(    "표시"),
	     Exit("종료");
	     private final String message;        // 표시할 문자열
	     static Menu MenuAt(int idx) {        // 순서가 idx번째인 열거를 반환
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
		 Scanner stdIn = new Scanner(System.in);
	     int key;
	     do {
	         for (Menu m : Menu.values())
	             System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
	         System.out.print(" : ");
	         key = stdIn.nextInt();
	     } while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

	     return Menu.MenuAt(key);
	 }

	 public static void main(String[] args) {
		 Scanner stdIn = new Scanner(System.in);
		 Tree2 t = new Tree2();
	     Menu menu;                                // 메뉴 
	     int count = 0;
	     int num;
	     boolean result;
	     do {
	         switch (menu = SelectMenu()) {
	          case Add :              // 노드 삽입
					System.out.println("The number of items = ");

					count = stdIn.nextInt();
					int[] input = new int[10];
					for (int ix = 0; ix < count; ix++) {
						double d = Math.random();
						input[ix] = (int) (d * 30);
					}
					for (int i = 0; i < count; i++) {
						if (t.insert(input[i]) == false)
							System.out.println("Insert Duplicated data");
					}	    
	                break;

	          case Delete :           // 노드 삭제 - 어렵다: 난이도 상
	        	    System.out.println("삭제할 데이터:: ");
	        	  	num = stdIn.nextInt();
	                t.delete(num);
	                  break;

	          case Search :           // 노드 검색
	        	  	System.out.println("검색할 데이터:: ");

					num = stdIn.nextInt();
	                if (t.search(num))
	                	System.out.println("데이터 = " + num + " 존재합니다.");
	                else
	                	System.out.println("해당 데이터가 없습니다.");
	                break;

	          case InorderPrint :            // 전체 노드를 키값의 오름차순으로 표시
	                 t.inorder();
	                 System.out.println();
	                 break;
	         }
	     } while (menu != Menu.Exit);
	 }
}
