package org.code;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] nums = {3, 7, 5, 6, 4, 2, 1, 0, 8};
		MergeSort ms = new MergeSort();
		ms.mergeSort(nums);
		Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
	}
	
	public void mergeSort(int[] nums) {
		int[] temp = new int[nums.length];
		int leftStart = 0;
		int rightEnd = nums.length - 1;
		mergeSort(nums, leftStart, rightEnd, temp);
	}
	
	private void mergeSort(int[] nums, int leftStart, int rightEnd, int[] temp) {
		if(leftStart >= rightEnd) {
			return;
		}
		int middle = (rightEnd + leftStart)/2;
		mergeSort(nums, leftStart, middle, temp);
		mergeSort(nums, middle + 1, rightEnd, temp);
		merge(nums, leftStart, rightEnd, temp);
	}
	
	private void merge(int[] nums, int leftStart, int rightEnd, int[] temp) {
		int leftEnd = (rightEnd + leftStart)/2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		int index = leftStart;
		
		int left = leftStart;
		int right = rightStart;
		while( left <= leftEnd && right <= rightEnd) {
			if(nums[left] <= nums[right]) {
				temp[index++] = nums[left];
				left++;
			}
			else {
				temp[index++] = nums[right];
				right++;
			}
		}
		System.arraycopy(nums, left, temp, index, leftEnd - left + 1);
		System.arraycopy(nums, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, nums, leftStart, size);
	}

}
