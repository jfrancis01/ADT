package org.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {

	public class Point {
		int x = 0;
		int y = 0;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };
		WallsAndGates wg = new WallsAndGates();
		wg.wallsAndGates(rooms);
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				System.out.print(rooms[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void wallsAndGates(int[][] rooms) {
		int rows = rooms.length;
		int cols = rooms[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (rooms[i][j] == 0) {
					HashSet<Point> set = new HashSet<Point>();
					Point p = new Point(i, j);
					bfs(p, rooms, rows, cols, set);
				}
			}
		}
	}

	public void bfs(Point p, int[][] rooms, int rows, int cols, HashSet<Point> set) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(p);
		set.add(p);
		int level = 0;
		while (q.size() > 0) {
			Point temp = q.poll();
			for (Point neighbour : getChildren(temp, rows, cols)) {
				if (set.contains(neighbour) || rooms[neighbour.x][neighbour.y] == -1
						|| rooms[neighbour.x][neighbour.y] == 0) {
					continue;
				}
				rooms[temp.x][temp.y] = Math.min(rooms[temp.x][temp.y], level);
				q.add(neighbour);
				set.add(temp);
			}
		}
		level++;
	}

	private List<Point> getChildren(Point p, int rows, int cols) {
		int row = p.x;
		int col = p.y;
		int[] deltaRow = { -1, 0, 1, 0 };
		int[] deltaCol = { 0, 1, 0, -1 };
		List<Point> neighbours = new ArrayList<Point>();
		for (int i = 0; i < deltaRow.length; i++) {
			int neighbourRow = row + deltaRow[i];
			int neighbourcol = col + deltaCol[i];
			if (neighbourRow >= 0 && neighbourRow < rows && neighbourcol >= 0 && neighbourcol < cols) {
				neighbours.add(new Point(neighbourRow, neighbourcol));
			}
		}
		return neighbours;
	}

}
