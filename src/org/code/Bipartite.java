package org.code;

public class Bipartite {
	
	int[]colors;

	public static void main(String[] args) {
		Bipartite bp = new Bipartite();
		int[][] edges = {{1,3}, {0,2}, {1,3}, {0,2}};
		System.out.println(bp.isBipartite(edges));
	}

	public boolean isBipartite(int[][] edges) {
		int n = edges.length; // # of vertices
		colors = new int[n];
		int prev = 0;
		for (int i = 0; i < n; i++) {
			if (dfs(i, edges, colors, prev)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int i, int[][] edges, int[] colors, int prev) {
		if (colors[i] == 0 && prev == 0) {
			colors[i] = 1;
			prev = 1;
		}
		else if (colors[i] == 0 && prev != 0) {
			if (prev == 1) {
				colors[i] = 2;
				prev = 2;
			} else {
				colors[i] = 1;
				prev = 1;
			}
		}
		else {
			if (colors[i] != 0 && prev != 0) {
				if (colors[i] == prev) {
					return false;
				}
				return true;
			}
			return true;
		}
		for (int j = 0; j < edges[i].length; j++) {
			if (!dfs(edges[i][j], edges, colors, prev)) {
				return false;
			}
		}
		return true;
	}

}
