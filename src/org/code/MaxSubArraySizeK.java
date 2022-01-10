package org.code;

public class MaxSubArraySizeK {

	private int max = Integer.MIN_VALUE;
	private int smallestSize = Integer.MAX_VALUE;

	public static void main(String[] args) {
		MaxSubArraySizeK maxsubk = new MaxSubArraySizeK();
		int k = 3;
		int target = 8;
		int[] nums = {4, 2, 2, 7, 8, 1, 2, 8, 1, 0 };
		maxsubk.maxSubArraySizeK(nums, 4);
		System.out.println(maxsubk.max);
		maxsubk.smallestSumSubArray(nums, target);
		System.out.println(maxsubk.smallestSize);
	}

	public void maxSubArraySizeK(int[] nums, int k) {
		int length = nums.length;
		int start = 0;
		int end = 0;
		int sum = 0;
		int count = 0;
		while (start < length) {
			while (end < length) {
				sum += nums[end];
				++count;
				if (count == k) {
					max = Math.max(sum, max);
					sum -= nums[start];
					--count;
					end++;
					break;
				}
				end++;
			}
			start++;
		}
	}
	
	public void smallestSumSubArray(int nums[], int target) {
		int start = 0;
		int end = 0;
		int sum  = 0;
		for(end = 0; end < nums.length; end++) {
			sum+= nums[end];
			while(sum >= target) {
				int window = end- start + 1;
				smallestSize = Math.min(smallestSize, window);
				sum-= nums[start];
				start++;
			}
		}
	}

}
