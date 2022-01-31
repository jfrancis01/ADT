package org.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GetMaximumScore {

	public static void main(String[] args) {
		int[] nums1 = { 4, 5, 8};
		int[] nums2 = { 4, 6, 8};
		
		GetMaximumScore gmx = new GetMaximumScore();
		System.out.println(gmx.maxSum(nums1, nums2));
	}

	public int maxSum(int[] nums1, int[] nums2) {
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, Integer> indegrees = new HashMap<Integer, Integer>();
		int length1 = nums1.length;
		int length2 = nums2.length;
		
		//iterate through the list and create the graph
		//create indegrees by adding children and increase their counts
		for (int i = 0; i < nums1.length - 1; i++) {
			if(!graph.containsKey(nums1[i])) {
				graph.put(nums1[i], new ArrayList<Integer>());
			}
			ArrayList<Integer> children = graph.get(nums1[i]);
			children.add(nums1[i + 1]);
			graph.put(nums1[i], children);
			
			if(!indegrees.containsKey(nums1[i])) {
				indegrees.put(nums1[i], 0);
			}
			
			if(!indegrees.containsKey(nums1[i + 1])) {
				indegrees.put(nums1[i + 1], 0);
			}
			indegrees.put(nums1[i+1], indegrees.get(nums1[i + 1]) + 1);
		}
		
		for (int i = 0; i < nums2.length - 1; i++) {
			if(!graph.containsKey(nums2[i])) {
				graph.put(nums2[i], new ArrayList<Integer>());
			}
			ArrayList<Integer> children = graph.get(nums2[i]);
			children.add(nums2[i + 1]);
			graph.put(nums2[i], children);
			
			if(!indegrees.containsKey(nums2[i])) {
				indegrees.put(nums2[i], 0);
			}
			
			
			if(!indegrees.containsKey(nums2[i + 1])) {
				indegrees.put(nums2[i + 1], 0);
			}
			indegrees.put(nums2[i+1], indegrees.get(nums2[i + 1]) + 1);
		}
		
		//here we run Kadane's Algorithm to start of the process
		//Go through the indegree's map and see which node has an indegree of 0
		//and add ALL of them to the queue
		class pqObj {
			long curr_sum = 0;
			int node = 0;
			
			public pqObj (long curr_sum, int node) {
				this.curr_sum = curr_sum;
				this.node = node;
			}
		}
		PriorityQueue<pqObj> queue = new PriorityQueue<pqObj>(new Comparator<pqObj>() {
			@Override
			public int compare (pqObj val1, pqObj val2) {
				 return val1.curr_sum < val2.curr_sum ?  -1: 1;
			}
		});
		for(Integer key : indegrees.keySet()) {
			if(indegrees.get(key) == 0) {
				queue.add(new pqObj(key,  key));
			}
		}
		long ans = 0;
		while(!queue.isEmpty()) {
			pqObj temp = queue.poll();
			ans = temp.curr_sum;
			ArrayList<Integer> children = graph.get(temp.node);
			if(children != null) {
				for(Integer child : children) {
					indegrees.put(child, indegrees.get(child) - 1);
					if(indegrees.get(child) == 0) {
						queue.add(new pqObj(child + temp.curr_sum, child));
					}
				}
			}
		}
		
		return (int) (ans % (Math.pow(10, 9) + 7));
	}
}
