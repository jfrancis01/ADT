package org.code;

import java.util.HashMap;

public class HouseRobberII {

	/*
	 * 
	 * First, find the difference:From HRI, we already have the solution to a non
	 * circular houses, meaning we don't need to worry about the first and the
	 * last.For this problem, the only major thing that is different is that we have
	 * to worry about the first and the last. You want the first, leave the last.
	 * You want the last, leave the first.
	 * 
	 */

	public HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int withFirst = robHelper(nums, 0, nums.length - 1);
		map.clear();
		int withLast = robHelper(nums, 1, nums.length);

		return Math.max(withFirst, withLast);
	}

	public int robHelper(int[] nums, int start, int end) {
		if (map.containsKey(start)) {
			return map.get(start);
		}
		if (start >= end) {
			return 0;
		}

		int with = nums[start] + robHelper(nums, start + 2, end);
		int without = robHelper(nums, start + 1, end);

		int ans = Math.max(with, without);
		map.put(start, ans);

		return ans;
	}

	public static void main(String[] args) {

	}

}
