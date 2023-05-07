package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestStringSwaps {

	public static void main(String[] args) {
		SmallestStringSwaps sss = new SmallestStringSwaps();
		String s = "dcab";
		List<Integer> one = new ArrayList<Integer>();
		one.add(0);
		one.add(3);
		List<Integer> two = new ArrayList<Integer>();
		two.add(1);
		two.add(2);
		List<List<Integer>> pairs = new ArrayList<List<Integer>>();
		pairs.add(one);
		pairs.add(two);
		System.out.println(sss.smallestStringWithSwaps(s, pairs));
	}

	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		int n = s.length();

		// 1. Initialise a union find object.
		UnionFind groups = new UnionFind(n);

		// 2. Iterate swaps to find connected paths.
		for (List<Integer> pair : pairs) {
			int node1 = pair.get(0);
			int node2 = pair.get(1);
			groups.union(node1, node2);
		}

		// 3. Collect sorted letters in each path
		Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int parent = groups.find(i);
			map.putIfAbsent(parent, new PriorityQueue<>());
			map.get(parent).add(s.charAt(i));
		}

		// 4. Get path and append smallest letter
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int parent = groups.find(i);
			Character a = map.get(parent).poll();
			res.append(a);
		}
		return res.toString();
	}

	class UnionFind {
	    int[] parent;
	    public UnionFind(int n) {
	        parent = new int[n];
	        for (int i = 0; i < n; i++) {
	            parent[i] = i;
	        }
	    }
	    public int find(int x) {
	        if (parent[x] != x) parent[x] = find(parent[x]);
	        return parent[x];
	    }

	    public void union(int x, int y) {
	        int rootX = find(x);
	        int rootY = find(y);
	        if (rootX != rootY) {
	            if (rootX < rootY) {
	                parent[rootY] = rootX;
	            } else {
	                parent[rootX] = rootY;
	            }
	        }
	    }
	}
}
