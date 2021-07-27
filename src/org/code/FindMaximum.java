package org.code;

public class FindMaximum {
	
	public static void main(String argv[]) {
		int[] nums = { 4,3,6,7,0,9,2};
		int max = Integer.MIN_VALUE;
		System.out.println("Max: " + findMax(1, max, nums));
	}
	
	public static int findMax(int start, int max, int[] nums) {
		if(start >= nums.length - 1) {
			return max;
		}
		if(nums[start] > max ) {
			max = nums[start];
		}
		max  = findMax(start + 1, max, nums);
		return max;
	}
}
