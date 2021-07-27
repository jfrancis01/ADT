package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CourseSchedule {

	private HashSet<Integer> visited = new HashSet<Integer>();
	
	public static void main(String[] args) {
		int numCourses = 5;
		int[][]prerequisites = //{{1,0}};
				//{{0, 1}, {1,0}}; 
				{{0,1}, {0,2},{1,3}, {1,4}, {3,4}};
		CourseSchedule cs = new CourseSchedule();
		System.out.println(cs.canFinish(numCourses, prerequisites));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, ArrayList<Integer>>preqMap = new HashMap<Integer, ArrayList<Integer>>();
		//for each node set the prequisites
		for(int i = 0; i < prerequisites.length; i++) {
			if(!preqMap.containsKey(prerequisites[i][0])) {
				ArrayList<Integer> adj = new ArrayList<Integer>();
				adj.add(prerequisites[i][1] );
				preqMap.put(prerequisites[i][0], adj);
			}
			else {
				ArrayList<Integer> adj = preqMap.get(prerequisites[i][0]);
				adj.add(prerequisites[i][1]);
				preqMap.put(prerequisites[i][0], adj);
			}
		}
		return canFinishHelper(numCourses, preqMap, new HashSet<Integer>()); 
	}
	
	private boolean canFinishHelper(int numCourses, HashMap<Integer, ArrayList<Integer>>preqMap, 
			HashSet<Integer> visiting) {
		//for each node in the list
		for(int v = 0; v < numCourses; v++) {
			boolean  ans = dfs(v, preqMap, visiting);
			if(!ans) {
				return false;
			}
		}
		return true;
	}
	
	private boolean dfs(int node, HashMap<Integer, ArrayList<Integer>>preqMap, 
			HashSet<Integer> visiting) {
		//if the node has been visited then return
		if(visiting.contains(node)) {
			return false;
		}
		if(visited.contains(node)) {
			return true;
		}
		else {
			//add it to the visiting list
			visiting.add(node);
			//retrieve the adjacency list of the node and visit the neighbours
			ArrayList<Integer> adjList = preqMap.get(node);
			if(adjList !=null) {
				for(int i  = 0; i < adjList.size();i++) {
					boolean ans = dfs(adjList.get(i), preqMap, visiting);
					if(!ans) {
						return false;
					}
					//after exploring remove the node from the list
					visited.add(adjList.get(i));
					visiting.remove(adjList.get(i));
				}
			}
			visiting.remove(node);//remove the node as it has been completely visited
			visited.add(node);
		}
		return true;
	}
}
