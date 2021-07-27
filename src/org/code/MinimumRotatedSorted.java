package org.code;

public class MinimumRotatedSorted {
	
	public static void main(String argv[]) {
		int[] nums = { 3, 4, 5, 1, 2};
		MinimumRotatedSorted mrs = new MinimumRotatedSorted();
		System.out.println(mrs.findMin(nums));
	}
	
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while(left + 1 < right) {
			mid = left + (right - left)/2;
			if(nums[mid] > nums[right]) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
		return Math.min(nums[left], nums[right]);
	}
}
