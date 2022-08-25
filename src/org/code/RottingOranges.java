package org.code;

import java.util.ArrayList;

public class RottingOranges {

	public static void main(String[] args) {
		RottingOranges ro = new RottingOranges();
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 1 }, { 0, 1, 2 } };
		System.out.println(ro.orangesRotting(grid));
	}

	class Pair {
		int r;
		int c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public int orangesRotting(int[][] grid) {
		ArrayList<int[]> queue = new ArrayList<int[]>();
		int level = 0;
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int sr = -1;
		int sc = -1;
		boolean oneFound = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					visited[i][j] = true;
					oneFound = true;
				}
				if (grid[i][j] == 2) {
					queue.add(new int[] { i, j });
				}
			}
		}
		// these are the edge cases
		if (grid.length == 1 && grid[0].length == 1) {
			if (grid[0][0] == 1)
				return -1;
			if (grid[0][0] == 0)
				return 0;
		}
		if (!oneFound)
			return 0;
		// if (sr == -1 && sc == -1)
		// return -1;
		ArrayList<int[]> done = new ArrayList<int[]>();
		// int[] start = { sr, sc };
		// queue.add(start);
		// done.add(start);
		while (queue.size() > 0) {
			// get the first node;
			int group = queue.size();
			while (group > 0) {
				int[] temp = queue.remove(0);
				int r = temp[0];
				int c = temp[1];
				visited[r][c] = false;
				grid[r][c] = 2;
				if (isValid(grid, r + 1, c) && grid[r + 1][c] == 1 && visited[r + 1][c] == true
						&& !checkinQueue(r + 1, c, done)) {
					int[] arr1 = { r + 1, c };
					queue.add(arr1);
					done.add(arr1);

				}
				if (isValid(grid, r - 1, c) && grid[r - 1][c] == 1 && visited[r - 1][c] == true
						&& !checkinQueue(r - 1, c, done)) {
					int[] arr2 = { r - 1, c };
					queue.add(arr2);
					done.add(arr2);
				}
				if (isValid(grid, r, c + 1) && grid[r][c + 1] == 1 && visited[r][c + 1] == true
						&& !checkinQueue(r, c + 1, done)) {
					int[] arr3 = { r, c + 1 };
					queue.add(arr3);
					done.add(arr3);
				}
				if (isValid(grid, r, c - 1) && grid[r][c - 1] == 1 && visited[r][c - 1] == true
						&& !checkinQueue(r, c - 1, done)) {
					int[] arr4 = { r, c - 1 };
					queue.add(arr4);
					done.add(arr4);
				}
				if (allVisited(visited, grid)) {
					return level;
				}
				--group;
			}
			level++;
		}
		return allVisited(visited, grid) ? level : -1;
	}

	/*
	 * This function checks if all the oranges are rotten
	 */
	public boolean allVisited(boolean[][] visited, int[][] grid) {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				if (grid[i][j] == 1) {
					if (visited[i][j] == true) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/*
	 * This function returns true if a row and column is valid; false if it is not
	 * valid
	 */
	public boolean isValid(int[][] grid, int r, int c) {
		if (r < grid.length && r >= 0 && c < grid[0].length && c >= 0) {
			return true;
		}
		return false;
	}

	public boolean checkinQueue(int r, int c, ArrayList<int[]> done) {
		for (int[] temp : done) {
			if (r == temp[0] && c == temp[1]) {
				return true;
			}
		}
		return false;
	}

}
