package org.code;

import java.util.Arrays;

public class FindingDoubleN {

	public boolean checkIfExist(int[] arr) {
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		for (int num = 0; num < arr.length; num++) {
			int target = arr[num] * 2;
			int j = binarySearch(arr, start, end, target);
			if (j != -1) {
				return true;
			}
		}
		return false;
	}

	public int binarySearch(int[] arr, int start, int end, int target) {
		int mid = start + (end - start) / 2;
		if (arr[mid] == target) {
			return mid;
		} else if (start > end) {
			return -1;
		} else if (target > arr[mid]) {
			return binarySearch(arr, mid + 1, end, target);
		} else {
			return binarySearch(arr, start, mid - 1, target);
		}
	}
	
	public static void main(String argv[]) {
		int[] arr = {10, 2, 5, 3};
		FindingDoubleN fdn = new FindingDoubleN();
		System.out.println(fdn.checkIfExist(arr));
	}

}
