package org.code;

public class TheMaze {
	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start = {0,4};
		int[] destination = {4,4};
		TheMaze tm = new TheMaze();
		System.out.println(tm.hasPath(maze, start, destination));
	}

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		return dfs(maze, start[0], start[1], destination, visited);
	}

	private boolean dfs(int[][] maze, int i, int j, int[] destination, boolean[][]visited) {
		if( visited[i][j]) {
			return false;
		}
		if (i == destination[0] && j == destination[1]) {
			return true;
		}
		
		visited[i][j] = true;

		for (int[] dir : dirs) {
			int x = i;
			int y  = j;
			while (x + dir[0] >= 0 && x + dir[0] < maze.length &&
					y + dir[1] >= 0 && y + dir[1] < maze[0].length &&
					maze[x + dir[0]][y + dir[1]] == 0) {
				x+=dir[0];
				y+=dir[1];
			}
			if(dfs(maze, x , y, destination, visited)) {
				return true;
			}
		}
		return false;
		
	}

}
