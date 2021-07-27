package org.code;

import java.util.Arrays;

public class MinPathMemo {
	
	public static void main(String argv[]) {
		
		/*
		 * int[][]grid = { {1,3,1}, {1,5,1}, {4,2,1} };
		 * 
		 */
		int[][] grid = {{1}};
		 System.out.println(minPath(grid));
	}
	
	public static int minPath(int[][] grid) {
		 int m = grid.length; //get row
		 int n = grid[0].length;//get column
		 int[][] memoTable = new int[m][n];
		 Arrays.stream(memoTable).forEach(a -> Arrays.fill(a, 0));
		 return gridPathHelper(grid, memoTable, m-1, n-1);
 
	}
	
	public static int gridPathHelper(int[][] grid, int[][] memoTable, int x, int y) {
		if(x < 0 || y < 0) return Integer.MAX_VALUE; // out of bounds
		if(x == 0 && y == 0) return grid[x][y]; //if you reach the square return the weight
		if(memoTable[x][y] != -1) return memoTable[x][y];// if values exists
		
		int ans = grid[x][y] + Math.min(gridPathHelper(grid, memoTable,x-1, y), gridPathHelper(grid, memoTable, x, y-1));
		memoTable[x][y] = ans;
		return ans;
	}
}
