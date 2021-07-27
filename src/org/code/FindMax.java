package org.code;

public class FindMax {

	public static void main(String[] args) {
		int nums[] = { -10, -26, 43, 5, 6 , 12 ,1, 2,-71, 18};
		int max = Integer.MIN_VALUE;
		System.out.println(findMax(nums.length - 1, nums));
	}
	public static int findMax(int start, int[] nums) {
		if(start == 0) {
			return nums[0];
		}
		//look at this recurrence relatuion
		//breaks down the problem in to sub problems
		//works towards the base case
		return Math.max(nums[start], findMax(start - 1, nums));
	}
}
