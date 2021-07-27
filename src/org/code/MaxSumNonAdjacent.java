package org.code;

import java.util.HashMap;

public class MaxSumNonAdjacent {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };// {2,7,9,3,1};
		MaxSumNonAdjacent maxSum = new MaxSumNonAdjacent();
		System.out.println(maxSum.maxSum(nums));
	}

	public int maxSum(int[] nums) {
		int start = 0;
		HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();
		return maxSumHelper(nums, start, cache);
	}

	public int maxSumHelper(int[] nums, int start, HashMap<Integer, Integer> cache) {
		if (start >= nums.length) {
			return 0;
		}
		if (cache.containsKey(start)) {
			return cache.get(start);
		}
		int max = Math.max(maxSumHelper(nums, start + 1, cache), nums[start] + maxSumHelper(nums, start + 2, cache));
		cache.put(start, max);
		return max;
	}

}
