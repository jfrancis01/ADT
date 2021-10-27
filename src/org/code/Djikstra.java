package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Djikstra {
	
	/**
	 * Djikstra is single source shortest path to all other nodes.
	 * To solve the Network delay problem, you find all the distances to each node and
	 * then pick the biggest valyue of these. Since we intialize all the costs to infinity,
	 * one of the nodes still has an infinite cost then  it is not connected and the answer is -1
	 */
	
	Map<Integer, Integer> dist; // this is the max to keep track of all the distances to each node
	
	public static void main(String[] args) {
		int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
		int N = 4;
		int k = 2;
		Djikstra d = new Djikstra();
		int time = d.networkDelayTime(times, N, k);
		System.out.println(time);

	}
	 public int networkDelayTime(int[][] times, int N, int K) {
		 
		 //Create the adjaceny list
		 Map<Integer, List<int[]>> graph = new HashMap();
		 for(int i = 0; i < times.length; i++) {
			 int[] edge = times[i];
			 if(!graph.containsKey(edge[0])) {
				 graph.put(edge[0], new ArrayList<int[]>());
				 graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
			 }
		 }
		 
		 //initialize the dist map
		 dist = new HashMap();
		 //set all the nodes to infinity
		 for(int i = 1; i <= N; i++) {
			 dist.put(i, Integer.MAX_VALUE);
		 }
		 //set the source distance to be 0, since it is the starting point
		 dist.put(K, 0);
		 
	 }

}
