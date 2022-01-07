package org.code;

public class SubArrays {

	public static void main(String[] args) {
		SubArrays suba = new SubArrays();
		int[] nums = { 1, 2, 3, 4 };
		//suba.printSubArrays(nums);
		suba.printSubArrays2(nums);
	}

	private void printSubArrays(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				for (int k = i; k <= j; k++) {
					System.out.print(nums[k] + " ");
				}
				System.out.println();
			}
		}
	}

	private void printSubArrays2(int[] nums) {
		int start = 0;
		int end = 0;
		String str = "";
		printSubArraysHelper(nums, start, end);
	}

	private void printSubArraysHelper(int[] nums, int start, int end) {
		if (end == nums.length) {
			return;
		} else if (start > end) {
			printSubArraysHelper(nums, 0, end + 1);
		} else {
			for (int i = start; i <= end; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			printSubArraysHelper(nums, start + 1, end);
		}
	}

}
