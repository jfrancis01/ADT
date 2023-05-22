package org.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PathsSourceToTarget {

	public static void main(String[] args) {
		int graph[][] = new int[][] {{1,2},{3},{3},{}};
		PathsSourceToTarget pst = new PathsSourceToTarget();
		List<List<Integer>> ans = pst.allPathsSourceTarget(graph);
		System.out.println(ans);
	} 

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		path.add(0);//add a node to the path and offer it to the queue
		queue.offer(path);
		while(!queue.isEmpty()) {
			List<Integer> current = queue.poll();
			int val = current.get(current.size()-1);
			for(int neighbour : graph[val]) {
				List<Integer> foundPath = new ArrayList<>(current);
				foundPath.add(neighbour);
				if(neighbour == graph.length - 1) {
					ans.add(foundPath);
				}
				else {
					queue.offer(foundPath);
				}
			}
		}
		return ans;
	}
}
