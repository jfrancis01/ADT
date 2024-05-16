package org.code;

import java.util.ArrayList;
import java.util.HashMap;

public class ReorderToZero {

	int changes = 0;
	boolean[] visited;
	HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
	HashMap<Integer, ArrayList<Integer>> undirected = new HashMap<Integer, ArrayList<Integer>>();

	public static void main(String[] args) {
		int n = 5;
		int[][] connections = { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } };
		ReorderToZero rtz = new ReorderToZero();
		System.out.println(rtz.minReorder(n, connections));

	}

	public int minReorder(int n, int[][] connections) {
		visited = new boolean[n];
		createAdjList(n, connections);
		helper(0, n, connections);
		return changes;
	}

	private void helper(int node, int n, int[][] connections) {
		if (visited[node])
			return;
		visited[node] = true;
		ArrayList<Integer> childs = undirected.get(node);
		for (int i = 0; i < childs.size(); i++) {
			if (!visited[childs.get(i)] && !foundLink(adjList.get(childs.get(i)), node)) {
				changes++;
			}
			helper(childs.get(i), n, connections);
		}
	}

	private void createAdjList(int n, int[][] connections) {
		int i, j;
		for (i = 0; i < n; i++) {
			adjList.put(i, new ArrayList<Integer>());
			undirected.put(i, new ArrayList<Integer>());
		}
		for (i = 0; i < connections.length; i++) {
			int[] conn = connections[i];
			ArrayList<Integer> temp = adjList.get(conn[0]);
			temp.add(conn[1]);
			adjList.put(conn[0], temp);
			temp = undirected.get(conn[0]);
			temp.add(conn[1]);
			undirected.put(conn[0], temp);
			temp = undirected.get(conn[1]);
			temp.add(conn[0]);
			undirected.put(conn[1], temp);
		}
	}

	private boolean foundLink(ArrayList<Integer> conns, int node) {
		for (int i = 0; i < conns.size(); i++) {
			if (conns.get(i) == node) {
				return true;
			}
		}
		return false;
	}

}
