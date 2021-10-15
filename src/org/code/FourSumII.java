package org.code;

import java.util.Arrays;

public class FourSumII {

	public static void main(String[] args) {
		int[] num1 = { -1, -1 };
		int[] nums2 = { -1, 1 };
		int[] nums3 = { -1, 1 };
		int[] nums4 = { 1, -1 };
		FourSumII fsumII = new FourSumII ();
		System.out.println("# of Tupples: " + fsumII.fourSumCount(nums4, nums2, nums3, nums4));
	}

	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Arrays.sort(nums3);
		Arrays.sort(nums4);
		int count = 0;
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int sum = nums1[i] + nums2[j];
				int target = -1 * sum;
				if (nums3[0] > nums4[0]) {
					int[] temp = nums4;
					nums4 = nums3;
					nums3 = temp;
				}
				int left = 0;
				int right = nums4.length - 1;

				while (left <= right) {
					int currentSum = nums3[left] + nums4[right];
					if (currentSum == target) {
						count++;
						left++;
						right--;
						while (left < right && nums3[left] == nums3[left - 1]) {
							left++;
						}
					} else if (currentSum < target) {
						left++;
					} else {
						right--;
					}
				}
				while (j + 1 < nums2.length && nums2[j] == nums2[j + 1]) {
					j++;
				}
			}
			while (i + 1 < nums1.length && nums2[i] == nums2[i + 1]) {
				i++;
			}
		}
		return count;
	}
}
