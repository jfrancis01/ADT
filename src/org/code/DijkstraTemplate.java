package org.code;

import java.util.HashMap;

public class DijkstraTemplate {

	public static void main(String[] args) {
		DijkstraTemplate dt = new DijkstraTemplate();
		int start = 0;
		int[][][] edges = { { { 1, 7 } }, { { 2, 6 }, { 3, 20 }, { 4, 3 } }, { { 3, 14 } }, { { 4, 2 } }, { {} },
				{ {} } };
		int[] ans = dt.dijkstrasAlgorithm(start, edges);
		for (int val : ans) {
			System.out.print(val + " ");
		}
	}

	public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
		// this is the map that will contain the distances of the
		// start node to the other nodes.
		// You have to create an adjacency list if not given one
		HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
		int N = edges.length;
		for (int i = 0; i < N; i++) {
			dist.put(i, Integer.MAX_VALUE); // initially all the nodes have dist infinity
		}
		dist.put(start, 0);// distance from start to itself is 0
		// i nodes so we don't go in a circle
		boolean[] visited = new boolean[N];
		// start the loop always picking the node with the smallest distance
		while (true) {
			int candidateNode = -1;
			int candidateDist = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				if (!visited[i] && dist.get(i) < candidateDist) {
					candidateDist = dist.get(i);
					candidateNode = i;
				}
			}
			if (candidateNode < 0) {
				System.out.println("Something went wrong");
				break;// disconnected component
			}
			// mark the node as visited and evaluate distance to neighbours
			visited[candidateNode] = true;
			int[][] adjList = edges[candidateNode];
			for (int k = 0; k < adjList.length; k++) {
				int arr[] = adjList[k];
				if(arr.length > 0) {
					if (dist.get(candidateNode) + arr[1] < dist.get(arr[0])) {
						dist.put(arr[0], dist.get(candidateNode) + arr[1]);
					}
				}
			}
		}

		int[] vals = new int[N];
		for (int i = 0; i < N; i++) {
			if (dist.get(i) == Integer.MAX_VALUE) {
				vals[i] = -1;
			} else {
				vals[i] = dist.get(i);
			}
		}
		return vals;
	}

}
