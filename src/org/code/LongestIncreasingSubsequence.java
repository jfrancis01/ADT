package org.code;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 4, 6, 7 };
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		int start = 0;
		//lengthOfLISHelper(nums, start, Integer.MIN_VALUE, new ArrayList<Integer>());
		return lenghtOfLISHelper(nums, start, Integer.MIN_VALUE);
	}

	public void lengthOfLISHelper(int[] nums, int start, int prev, ArrayList<Integer> combo) {
		if (start >= nums.length) {
			if (combo.size() > 1) {
				for (int val : combo) {
					System.out.print(val + " ");
				}
				System.out.println();
			}
			return;
		}
		if (nums[start] > prev) {
			combo.add(nums[start]);
			lengthOfLISHelper(nums, start + 1, nums[start], combo);
			combo.remove(combo.size() - 1);
			lengthOfLISHelper(nums, start + 1, prev, combo);
		} 
		else {
			lengthOfLISHelper(nums, start + 1, prev, combo);
		}
	}
	
	public int lenghtOfLISHelper(int[] nums, int start, int prev) {
		if(start >= nums.length)return 0;
		int with = 0;
		if(nums[start] > prev) {
			with = 1 + lenghtOfLISHelper(nums, start + 1, nums[start]);
		}
		int without = lenghtOfLISHelper(nums, start + 1, prev);
		return Math.max(with, without);
	}
}
