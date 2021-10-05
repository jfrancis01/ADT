package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphValidTree {

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } }; // { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4
																				// } };
		GraphValidTree gvt = new GraphValidTree();
		System.out.println(gvt.validTree(n, edges));
	}

	public boolean validTree(int n, int[][] edges) {
		boolean cycleFound = checkCycle(n, edges);
		boolean isConnected = checkConnected(n, edges);
		if (!cycleFound && isConnected)
			return true;
		return false;
	}

	private boolean checkConnected(int n, int[][] edges) {
		HashSet<Integer> visited = new HashSet<Integer>();
		HashMap<Integer, ArrayList<Integer>> adjList = this.createAdjList(n, edges, true);
		// We start at the root and try to go to each node;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			visited.add(current);
			ArrayList<Integer> neighbours = adjList.get(current);
			int size = neighbours.size();
			for (int j = 0; j < size; j++) {
				Integer temp = neighbours.get(j);
				if (!visited.contains(temp))
					queue.add(temp);
			}
		}
		return visited.size() == n ? true : false;
	}
	
	private boolean checkCycle(HashMap<Integer, ArrayList<Integer>> adjList, 
			HashSet<Integer> visited, int parent, int start) {
		visited.add(start);
		ArrayList<Integer> neighbours = adjList.get(start);
		for(int neighbour : neighbours) {
			if(neighbour != parent) {
				if(visited.contains(neighbour)) return true;
			}
			if(checkCycle(adjList, visited, start, neighbour)) return true;
		}
		
		return false;
	}

	private boolean checkCycle(int n, int[][] edges) {
		HashMap<Integer, ArrayList<Integer>> adjList = this.createAdjList(n, edges, true);
		Queue<Integer> queue = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		HashSet<Integer> visiting = new HashSet<Integer>();
		queue.add(0);
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			if (visiting.contains(current) || visited.contains(current))
				return true;
			visiting.add(current);
			ArrayList<Integer> neighbours = adjList.get(current);
			int size = neighbours.size();
			for (int i = 0; i < size; i++) {
				Integer temp = neighbours.get(i);
				queue.add(temp);
			}
			visited.add(current);
			visiting.remove(current);
		}
		return false;
	}

	private HashMap<Integer, ArrayList<Integer>> createAdjList(int n, int[][] edges, boolean forCycle) {
		// create the adjaceny list
		HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			adjList.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			ArrayList<Integer> temp = adjList.get(edge[0]);
			temp.add(edge[1]);
			adjList.put(edge[0], temp);

			if (forCycle) {
				temp = adjList.get(edge[1]);
				temp.add(edge[0]);
				adjList.put(edge[1], temp);
			}
		}

		return adjList;
	}

}
