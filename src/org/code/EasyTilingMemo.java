package org.code;

import java.time.Duration;
import java.time.Instant;

public class EasyTilingMemo {
	
	//How many ways can you tile a board 1 x 5 board with either 1 x1 
	// or 1 x 2 tiles.
	
	public static void main(String[] args) {
		int n = 46;
		int[][] board = new int[1][n];
		Instant start = Instant.now();
		System.out.println("The number of ways to tile a 1 x " + n + " board is: " + tile(board));
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("Time: " + timeElapsed);
	}
	
	public static long tile(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		long[][]cache = new long[m][n + 1];
		for(int i  = 0; i < cache.length; i++) {
			for(int j = 0; j < cache[0].length; j++) {
				cache[i][j] = -1L;
			}
		}
		cache[0][0] = 0;
		cache[0][1] = 1;
		cache[0][2] = 2;
		cache[0][3] = 3;
		return helper(board, 0, 0, m, n, cache);
	}
	
	public static long helper(int[][]board, int i, int j, int m, int n, long[][]cache) {
		if(i < 0 || i > m || j < 0 || j > n) return 0;
		if(cache[i][n - j] != -1L) {
			return cache[i][n -j];
		}
		if(j == n) return 1L;
		long with = 0;
		long without = 0;
		with+= helper(board, i, j + 1, m, n, cache);
		without+= helper(board, i, j + 2, m , n, cache);
		cache[i][n - j] = with + without;
		return with + without;
	}
}
