package org.code;

public class CountMatricesOnes {

	public static void main(String[] args) {
		CountMatricesOnes cmo = new CountMatricesOnes();
		System.out.println(cmo.countSquares(null));
	}

	public int countSquares(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int i, j;
		int[][] cache = new int[m][n];
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				cache[i][j] = -1;
			}
		}
		helper(0, 0, m, n, matrix, cache);
		int total = 0;
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				total += cache[i][j];
			}
		}
		return total;
	}

	public int helper(int i, int j, int m, int n, int[][] matrix, int[][] cache) {
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return 0;
		}
		if (cache[i][j] != -1) {
			return cache[i][j];
		}

		int down = helper(i + 1, j, m, n, matrix, cache);
		int right = helper(i, j + 1, m, n, matrix, cache);
		int diag = helper(i + 1, j + 1, m, n, matrix, cache);

		if (matrix[i][j] == 1) {
			cache[i][j] = 1 + Math.min(down, Math.min(right, diag));
		} else {
			cache[i][j] = 0;
		}
		return cache[i][j];
	}

}
