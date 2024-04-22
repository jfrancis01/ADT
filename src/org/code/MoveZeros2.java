package org.code;

import java.util.Arrays;

public class MoveZeros2 {

	public static void main(String[] args) {
		int[] nums = {0,1,0, 3, 12};
		MoveZeros2 mz2 = new MoveZeros2();
		mz2.moveZeroes(nums);
		Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
	}

	public void moveZeroes(int[] nums) {
		int left = 0;
		int index = 0;
		while (left < nums.length) {
			while (left < nums.length && nums[left] != 0) {
				left++;
			}
			index = left + 1;
			while (index < nums.length && nums[index] == 0) {
				index++;
			}
			if (left < nums.length && index < nums.length) {
				nums[left] = nums[index];
				nums[index] = 0;
			}
			left++;
		}
	}

}
