package org.code;

import java.util.ArrayList;
import java.util.Collections;

public class PathMinEffort {
	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	ArrayList<Integer> maximums = new ArrayList<Integer>();

	public static void main(String[] args) {
		//int[][] heights = {{1,2,3},{3,8,4},{5,3,5}};
		int[][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
		PathMinEffort pme = new PathMinEffort();
		System.out.println(pme.minimumEffortPath(heights));

	}

	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		boolean[][][] visited = new boolean[m][n][4];
		int currentMax = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		dfs(heights, visited, i, j, m, n, currentMax);
		Collections.sort(maximums);
		return maximums.get(0);
		
	}
	
	private void dfs(int[][]heights, boolean[][][] visited, int i, int j, int m, int n, int currentMax) {
		
		if(i == m -1 && j == n -1) {
			maximums.add(currentMax);
			return;
		}
		
		for(int k = 0; k < 4; k++) {
			int[] dir = dirs[k];
			int tempMax = currentMax;
			if(i + dir[0] >= 0 && j + dir[1] >= 0 && i + dir[0] < m && j + dir[1] < n && !visited[i + dir[0]][j + dir[1]][k]) {
				//choose
				visited[i + dir[0]][j + dir[1]][k] = true;
				currentMax = Math.max(currentMax, Math.abs(heights[i][j] - heights[i + dir[0]][j + dir[1]]));
				//explore
				dfs(heights, visited, i + dir[0], j + dir[1], m, n, currentMax);
				//unchoose
				visited[i + dir[0]][j+ dir[1]][k] = false;
				currentMax = tempMax;
			}
			
		}
	}

}
