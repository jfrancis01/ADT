package org.code;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintSubarrays {

	public static void main(String[] args) {
		int[] nums = {8,2,4,1};
		PrintSubarrays ps = new PrintSubarrays();
		ps.printSubArrays(nums);

	}

	public void printSubArrays(int[] nums) {
		for(int i  = 0; i < nums.length; i++) {
			for(int j = i; j < nums.length ;j ++) {
				for(int k = i; k <= j; k++) {
					System.out.print(nums[k] + " ");
				}
				System.out.println();
			}
		}
	}
}
