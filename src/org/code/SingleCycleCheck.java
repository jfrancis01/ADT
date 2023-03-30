package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SingleCycleCheck {

	public static void main(String[] args) {
		int[] nums = { 10, 11, -6, -23, -2, 3, 88, 908, -26};
		SingleCycleCheck scc = new SingleCycleCheck();
		System.out.println(scc.hasSingleCycle(nums));
	}

	public static boolean hasSingleCycle(int[] nums) {
		int length = nums.length;
		HashMap<Integer, Integer> adjList = new HashMap<Integer, Integer>();
		// first create the Nodes
		for (int i = 0; i < length; i++) {
			adjList.put(i, -1);
		}
		// traverse through the array and start adding edges
		for (int i = 0; i < length; i++) {
			int jump = 0;
			if(nums[i] <  0) {
				jump = (i +  (length - (Math.abs(nums[i])% length)))%length;
			}
			else {
				jump = (i + nums[i]) % length;
			}
			// add the edge to the adjaceny list
			adjList.put(i, jump);
		}
		Set<Integer> visited = new HashSet<Integer>();
		// let's select a node to start from
		int start = 0;
		int temp = start;
		int next = -1;
		visited.add(start);
		while (visited.size() < length) {// while not nodes have been visited
			next = adjList.get(start);
			boolean add = visited.add(next);
			if (!add) {
				break;
			}
			start = next;
		}
		//check if all nodes have been visited and 
		if(visited.size() == nums.length && adjList.get(next) == temp) {
			return true;
		}
		return false;
	}
}
