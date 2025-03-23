package org.code;

import java.time.Duration;
import java.time.Instant;

public class EasyTiling {
	
	//How many ways can you tile a board 1 x 5 board with either 1 x1 
	// or 1 x 2 tiles.
	
	static long ways = 0L;
	public static void main(String[] args) {
		int n = 46;
		int[][] board = new int[1][n];
		Instant start = Instant.now();
		tile(board);
		System.out.println("The number of ways to tile a 1 x " + n + " board is: " + ways);
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toSeconds();
		System.out.println("Time: " + timeElapsed);
	}
	
	public static void tile(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		helper(board, 0, 0, m, n);
	}
	
	public static void helper(int[][]board, int i, int j, int m, int n) {
		if(i < 0 || i > m || j < 0 || j > n) return;
		if(j == n) ways++;
		helper(board, i, j + 1, m, n);
		helper(board, i, j + 2, m , n);
	}
}
