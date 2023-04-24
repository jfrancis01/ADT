package org.code;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumPasses {

	public static void main(String[] args) {
		int[][] matrix = { { 0, -1, -3, 2, 0 }, { 1, -2, -5, -1, -3 }, { 3, 0, 0, -4, -1 } };
		MinimumPasses mp = new MinimumPasses();
		System.out.println(mp.minimumPassesOfMatrix(matrix));

	}

	public int minimumPassesOfMatrix(int[][] matrix) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int i, j, k;
		int m = matrix.length;
		int n = matrix[0].length;
		// first find all the positive numbers
		// and add it to the queue
		for (i = 0; i < matrix.length; i++) {
			for (j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] > 0) {
					int[] val = { i, j };
					queue.add(val);
				}
			}
		}
		int passes = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean flag = false;
			for (k = 0; k < size; k++) {
				int[] dot = queue.poll();
				i = dot[0];
				j = dot[1];
				if (i + 1 < m && matrix[i + 1][j] < 0) {
					matrix[i + 1][j] = matrix[i + 1][j] * -1;
					flag = true;
					queue.add(new int[] { i + 1, j });
				}
				if (i - 1 >= 0 && matrix[i - 1][j] < 0) {
					matrix[i - 1][j] = matrix[i - 1][j] * -1;
					flag = true;
					queue.add(new int[] { i - 1, j });
				}
				if (j + 1 < n && matrix[i][j + 1] < 0) {
					matrix[i][j + 1] = matrix[i][j + 1] * -1;
					flag = true;
					queue.add(new int[] { i, j + 1 });
				}
				if (j - 1 >= 0 && matrix[i][j - 1] < 0) {
					matrix[i][j - 1] = matrix[i][j - 1] * -1;
					flag = true;
					queue.add(new int[] { i, j - 1 });
				}
			}
			if (flag) {
				passes++;
			}
		}
		return isAllPos(matrix) ? passes : -1;
	}

	private boolean isAllPos(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 0) {
					return false;
				}
			}
		}
		return true;
	}

}
