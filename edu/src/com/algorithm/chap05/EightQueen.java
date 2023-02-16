package com.algorithm.chap05;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Point {
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class EightQueen {
	
	static boolean checkRow(int board[][], int x) {
		for(int i = 0; i < board[x].length; i++)
			if(board[x][i] == 1)
				return true;
		return false;
	}
	
	static boolean checkCol(int board[][], int y) {
		for(int i = 0; i < board.length; i++)
			if(board[i][y] == 1)
				return true;
		return false;
	}
	
	static boolean checkSlash(int board[][], int x, int y, int width, int height) {
		int x_ = x;
		int y_ = y;
		
		while(--x >= 0 && x < height && ++y >= 0 && y < width) {
			if(board[x][y] == 1) return true;
		}
		
		while(++x_ >= 0 && x_ < height && --y_ >= 0 && y_ < width) {
			if(board[x_][y_] == 1) return true;
		}
		return false;
	}
	
	static boolean checkBSlash(int board[][], int x, int y, int width, int height) {
		int x_ = x;
		int y_ = y;
		
		while(--x >= 0 && x < height && --y >= 0 && y < width) {
			if(board[x][y] == 1) return true;
		}
		
		while(++x_ >= 0 && x_ < height && ++y_ >= 0 && y_ < width) {
			if(board[x_][y_] == 1) return true;
		}
		return false;
	}
	
	/* --- 하나라도 1이면 True --- */
	static boolean checkAll(int board[][], int x, int y, int width, int height) {
		
		return checkRow(board, x) || checkCol(board, y) || checkSlash(board, x, y, width, height) || checkBSlash(board, x, y, width, height);
	}
	
	
	static int push(Point pointStack[], int stackSize, int x, int y) {
		pointStack[stackSize] = new Point(x, y);
		return ++stackSize;
	}
	
	static Point pop(Point pointStack[], int stackSize) {
		return pointStack[stackSize];
	}
	
	static void print(int board[][]) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long start, end;
		int board[][];
		Point pointStack[];
		int stackSize = 0;
		int x = 0, y = 0;
		int width, height;
		int emptyCount = 0;
		
		
		/* --- 초기화 --- */
		start = System.currentTimeMillis();
		System.out.print("가로세로 몇 칸? =>");
		width = sc.nextInt();
		height = sc.nextInt();
		board = new int[height][width]; // 체스판 크기 규정
		pointStack = new Point[height + width];
		
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++)
				board[i][j] = 0;
		
		
		while(x < height) {
			if(checkAll(board, x, y, width, height)) {
				y++; emptyCount++;
				if(emptyCount >= width) {
					Point temp = pop(pointStack, --stackSize);
					board[temp.x][temp.y] = 0;
					print(board);
					System.out.println("===============================");
					x = temp.x;
					y = temp.y + 1;
					emptyCount = y;
				}
				if(y >= width) {
					y = 0;
					x++;
				}
				if(x >= height) break;
				continue;
			}
			else {
				stackSize = push(pointStack, stackSize, x, y);
				board[x][y] = 1;
				x++;
				emptyCount = 0;
				print(board);
				System.out.println("===============================");
				y = 0;
			}
		}
		
		/* --- 출력 --- */
		//print(board);
		end = System.currentTimeMillis();
		System.out.println(((float)(end - start)) / 1000 + "초");
	}

}
