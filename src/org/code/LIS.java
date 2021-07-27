package org.code;

import java.util.HashMap;

public class LIS {

	public static void main(String[] args) {
		int[] nums = {1,2,4,3};// { 10, 9, 2, 5, 3, 7, 101, 18 };// {7,7,7,7,7}; //{2,1,3,4,5};
									// //{0,3,1,6,2,2,7};
		LIS lis = new LIS();
		System.out.println(lis.lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		int start = 0;
		int prev = Integer.MIN_VALUE;
		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
		return LISHelper(nums, start, prev, cache);
	}

	public int LISHelper(int[] nums, int start, int prev, HashMap<Integer, Integer> cache) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		if (start >= nums.length) {
			return 0;
		}

		if (cache.containsKey(start)) {
		//	return cache.get(start);
		}

		int with = 0;
		//int without = 0;
		if (nums[start] > prev) {
			with = 1 + LISHelper(nums, start + 1, nums[start], cache);
		}
		int without = LISHelper(nums, start + 1, prev, cache);
		int max = Math.max(with, without);
		cache.put(start, max);
		return max;
	}
}
