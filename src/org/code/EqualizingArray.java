package org.code;

import java.util.HashMap;

public class EqualizingArray {

	public static void main(String[] args) {
		int[] nums = {64,32,16};
		int k = 3;
		int d = 2;
		System.out.println(getMinimumMoves(nums, d, k));
	}

	public static int getMinimumMoves(int[] nums, int d, int k) {
		int start = 0;
		return getMinimumMovesHelper(start, nums, d, k);
	}

	public static int getMinimumMovesHelper(int start, int[] nums, int d, int k) {
		if (equalized(nums, k)) {
			return 0;
		}
		if (start >= nums.length) {
			return 2;
		}
		int with = Integer.MAX_VALUE;
		int without = Integer.MAX_VALUE;
		int val = nums[start];
		nums[start] = nums[start] / 2;
		with = 1 + getMinimumMovesHelper(start + 1, nums, d, k);
		nums[start] = val;
		without = getMinimumMovesHelper(start + 1, nums, d, k);

		return Math.min(with, without);

	}

	public static boolean equalized(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int val : nums) {
			if (!map.containsKey(val)) {
				map.put(val, 1);
			} else {
				map.put(val, map.get(val) + 1);
				if (map.get(val) >= k) {
					return true;
				}
			}
		}
		return false;
	}
}
