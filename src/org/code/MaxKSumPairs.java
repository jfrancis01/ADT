package org.code;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxKSumPairs {

	public static void main(String[] args) {
		int[] nums = {2,2,2,3,1,1,4,1};
		int k = 4;
		MaxKSumPairs mksp = new MaxKSumPairs();
		System.out.println(mksp.maxOperations(nums, k));
	}

	public int maxOperations(int[] nums, int k) {
		int ops = 0;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i  = 0;  i < nums.length;  i++) {
			int diff = k - nums[i];
			if(map.containsKey(diff)) {
				ArrayList<Integer> indices = map.get(diff);
				if(indices.size()>0) {
					indices.remove(0);
					ops++;
				}
				else {
					indices.add(i);
					map.put(nums[i], indices);
				}
			}
			else {
				ArrayList<Integer> indexes = null;
				if(map.containsKey(nums[i])) {
					indexes = map.get(nums[i]);
					indexes.add(i);
				}
				else {
					indexes = new ArrayList<Integer>();
					indexes.add(i);
				}
				map.put(nums[i], indexes);
			}
		}
		return ops;
	}

}
