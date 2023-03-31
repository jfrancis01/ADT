package org.code;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {
	
	private static int count  = 0;

	public static void main(String[] args) {
		int[][] matrix =     {{1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
			    {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
			    {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
			    {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
			    {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1}};
		System.out.println(RiverSizes.riverSizes(matrix));
	}

	public static List<Integer> riverSizes(int[][] matrix) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					ans.add(helper(matrix.length, matrix[0].length, i, j, matrix));
				}
			}
		}
		return ans;
	}

	public static int helper(int m, int n, int i, int j, int[][] matrix) {
		if (i >= m || j >= n || i < 0 || j < 0 || matrix[i][j] == 0) {
			return 0;
		} else {
			matrix[i][j] = 0;
			return 1 + helper(m, n, i - 1, j, matrix) + helper(m, n, i + 1, j, matrix) + 
					helper(m, n, i, j - 1, matrix) + helper(m, n, i, j + 1, matrix);
		}
	}

}
