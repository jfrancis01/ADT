package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TimeNeededEmployees {

	Map<Integer, Integer> dist;

	public static void main(String[] args) {
		int head = 2;
		int n = 6;
		int[] manager = { 2, 2, -1, 2, 2, 2 };
		int[] informTime = { 0, 0, 1, 0, 0, 0 };
		TimeNeededEmployees tne = new TimeNeededEmployees();
		System.out.println("Time Needed Without Heap: " + tne.numOfMinutes(n, head, manager, informTime));
		System.out.println("Time Needed With Heap: " + tne.numOfMinutesWithHeap(n, head, manager, informTime));

	}

	/*
	 * Without the heap the time limit was exceeded. Let's try implements with a
	 * head
	 */

	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		Map<Integer, ArrayList<int[]>> tree = new HashMap<Integer, ArrayList<int[]>>();
		for (int i = 0; i < n; i++) {
			if (manager[i] == -1)
				continue;
			int mgrId = manager[i], timeToInform = informTime[mgrId];
			if (!tree.containsKey(mgrId)) {
				tree.put(mgrId, new ArrayList<int[]>());
			}
			tree.get(mgrId).add(new int[] { i, timeToInform });
		}

		dist = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			dist.put(i, Integer.MAX_VALUE);
		}
		boolean[] seen = new boolean[n];
		dist.put(headID, 0);

		while (true) {
			int candNode = -1;
			int candDist = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (!seen[i] && dist.get(i) < candDist) {
					candDist = dist.get(i);
					candNode = i;
				}
			}

			if (candNode < 0)
				break;
			seen[candNode] = true;
			if (tree.containsKey(candNode)) {
				for (int[] info : tree.get(candNode)) {
					dist.put(info[0], Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
				}
			}
		}

		int ans = 0;
		for (int val : dist.values()) {
			if (val == Integer.MAX_VALUE)
				return -1;
			ans = Math.max(ans, val);
		}
		return ans;

	}

	public int numOfMinutesWithHeap(int n, int headID, int[] manager, int[] informTime) {
		Map<Integer, ArrayList<int[]>> tree = new HashMap<Integer, ArrayList<int[]>>();
		for (int i = 0; i < n; i++) {
			if (manager[i] == -1)
				continue;
			int mgrId = manager[i], timeToInform = informTime[mgrId];
			if (!tree.containsKey(mgrId)) {
				tree.put(mgrId, new ArrayList<int[]>());
			}
			tree.get(mgrId).add(new int[] { i, timeToInform });
		}

		PriorityQueue<int[]> heap = new PriorityQueue<int[]>((info1, info2) -> info1[0] - info2[0]);
		heap.offer(new int[] { 0, headID});
		dist = new HashMap<Integer, Integer>();
		
		
		while (!heap.isEmpty()) {
			int[] info = heap.poll();
			int d = info[0]; int node = info[1];
			if(dist.containsKey(node)) continue;
			dist.put(node, d);
			if(tree.containsKey(node)) {
				for(int[] edge : tree.get(node)) {
					int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
				}
			}
			
		}

		int ans = 0;
		for (int val : dist.values()) {
			if (val == Integer.MAX_VALUE)
				return -1;
			ans = Math.max(ans, val);
		}
		return ans;

	}

}
