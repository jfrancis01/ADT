package org.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class NetworkDelayV2 {

	public static void main(String[] args) {
		int[][] times = {{1,2,1}} ;//{ { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int N = 2;
		int k = 2;
		NetworkDelayV2 d = new NetworkDelayV2();
		int time = d.networkDelayTime(times, N, k);
		System.out.println(time);
	}
	
	public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[]b){
                return Integer.compare(a[1], b[1]);
            }
        });
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<Integer, ArrayList<int[]>>();
        HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
        int i;
        for(i = 1; i <= n; i++){
            if(i != k){
                dist.put(i, Integer.MAX_VALUE); // all nodes are  at infinite distance
            }else{
                dist.put(i, 0);// the source node is always 0 distance
            }
            graph.put(i, new ArrayList<int[]>());
        }
        for(i = 0; i < times.length; i++){
            int[] edge = times[i];
            ArrayList<int[]> neighbours = graph.get(edge[0]);
            neighbours.add( new int[]{edge[1], edge[2]});
            graph.put(edge[0], neighbours);
        }
        pq.add(new int[] {k, 0});
        while(!pq.isEmpty()) {
        	int[] curr = pq.poll();
        	for(int[] edge : graph.get(curr[0])) {
        		if(dist.get(curr[0]) + edge[1]< dist.get(edge[0])){
        			dist.put(edge[0],  dist.get(curr[0]) + edge[1]);
        			pq.add(new int[] {edge[0],  dist.get(curr[0]) + edge[1]});
        		}
        	}
        }
        int max = Integer.MIN_VALUE;
        for( i = 1; i <= n; i++) {
        	max = Math.max(max,  dist.get(i));
        }
        return max == Integer.MAX_VALUE? -1 : max;
    }

}
