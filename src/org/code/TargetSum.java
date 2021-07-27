package org.code;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * I got the target sum working but it needs to give me unique combinations ex:
 * 1 7 only not 1 7 and 7 1
 * 
 * @author joel
 *
 */

public class TargetSum {

	public static void main(String argv[]) {
		int nums[] = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		int sum = 0;
		int start = 0;
		Arrays.sort(nums); //sorting helps not to get duplicate solutions
		findCombos(nums, target, start, sum, new ArrayList<Integer>());
	}

	public static void findCombos(int[] nums, int target, int start, int sum, ArrayList<Integer> combo) {
		if(sum == target) {
			for(int val: combo) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for( int i  = start; i < nums.length; i++) {
			if(sum + nums[i] > target || i >start && nums[i] == nums[i - 1]) {
				continue;
			}
			combo.add(nums[i]);
			findCombos(nums, target,i+1, sum + nums[i], combo);
			combo.remove(combo.size() - 1);
		}
		
	}

}
