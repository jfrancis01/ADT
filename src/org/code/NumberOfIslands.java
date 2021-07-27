package org.code;

public class NumberOfIslands {
	
	public static void main(String argv[]) {
		
		/*
		 * char[][]grid = { {1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0}, {0,0,0,0,0} };
		 */
		 
		
		  char[][]grid = { {1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1} };
		 
		 
		int islands = numIslands(grid);
		System.out.println(islands);
	}

	public static int numIslands(char[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int m = grid.length;
		int n = grid[0].length;
		int islands = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j <grid[0].length; j++) {
				if(grid[i][j] == 1  && !visited[i][j]) {
					dfs(grid, visited, i , j, m, n);
					islands++;
				}
			}
		}
		print(visited);
		return islands;
	}
	
	public static void dfs(char[][]grid, boolean[][] visited, int i, int j, int m, int n) {
		if(i > m - 1 || j > n - 1|| i < 0 || j < 0) {
			return;
		}
		if(grid[i][j] == 0) {
			return;
		}
		if(grid[i][j] == 1 && !visited[i][j]) {
			visited[i][j] = true;
			dfs(grid, visited, i , j + 1 , m, n);//right
			dfs(grid, visited, i , j - 1, m, n);//left
			dfs(grid, visited, i + 1 , j ,m, n);//down
			dfs(grid, visited, i - 1 , j , m, n);//up
		}
		return;
	}
	
	public static void print(boolean[][]visited) {
		for(int i = 0; i <visited.length; i++) {
			for(int j = 0; j < visited[0].length; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}
}
