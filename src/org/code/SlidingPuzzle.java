package org.code;

import java.util.HashMap;
import java.util.HashSet;

public class SlidingPuzzle {
	int moves = Integer.MAX_VALUE;
	HashMap<String, Integer> visited = new HashMap<String, Integer>();
	public int slidingPuzzle(int[][] board) {
		int move  = 0;
		for(int i  = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j]== 0) {
					slidingPuzzleHelper(board, move, i, j);
					break;
				}
			}
		}
		return moves;
	}
	
	private void slidingPuzzleHelper(int[][]board, int move, int i, int j) {
		if(isValid(board)) {
			moves = Math.min(moves, move);
			return;
		}
		String hash = hash(board);
		//if(isVisited(hash)) {
		//	return;
		//}
		if(visited.getOrDefault(hash, Integer.MAX_VALUE) < move) return;
		visited.put(hash, move);
		int temp = -1;
		
		if( i + 1 < board.length && i + 1 >= 0 && j>=0 && j < board[0].length) {
			temp = board[i + 1][j];
			board[i][j] = temp;
			board[i + 1][j] = 0;
			slidingPuzzleHelper(board, move + 1, i + 1, j);
			board[i][j] = 0;
			board[i + 1][j] = temp;
		}
		
		if( i-1  < board.length && i -1  >= 0 &&  j>=0 && j < board[0].length ) {
			temp = board[i - 1][j];
			board[i][j] = temp;
			board[i - 1][j] = 0;
			slidingPuzzleHelper(board, move + 1, i - 1, j);
			board[i][j] = 0;
			board[i - 1][j] = temp;
		}
		
		if( j + 1  < board[0].length && j + 1  >= 0 && i>=0 && i < board.length) {
			temp = board[i][j + 1];
			board[i][j] = temp;
			board[i][j + 1] = 0;
			slidingPuzzleHelper(board, move + 1, i, j + 1);
			board[i][j] = 0;
			board[i][j + 1] = temp;
		}
		
		if( j - 1  < board[0].length && j - 1  >= 0 && i>=0 && i < board.length) {
			temp = board[i][j - 1];
			board[i][j] = temp;
			board[i][j - 1] = 0;
			slidingPuzzleHelper(board, move + 1, i, j - 1);
			board[i][j] = 0;
			board[i][j - 1] = temp;
		}
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
	
	private String hash(int[][] board) {
		StringBuilder sb = new StringBuilder("");
		for(int i  = 0; i < board.length; i++) {
			for(int j  = 0; j < board[0].length; j++) {
				sb.append(""+ board[i][j]);
			}
		}
		return sb.toString();
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
