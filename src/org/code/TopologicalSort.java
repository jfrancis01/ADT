package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TopologicalSort {

	public static void main(String[] args) {
		TopologicalSort ts = new TopologicalSort();
		List<Integer> jobs = new ArrayList<Integer>();
		jobs.add(1);
		jobs.add(2);
		jobs.add(3);
		jobs.add(4);
		List<Integer[]> deps = new ArrayList<Integer[]>();
		deps.add(new Integer[] {1,2});
		deps.add(new Integer[] {1,3});
		deps.add(new Integer[] {3,2});
		deps.add(new Integer[] {4,2});
		deps.add(new Integer[] {4,3});
		List<Integer> ans = ts.topologicalSort(jobs, deps);
		ans.stream().forEach(x->System.out.print(x));

	}

	public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
		int n = jobs.size();
		List<Integer> ans = new ArrayList<Integer>();
		HashMap<Integer, Integer> indegrees = new HashMap<Integer, Integer>();
		// First build the graph
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			graph.put(jobs.get(i), new ArrayList<Integer>());
			indegrees.put(jobs.get(i), 0);
		}
		
		// Assign the indegrees
		for (Integer[] connection : deps) {
			ArrayList<Integer> conns = graph.get(connection[0]);
			conns.add(connection[1]);
			indegrees.put(connection[1], indegrees.get(connection[1]) + 1);
		}
		
		while (!indegrees.isEmpty()) {
			int start = -1;
			// Find the first node with indegrees 0 and add it to the queue
			Set<Integer>keys = indegrees.keySet();
			for(int key : keys) {
				if(indegrees.get(key) == 0) {
					start = key;
					break;
				}
			}
			if(start == -1) {
				ans = new ArrayList<Integer>();
				return ans;// there is a cycle
			}
			ans.add(start);
			//remove the 0 indegree node 
			indegrees.remove(start);
			//get all the neighbours and reduce their indegrees by 1
			ArrayList<Integer> vertices = graph.get(start);
			for(int v : vertices) {
				indegrees.put(v, indegrees.get(v) - 1);
			}
		}
		return ans;
	}

}
