package org.code;

import java.util.HashMap;

public class SlidingPuzzle {
	int moves = Integer.MAX_VALUE;
	public int slidingPuzzle(int[][] board) {
		int move  = 0;
		boolean visited[][] = new boolean[board.length][board[0].length];
		for(int i  = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j]== 0) {
					slidingPuzzleHelper(board, move, i, j, visited);
				}
			}
		}
		return moves;
	}
	
	private void slidingPuzzleHelper(int[][]board, int move, int i, int j, boolean visited[][]) {
		printState(board);
		if(isValid(board)) {
			moves = Math.min(moves, move);
			return;
		}
		int temp = -1;
		visited [i][j] = true;
		//up
		if( i + 1 < board.length && i + 1 >= 0 && !visited[i + 1][j]) {
			temp = board[i + 1][j];
			board[i][j] = temp;
			board[i + 1][j] = 0;
			slidingPuzzleHelper(board, move + 1, i + 1, j, visited);
			board[i][j] = 0;
			board[i + 1][j] = temp;
			printState(board);
		}
		
		if( i-1  < board.length && i -1  >= 0 && !visited[i-1][j]) {
			temp = board[i - 1][j];
			board[i][j] = temp;
			board[i - 1][j] = 0;
			slidingPuzzleHelper(board, move + 1, i - 1, j, visited);
			board[i][j] = 0;
			board[i - 1][j] = temp;
			printState(board);
		}
		
		if( j + 1  < board[0].length && j + 1  >= 0 && !visited[i][j + 1]) {
			temp = board[i][j + 1];
			board[i][j] = temp;
			board[i][j + 1] = 0;
			slidingPuzzleHelper(board, move + 1, i, j + 1, visited);
			board[i][j] = 0;
			board[i][j + 1] = temp;
			printState(board);
		}
		
		if( j - 1  < board[0].length && j - 1  >= 0 && !visited[i][j- 1]) {
			temp = board[i][j - 1];
			board[i][j] = temp;
			board[i][j - 1] = 0;
			slidingPuzzleHelper(board, move + 1, i, j - 1, visited);
			board[i][j] = 0;
			board[i][j - 1] = temp;
			printState(board);
		}
		
		visited [i][j] = false;
	}
	
	private boolean isValid(int[][] board) {
		int[][] ans = {{1,2,3},{4,5,0}};
		for(int i  = 0; i < board.length; i++) {
			for(int j  = 0; j < board[0].length; j++) {
				if(ans[i][j] != board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private void printState(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("************");
	}

	public static void main(String[] args) {
		int[][] board = {{4,1,3}, {2,0,5}};
		SlidingPuzzle sp = new SlidingPuzzle();
		System.out.println(sp.slidingPuzzle(board));
	}

}
