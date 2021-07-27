package org.code;

import java.util.ArrayList;
import java.util.Arrays;

public class SimplePermutation {
	public static void main(String argv[]) {
		int[] nums = {1,2,3};
		printPermutations(nums, new ArrayList<Integer>(), new boolean[nums.length]);
	}
	public static void printPermutations(int[] nums, ArrayList<Integer>combo, boolean[] used) {
		if(combo.size() == nums.length) {
			for(int val: combo) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < nums.length;i++) {
			if(!used[i]){
				used[i] = true;
				combo.add(nums[i]);
				printPermutations(nums, combo, used);
				combo.remove(combo.size() - 1);
				used[i] = false;
			}
		}
	}
}
