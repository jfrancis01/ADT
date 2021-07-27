package org.code;

import java.util.ArrayList;

public class GenerateSubsequence {
	
	public static void main(String argv[]) {
		int[] nums = {1, 2, 3};
		generateSubsequence(nums);
	}
	public static void generateSubsequence(int[] nums) {
		generateHelper(nums, 0, nums.length, new ArrayList<Integer>());
	}
	
	/*
	 * This code will give you all the possible subsequences
	 **/
	
	public static void generateHelper(int[] nums, int start,  int end, ArrayList<Integer> combo) {
		if(start >=end) {
			for(int i = 0; i < combo.size();i++) {
				System.out.print(combo.get(i) +  " ");
			}
			System.out.println();
			return;
		}
		int val = nums[start];
		combo.add(val);
		generateHelper(nums, start+1, end, combo);
		combo.remove(combo.size() - 1);
		generateHelper(nums, start + 1, end, combo);
	}
}
