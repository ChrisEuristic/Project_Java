package com.algorithm.chap05;

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
	
	static boolean checkSlash(int board[][], int x, int y) {
		int x_ = x;
		int y_ = y;
		
		while(--x >= 0 && x < 8 && ++y >= 0 && y < 8) {
			if(board[x][y] == 1) return true;
		}
		
		while(++x_ >= 0 && x_ < 8 && --y_ >= 0 && y_ < 8) {
			if(board[x_][y_] == 1) return true;
		}
		return false;
	}
	
	static boolean checkBSlash(int board[][], int x, int y) {
		int x_ = x;
		int y_ = y;
		
		while(--x >= 0 && x < 8 && --y >= 0 && y < 8) {
			if(board[x][y] == 1) return true;
		}
		
		while(++x_ >= 0 && x_ < 8 && ++y_ >= 0 && y_ < 8) {
			if(board[x_][y_] == 1) return true;
		}
		return false;
	}
	
	/* --- 하나라도 1이면 True --- */
	static boolean checkAll(int board[][], int x, int y) {
		
		return checkRow(board, x) || checkCol(board, y) || checkSlash(board, x, y) || checkBSlash(board, x, y);
	}
	
	
	static int push(Point pointStack[], int stackSize, int x, int y) {
		pointStack[stackSize] = new Point(x, y);
		return ++stackSize;
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
		
		int board[][] = new int[8][8];
		Point pointStack[] = new Point[8];
		int stackSize = 0;
		int x = 0, y = 0;
		
		
		/* --- 초기화 --- */
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				board[i][j] = 0;
		
		while(true) {
			if(checkAll(board, x, y)) {
				if(++y == 8) {
					y = 0;
					x++;
				}
				if(x == 8) break;
				continue;
			}
			else {
				stackSize = push(pointStack, stackSize, x, y);
			}
		}
		
		/* --- 출력 --- */
		print(board);
	}

}
