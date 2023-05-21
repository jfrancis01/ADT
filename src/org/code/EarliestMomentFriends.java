package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class EarliestMomentFriends {

	public static void main(String[] args) {
		int[][]logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},
				{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
		int n = 6;
		EarliestMomentFriends emf = new EarliestMomentFriends();
		System.out.println();
		System.out.println(emf.earliestAcq2(logs, n));
	}
	
	public int earliestAcq2(int[][]logs, int n) {
		//sort the logs in ascending order
        Arrays.sort(logs, new Comparator<int[]>() {
        	@Override
        	public int compare(int[]a, int[]b) {
        		return Integer.compare(a[0], b[0]);
        	}
        });
        UnionFind uf = new UnionFind(n);
        for(int pos = 0; pos < logs.length; pos++) {
        	int[] log = logs[pos];
        	if(!uf.isConnected(log[1], log[2])) {
        		int comps = uf.union(log[1], log[2]);
        		if(comps == 1) {
        			return log[0];
        		}
        	}
        	
        }
        
        return -1;
	}
	public int earliestAcq(int[][] logs, int n) {
		//sort the logs in ascending order
        Arrays.sort(logs, new Comparator<int[]>() {
        	@Override
        	public int compare(int[]a, int[]b) {
        		return Integer.compare(a[0], b[0]);
        	}
        });
        
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        //we keep adding edgesg until the BFS returns with all nodes visited
        for(int i = 0; i <n; i++) {
        	graph.put(i, new ArrayList<Integer>());
        }
        for(int pos = 0; pos < logs.length; pos++) {
        	//retrieve the log
        	int[] log = logs[pos];
        	//add the edge to the adjacency list
        	ArrayList<Integer> arr1 = graph.get(log[1]);
        	ArrayList<Integer> arr2 = graph.get(log[2]);
        	arr1.add(log[2]);
        	arr2.add(log[1]);
        	
        	//perform BFS
        	Queue<Integer> queue = new LinkedList<Integer>();
        	queue.add(1);
        	HashSet<Integer> visited = new HashSet<Integer>();
        	while(!queue.isEmpty()) {
        		int current = queue.poll();
        		visited.add(current);
        		if(visited.size() == n) {
        			return log[0];
        		}
        		for(int node : graph.get(current)) {
        			if(!visited.contains(node)) {
        				queue.add(node);
        			}
        		}
        	}
        	
        }
        
        return -1;
    }
	
	class UnionFind{
		public int[] root;
		public int[] rank;
		int components;
		
		private UnionFind(int n) {
			root = new int[n];
			rank = new int[n];
			for(int i = 0; i < n; i++) {
				root[i] = i;
				rank[i] = 1;
			}
			components = n;
		}
		
		private int find(int x) {
			if(root[x] == x) {
				return x;
			}
			return find(root[x]);
		}
		
		private int union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if(rootX != rootY) {
				if(rank[rootX] > rank[rootY]) {
					root[rootY] = rootX;
				}
				else if(rank[rootY] > rank[rootX]) {
					root[rootX] = rootY;
				}
				else {
					root[rootY] = rootX;
					rank[rootX]++;
				}
				components--;
			}
			return components;
		}
		
		private boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}
	}
	
}
