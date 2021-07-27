package org.code;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	/**
	 * Assumptions
	 * 
	 * 1st queen -> row 1 2nd queen -> row 2 3rd queen -> row 3 4th queen -> row 4
	 * ...... ......
	 * 
	 * 1. check row, col and diagonal to validate position and then place the queen
	 * 2. have a count to see how many queens have been placed 3. Have a one
	 * dimentional array to keep track of tehe row and column the queens have been
	 * placed 0 1 2 3 Ex:[1,2,3,4] -> Queen 1 is in row 0 col 1, Queen 2 is in row 1
	 * col 2
	 * 
	 * @param args
	 */
	private static int sols = 1;
	private static List<List<String>> finalAnswers = new ArrayList<>();

	public static void main(String[] args) {
		int N = 9;
		int[][] board = new int[N][N];
		int[] placement = new int[N];
		for (int i = 0; i < N; i++) {
			placement[i] = -1;
		}
		placeQueens(board, N, 0, placement);
	}

	public static void placeQueens(int[][] board, int N, int queen, int[] placement) {

		if (queen >= N) {
			// addSolutions(N, placement);

			System.out.println(sols + " Solution found: ");
			System.out.println();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			++sols;

			return;
		}
		for (int i = queen; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (isValid(i, j, placement)) {
					// place the queen (choose)
					placement[i] = j;
					board[i][j] = 1;
					// explore
					placeQueens(board, N, queen + 1, placement);
					// unchoose
					placement[i] = -1;
					board[i][j] = 0;
				}
			}
		}
	}

	public static boolean isValid(int i, int j, int[] placement) {
		for (int index = 0; index < placement.length; index++) {
			if (placement[index] != -1) {
				int row = index;
				int col = placement[index];
				if (i == row || j == col) {
					return false; // cant place on the same row or col
				}
				if (Math.abs(col - j) == Math.abs(row - i)) {
					return false; // can't place on the diagonal
				} else {
					continue;
				}
			}
		}
		return true;
	}

	public static void addSolutions(int N, int[] placement) {
		List<String> answers = new ArrayList<>();
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boolean queenPlaced = false;
				for (int p = 0; p < placement.length; p++) {
					int row = p;
					int col = placement[p];
					if (i == row && col == j) {
						sb.append("Q");
						queenPlaced = true;
					}
				}
				if (queenPlaced == false) {
					sb.append(".");
				}
			}
			answers.add(sb.toString());
		}
		finalAnswers.add(answers);
	}
}
