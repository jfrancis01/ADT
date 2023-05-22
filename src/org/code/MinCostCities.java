package org.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MinCostCities {

	public static void main(String[] args) {
		int[][] connections = new int[][] {{1,2,3},{3,4,4}};//{{1,2,5},{1,3,6},{2,3,1}};
		int n = 4;
		MinCostCities mcc = new MinCostCities();
		System.out.println(mcc.minimumCost(n, connections));
	}

	public int minimumCost(int n, int[][] connections) {
		// build the graph
		int i;
		HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
		for (i = 1; i <= n; i++) {
			graph.put(i, new ArrayList<int[]>());
		}
		for (int[] edge : connections) {
			ArrayList<int[]> l1 = graph.get(edge[0]);
			ArrayList<int[]> l2 = graph.get(edge[1]);
			l1.add(new int[] { edge[1], edge[2] });
			l2.add(new int[] { edge[0], edge[2] });
			graph.put(edge[0], l1);
			graph.put(edge[1], l2);
		}
		int cost = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});
		// we start of with one node as the starting point, let it be node 1
		// the distance to this node is 0;
		pq.offer(new int[] { 1, 0 });
		// for all the others, we set the distance to infinity
		for (i = 2; i <= n; i++) {
			pq.offer(new int[] { i, Integer.MAX_VALUE });
		}

		while (!(visited.size() == n)) {// run the loop till all vertices have been visited
			int[] curr = pq.poll();
			if(curr[1] == Integer.MAX_VALUE) {// this means that there was a node unreachable
				break;
			}
			if (visited.add(curr[0]) == false) {
				continue;
			} else {
				cost += curr[1];
				// for all the neighbours, calculate the distances
				for (int[] edge : graph.get(curr[0])) {
					if (edge[0] != curr[0] && visited.contains(edge[0]) == false) {
						int dist = edge[1];
						pq.offer(new int[] { edge[0], dist });
					}
				}
			}
		}
		return visited.size()==n?cost: -1;
	}

}
