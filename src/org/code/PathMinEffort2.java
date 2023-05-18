package org.code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathMinEffort2 {
	int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {
		int[][] heights = { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } };
		// int[][] heights =
		// {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
		PathMinEffort2 pme2 = new PathMinEffort2();
		System.out.println(pme2.minimumEffortPath(heights));

	}

	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		boolean[][] visited = new boolean[m][n];
		int[][] difference = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				difference[i][j] = Integer.MAX_VALUE;
			}
		}
		difference[0][0] = 0;
		PriorityQueue<Cell> pq = new PriorityQueue<Cell>(new Comparator<Cell>() {
			@Override
			public int compare(Cell a, Cell b) {
				return a.diff < b.diff ? -1 : 1;
			}
		});

		Cell start = new Cell(0, 0, 0);
		pq.add(start);
		while (!pq.isEmpty()) {
			Cell current = pq.poll();
			visited[current.x][current.y] = true;
			for (int[] dir : dirs) {
				int x = current.x + dir[0];
				int y = current.y + dir[1];
				if (isValid(x, y, m, n) && !visited[x][y]) {
					int currentDiff = Math.abs(heights[current.x][current.y] - heights[x][y]);
					int maxDiff = Math.max(difference[current.x][current.y], currentDiff);
					if (difference[x][y] > maxDiff) {
						difference[x][y] = maxDiff;
						Cell cell = new Cell(x, y, difference[x][y]);
						pq.add(cell);
					}
				}
			}

		}
		return difference[m - 1][n - 1];
	}

	private boolean isValid(int x, int y, int m, int n) {
		return (x >= 0 && y >= 0 && x < m && y < n);
	}

	class Cell {
		int x;
		int y;
		int diff;

		public Cell(int x, int y, int diff) {
			this.x = x;
			this.y = y;
			this.diff = diff;
		}
	}

}
