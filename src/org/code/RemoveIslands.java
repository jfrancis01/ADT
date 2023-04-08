package org.code;

public class RemoveIslands {

	public static void main(String[] args) {
		int matrix[][] = { { 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1 }, { 0, 0, 0, 0, 1, 0 }, { 1, 1, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 1 } };

		RemoveIslands ri = new RemoveIslands();
		int[][] ans = ri.removeIslands(matrix);
		ri.print(ans);

	}

	private void print(int ans[][]) {
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] removeIslands(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ((i == m - 1 || j == n - 1 || i == 0 || j == 0) && matrix[i][j] == 1) {
					helper(matrix, m, n, i, j);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = 1;
				} else {
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}

	private void helper(int[][] matrix, int m, int n, int i, int j) {
		if (i >= m || j >= n || i < 0 || j < 0 || matrix[i][j] == 0 || matrix[i][j] == -1) {
			return;
		}
		matrix[i][j] = -1;
		helper(matrix, m, n, i + 1, j);
		helper(matrix, m, n, i - 1, j);
		helper(matrix, m, n, i, j + 1);
		helper(matrix, m, n, i, j - 1);
	}

}
