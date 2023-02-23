package com.algorithm.chap05;

import java.io.*;
import java.util.*;

enum directions {
	N, NE, E, SE, S, SW, W, NW;
}

class Items {
    int x, y, dir;
}

class Offsets {
	public int a, b;
}

public class Maze {
	
	static int stackCount;
	
	static int maze[][] = new int[100][100];
	static int mark[][] = new int[100][100];
	
	static Offsets moves[] = new Offsets[8];
	
	static void path(int m, int p) {
		mark[1][1] = 1;
		Stack<Items> stack = new Stack();
		Items temp = new Items();
		temp.x = 1; temp.y = 1; temp.dir = 2; //directions.E;
		stack.push(temp);
		
		while(!stack.isEmpty()) {
			temp = stack.pop();
			int i = temp.x; int j = temp.y; int d = temp.dir;
			
			while(d < 8) {
				int g = i + moves[d].a;
				int h = j + moves[d].b;
				
				if ((g == m) && (h == p)) {
					System.out.println(stack);
					System.out.println("the term near the exit: " + i + " " + j);
					System.out.println("exit: " + m + " " + p);
					return;
				}
				if(((maze[g][h]) == 0) && ((mark[g][h]) == 0)) {
					mark[g][h] = 1;
					temp.x = i; temp.y = j; temp.dir = d + 1;
					stack.push(temp);
					i = g; j = h; d = 0; // 0 == N
				}
				else d++;
			}
		}
		System.out.println("no path in maze ");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int input[][] = new int[][] {
			{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
			{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
			{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
			{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
			{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
			{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }
		};
		
		for(int i = 0; i < 8; i++)
			moves[i] = new Offsets();
		
		moves[0].a = -1; moves[0].b = 0;
		moves[1].a = -1; moves[1].b = 1;
		moves[2].a = 0; moves[2].b = 1;
		moves[3].a = 1; moves[3].b = 1;
		moves[4].a = 1; moves[4].b = 0;
		moves[5].a = 1; moves[5].b = -1;
		moves[6].a = 0; moves[6].b = -1;
		moves[7].a = -1; moves[7].b = -1;
		
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++)
			{
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				};
				mark[i][j] = 0;

			}
		}
		for (int i = 0; i <= 13; i++)
		{
			for (int j = 0; j <= 16; j++)
				System.out.print(maze[i][j] + " ");
			System.out.println();
		}
		path(12, 15);

	}

}
