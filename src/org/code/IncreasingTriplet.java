package org.code;

public class IncreasingTriplet {

	public static void main(String[] args) {
		IncreasingTriplet it = new IncreasingTriplet();
		int[] nums = {1,5,0,4,1,3};
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
			}
			if(count >= 3)
			return true;
		}
		if (nums[index] > prev) {
			// consider it part of the sequence
			boolean with = helper(nums, n, nums[index], index + 1, count + 1);
			// don't consider it part of the seqeucne
			boolean without = helper(nums, n, prev, index + 1, count);
			if (with || without) {
				return true;
			}
		}
		return helper(nums, n, prev, index + 1, count);
	}

}
