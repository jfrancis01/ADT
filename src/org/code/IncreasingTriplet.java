package org.code;

public class IncreasingTriplet {

	public static void main(String[] args) {
		IncreasingTriplet it = new IncreasingTriplet();
		int[] nums = { 1, 5, 0, 4, 1, 3 };
		System.out.println(it.increasingTriplet(nums));
	}

	public boolean increasingTriplet(int[] nums) {
		// if there are less than 3 numbers return false;
		if (nums.length < 3)
			return false;
		return helper(nums, nums.length, Integer.MIN_VALUE, 0, 0);
	}

	private boolean helper(int[] nums, int n, int prev, int index, int count) {
		if (index >= n) {
			if (count < 3) {
				return false;
			} else if (count == 3) {
				return true;
			}
			return false;
		} else if (count == 3) {
			return true;
		} else if (count > 3) {
			return false;
		}
		if (nums[index] > prev) {
			if (helper(nums, n, nums[index], index + 1, count + 1) || helper(nums, n, prev, index + 1, count)) {
				return true;
			}
			return false;
		}
		return helper(nums, n, prev, index + 1, count);
	}

}
