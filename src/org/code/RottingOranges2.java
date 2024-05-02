package org.code;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges2 {

	public static void main(String[] args) {
		RottingOranges2 ro2 = new RottingOranges2();
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(ro2.orangesRotting(grid));
	}

	public int orangesRotting(int[][] grid) {
		// first count the number oif oranges
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int good = 0, bad = 0, i, j, mins = 0;
		;
		int rows = grid.length;
		int cols = grid[0].length;
		Queue<int[]> queue = new LinkedList<int[]>();
		for (i = 0; i < rows; i++) {
			for (j = 0; j < cols; j++) {
				if (grid[i][j] == 2) {
					bad++;
					queue.add(new int[] { i, j });
				}
				if (grid[i][j] == 1) {
					good++;
				}
			}
		}
		while (!queue.isEmpty()) {
			if (good == 0) {
				break;
			}
			int size = queue.size();
			int[] index = { 0, 0 };
			for (i = 0; i < size; i++) {
				index = queue.poll();
				for (j = 0; j < 4; j++) {
					int[] dir = dirs[j];
					int nrow = index[0] + dir[0];
					int ncol = index[1] + dir[1];
					if (nrow >= 0 && ncol >= 0 && nrow < rows && ncol < cols) {
						if (grid[nrow][ncol] == 1) {
							// change it to a rotting orange and dd it to the queue
							grid[nrow][ncol] = 2;
							queue.add(new int[] { nrow, ncol });
							good--;
						}
					}
				}
			}
			mins++;

		}
		return good == 0 ? mins : -1;
	}

}
