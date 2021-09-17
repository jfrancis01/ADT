package org.code;

public class UniquePaths {
	//This is a test
	public int count = 0;

	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.print("Ways: " + up.uniquePaths(3, 3));
	}

	public int uniquePaths(int m, int n) {
		//initialize the board
		int[][]board = new int[m][n]; // initalize the board
		int si = 0, sj = 0;// initialize start oordinates
		move(board, si, sj, m - 1, n -1);
		return count;
	}
	
	public void move(int[][] board, int row, int col, int maxRow, int maxCol) {
		if(row > maxRow || col> maxCol) {
			return;
		}
		if(row == maxRow && col == maxCol) {
			count++;
		}
		move(board, row + 1, col, maxRow, maxCol);
		move(board, row, col + 1, maxRow, maxCol);
	}

}
