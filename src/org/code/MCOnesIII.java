package org.code;

public class MCOnesIII {

	public static void main(String[] args) {
		MCOnesIII mcIII = new MCOnesIII();
		int[] nums = { 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1};
		int k = 2;
		System.out.println(mcIII.longestOnes(nums, k));
	}

	public int longestOnes(int[] nums, int k) {
		int max = 0;
		int left = 0;
		int zeros = 0;
		for (int right = 0; right < nums.length; right++) {
			if (nums[right] == 0) {
				zeros++;
			}
			while (zeros > k) {
				if (nums[left] == 0) {
					zeros--;
				}
				left++;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
	}

}
