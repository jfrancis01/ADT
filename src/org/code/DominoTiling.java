package org.code;

public class DominoTiling {
	static int ways = 0;
	public static void main(String[] args) {
		int m = 3;
		int n = 2;
		int[][] board = new int[m][n];
		DominoTiling dt = new DominoTiling();
		dt.tile(board, m, n);
		System.out.println(ways);
	}
	
	public void tile(int[][]board, int m, int n) {
		int[][]visited = new int[m][n];
		int i, j;
		for(i = 0; i < m; i++) {
			for(j = 0; j < n; j++) {
				visited[i][j] = -1;
			}
		}
		for(i = 0; i < m; i++) {
			for(j = 0; j < n; j++) {
				if(visited[i][j] == -1) {
					placeTile(board, visited, m, n, i, j);
				}
			}
		}
		placeTile(board, visited, 0, 0, m, n);
	}
	
	private boolean isFilled(int[][]visited) {
		for(int i  = 0; i < visited.length; i++) {
			for(int j = 0; j < visited[0].length; j++) {
				if(visited[i][j] == -1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void placeTile(int[][]board, int[][]visited, int m, int n, int i, int j) {
		if(isFilled(visited)) {
			ways++;
			return;
		}
		if(i < 0 || i >=m || j < 0 || j >= n|| visited[i][j] != -1) {
			return;
		}
		visited[i][j] = 1; //mark the tile as visited
		//either go vertically
		if(i + 1 < m && visited[i + 1][j] == 1) {
			visited[i + 1][j] = 1;
		}
	}

}
