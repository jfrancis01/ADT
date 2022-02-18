package org.code;

public class MaximalSquare {
	
	int ans = 0;

	public static void main(String[] args) {
		MaximalSquare ms = new MaximalSquare();
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},
				{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(ms.maximalSquare(matrix));
	}

	public int maximalSquare2(char[][] matrix) {
		//for each square, we check squares of different length
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				for(int sidelength = 1; sidelength <= Math.min(matrix.length, matrix[0].length); sidelength++) {
					if(i + sidelength > matrix.length || j + sidelength > matrix[0].length) {
						continue;
					}
					else {
						if(isValid(matrix, i, j, i + sidelength, j + sidelength)) {
							ans = Math.max(ans, sidelength * sidelength);
						}
					}
				}
			}
		}
		return ans;
	}
	
	public boolean isValid(char[][] matrix, int si, int sj, int ei, int ej) {
		for(int i = si; i < ei; i++) {
			for(int j = sj; j < ej; j++) {
				if(matrix[i][j] == '0') {
					return false;
				}
			}
		}
		return true;
	}
	
	public int maximalSquare(char[][] matrix) {
		int rows  = matrix.length;
		int cols = matrix[0].length;
		int[][] cache = new int[rows][cols];
		for(int i  = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				cache[i][j] = -1;
			}
		}
		helper(0, 0, rows, cols,cache, matrix);
		int max =  Integer.MIN_VALUE;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				max = Math.max(max, cache[i][j]);
			}
		}
		return max * max;
	}
	
	public int helper(int i, int j, int rows, int cols, int[][]cache, char[][] matrix) {
		if(i >= rows || j >=cols) {
			return 0;
		}
		if(cache[i][j] != -1) {
			return cache[i][j];
		}
		
		int down = helper(i +1, j, rows, cols, cache, matrix);
		int right = helper(i , j + 1,  rows, cols, cache, matrix);
		int diag = helper(i +1, j + 1,  rows, cols, cache, matrix);
		
		cache[i][j] = 0;
		if(matrix[i][j] == '1') {
			cache[i][j] = 1 + Math.min(down, Math.min(right, diag));
		}
		
		return cache[i][j];
	}
}
