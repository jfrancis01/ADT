package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelay {

	/**
	 * Djikstra is single source shortest path to all other nodes. To solve the
	 * Network delay problem, you find all the distances to each node and then pick
	 * the biggest valyue of these. Since we intialize all the costs to infinity,
	 * one of the nodes still has an infinite cost then it is not connected and the
	 * answer is -1
	 */

	Map<Integer, Integer> dist; // this is the max to keep track of all the distances to each node

	public static void main(String[] args) {
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int N = 4;
		int k = 2;
		NetworkDelay d = new NetworkDelay();
		int time = d.networkDelayTime(times, N, k);
		System.out.println(time);

	}

	public int networkDelayTime(int[][] times, int N, int K) {

		// Create the adjaceny list
		Map<Integer, List<int[]>> graph = new HashMap();
		for (int i = 0; i < times.length; i++) {
			int[] edge = times[i];
			if (!graph.containsKey(edge[0])) {
				graph.put(edge[0], new ArrayList<int[]>());
			}
			graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
		}

		// initialize the dist map
		dist = new HashMap();
		// visited map
		boolean[] seen = new boolean[N + 1];
		// set all the nodes to infinity
		for (int i = 1; i <= N; i++) {
			dist.put(i, Integer.MAX_VALUE);
		}
		// set the source distance to be 0, since it is the starting point
		dist.put(K, 0);
		// start the loop always picking the node with the shortest calculated distance
		while (true) {
			int canNode = -1;
			int canDist = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				if (!seen[i] && dist.get(i) < canDist) {
					canNode = i;
					canDist = dist.get(i);
				}
			}

			if (canNode < 0)
				break; // This means there was a disconnected component
			seen[canNode] = true;
			if (graph.containsKey(canNode)) {
				for (int info[] : graph.get(canNode)) {
					dist.put(info[0], Math.min(dist.get(info[0]), dist.get(canNode) + info[1]));
				}
			}
		}
		// now we find the maximum shortest distance
		int ans = 0;
		for (int cand : dist.values()) {
			if (cand == Integer.MAX_VALUE)
				return -1;
			ans = Math.max(ans, cand);
		}
		return ans;

	}

}
