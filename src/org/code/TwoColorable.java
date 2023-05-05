package org.code;

public class TwoColorable {

	public static void main(String[] args) {
		int[][] edges = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		TwoColorable tc = new TwoColorable();
		System.out.println(tc.twoColorable(edges));
	}

	public boolean twoColorable(int[][] edges) {
		int n = edges.length; // # of vertices
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			int[] edge = edges[i];
			for (int j = 0; j < edge.length; j++) {
				if (uf.union(i, edge[j])) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	private class UnionFind {
		int[] parent;
		int[] colors;

		public UnionFind(int n) {
			parent = new int[n];
			colors = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i; // initially you are your own parent
			}
		}

		public int find(int x) {
			if (parent[x] == x)
				return x;
			return (parent[x]);
		}

		public boolean union(int x, int y) {
			int parentX = find(x);
			int parentY = find(y);
			if (parentX != parentY) {
				// if both are zero then we are free to assign a color
				if (colors[x] == 0 && colors[y] == 0) {
					colors[x] = 1;
					colors[y] = 2;
					// still have to union them
					parent[parentY] = parentX;
					return true;
				}
				// if x is 0 and the colors don't match or Y has not been
				// assigned a color
				else if (colors[x] != 0 && colors[y] == 0) {
					if (colors[x] == 1) {
						colors[y] = 2;
					} else {
						colors[y] = 1;
					}
					// still have to union them
					parent[parentY] = parentX;
					return true;
				} else if (colors[x] == 0 && colors[y] != 0) {
					if (colors[y] == 1) {
						colors[x] = 2;
					} else {
						colors[x] = 1;
					}
					// still have to union them
					parent[parentY] = parentX;
					return true;
				} else {
					if (colors[x] != colors[y]) {
						parent[parentY] = parentX;
						return true;
					}
					return false;
				}
			}
			// here if they have the same parent, then you have to check
			// if their colors are different
			else {
				return colors[x] == colors[y] ? false : true;
			}
		}
	}
}
