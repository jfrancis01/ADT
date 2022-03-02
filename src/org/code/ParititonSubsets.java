package org.code;

import java.util.Arrays;

public class ParititonSubsets {

	public static void main(String[] args) {
		int[] nums = { 1, 5, 5, 11 };
		ParititonSubsets ps = new ParititonSubsets();
		System.out.println(ps.canPartition(nums));
	}

	public boolean canPartition(int[] nums) {
		int start = 0;
		return helper(nums, start, 0, 0);
	}

	public boolean helper(int[] nums, int start, int sumWith, int sumWithout) {
		if (start >= nums.length) {
			if (sumWith == sumWithout) {
				return true;
			}
			return false;
		}
		if (helper(nums, start + 1, sumWith + nums[start], sumWithout)
				|| helper(nums, start + 1, sumWith, sumWithout + nums[start])) {
			return true;
		}
		return false;
	}

}
