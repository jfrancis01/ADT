package org.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumKnightMoves {

	private static final List<int[]> DIRECTIONS = Arrays.asList(new int[] { -2, 1 }, // up up right
			new int[] { -2, -1 }, // up up left
			new int[] { 2, 1 }, // down down right
			new int[] { 2, -1 }, // down down left
			new int[] { 1, -2 }, // down left left
			new int[] { 1, 2 }, // down right right
			new int[] { -1, -2 }, // up left left
			new int[] { -1, 2 } // up right right
	);

	public int minKnightMoves(int x, int y) {
		int level = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		HashSet<int[]> visited = new HashSet<>();
		q.add(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] point = q.poll();
				visited.add(point);
				for (int[] delta : DIRECTIONS) {
					int[] newPoint = { point[0] + delta[0], point[1] + delta[1] };
					if (newPoint[0] == x && newPoint[1] == y) {
						return level + 1;
					}
					q.add(newPoint);
				}
			}
			level++;
		}

		return level;
	}

	public static void main(String[] args) {
		MinimumKnightMoves mkm = new MinimumKnightMoves();
		System.out.println(mkm.minKnightMoves(5, 5));

	}

}
