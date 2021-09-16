package org.code;

public class WordSearch {

	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] board = { { 'A', 'B', 'C', 'E' }, 
						   { 'S', 'F', 'C', 'S' }, 
				           { 'A', 'D', 'E', 'E' } };
		System.out.println(ws.exist(board, "ABCCED"));
	}

	public boolean exist(char[][] board, String word) {
		int rows = board.length;
		int cols = board[0].length;
		int index = 0;
		for (int i = 0; i < rows; i++) {
			boolean[][] visited = new boolean[rows][cols];
			for (int j = 0; j < cols; j++) {
				if(board[i][j]  == word.charAt(0)) {
					if (existHelper(board, word, "", rows, cols, i, j, visited, index)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean existHelper(char[][]board, String word, 
			String current, int maxRows, int maxCols, int row, int col, boolean[][] visited, int index) {
		if(row >= maxRows || col >= maxCols || row < 0 || col < 0) {
			return false;
		}
		else if(current.equals(word)) {
			return true;
		}
		
		else if(current.length() > word.length()) {
			return false;
		}
		
		else if(visited[row][col] == true) {
			return false;
		}
		else if(word.charAt(index) != board[row][col]) {
			return false;
		}
		else {
			visited [row][col] = true;
			boolean exist = (existHelper (board, word, current + board[row][col], maxRows, maxCols, row + 1, col, visited, index + 1) || 
					existHelper(board, word, current + board[row][col], maxRows, maxCols, row, col + 1, visited, index + 1) ||
					existHelper(board, word, current + board[row][col], maxRows, maxCols, row - 1, col, visited, index + 1) ||
					existHelper(board, word, current + board[row][col], maxRows, maxCols, row, col - 1, visited, index + 1));
			
			visited[row][col] = false;
			
			return exist;
		}
	}

}
