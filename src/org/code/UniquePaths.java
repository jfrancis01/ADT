package org.code;

public class UniquePaths {
	//This is a test
	public int count = 0;

	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.print("Ways: " + up.uniquePaths(3, 7));
	}

	public int uniquePaths(int m, int n) {
		//initialize the board
		int[][]board = new int[m + 1][n + 1]; // initalize the board
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = -1;
			}
		}
		int si = 0, sj = 0;// initialize start oordinates
		return move(board, si, sj, m - 1, n -1);
	}
	
	public int move(int[][] board, int row, int col, int maxRow, int maxCol) {
		
		if(row > maxRow || col> maxCol) {
			return 0;
		}
		if(row == maxRow && col == maxCol) {
			return 1;
		}
		if(board[row][col] != -1) {
			return board[row][col];
		}
		board[row][col] = move(board, row + 1, col, maxRow, maxCol) + move(board, row, col + 1, maxRow, maxCol);
		return board[row][col];
	}

}
