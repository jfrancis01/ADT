package org.code;

import java.util.HashSet;

public class CycleGraph {

	public static void main(String[] args) {
		CycleGraph cg =  new CycleGraph(); 
		int[][] edges = {{1,2}, {2}, {}};
		System.out.println(cg.cycleInGraph(edges));

	}

	public boolean cycleInGraph(int[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			if (dfs(i, edges, new HashSet<Integer>())) {
				return true;
			}
		}
		return false;
	}

	private boolean dfs(int v, int[][] edges, HashSet<Integer> visited) {
		if (visited.contains(v)) {
			return true;
		}
		visited.add(v);
		for (int edge : edges[v]) {
			if (dfs(edge, edges, visited)) {
				return true;
			}
		}
		visited.remove(v);
		return false;
	}
}
