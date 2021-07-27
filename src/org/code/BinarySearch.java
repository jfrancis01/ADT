package org.code;

public class BinarySearch {
	
	public static void main(String argv[]) {
		//int[] nums = {1, 2, 3, 4, 10, 20, 90, 100, 112, 130, 199};
		//int[] nums = {4,5,6,7,0,1,2};
		int[] nums = {1, 3};
		//int[] nums = {3, 5, 1};
		//int[] nums = {1};
		int target = 1;
		//System.out.println("Found: " + binarysearch(nums, target));
		System.out.println("Found: " + search(nums, target));
		
	}

	private static int binarysearch(int[] nums, int target) {
		return binarySearchHelper(nums, target, 0, nums.length - 1);
	}

	private static int binarySearchHelper(int[] nums, int target, int start, int end) {
		if(end >= start) {
			int mid = start + (end - start)/2;
			if(nums[mid] == target) return mid;
			if(nums[mid] > target) return binarySearchHelper(nums, target, start, mid - 1);
			return binarySearchHelper(nums, target, mid + 1, end);
		}
		return - 1;
	}
	
	public static int search(int[] nums, int target) {
		//first find the pivot point and then run binary search of the two segements
		if(nums.length == 1) {
			if(nums[0] == target) return 0;
			else return -1;
		}
		int i = 0;
		int left = -1;
		int right = -1;
		boolean inOrder = true;
		for(i = 0; i < nums. length-1; i++) {
			if(!(nums[i] <  nums[i+1])) {
				left = binarySearchHelper(nums, target, 0, i);
				inOrder = false;
				break;
			}
		}
		if(inOrder) {
			right = binarySearchHelper(nums, target, 0, nums.length - 1);
		}
		else {
			right = binarySearchHelper(nums, target, i + 1, nums.length - 1);
		}
		
		if(left == - 1 && right == -1) {
			return -1;
		}
		else if(left !=-1) {
			return left;
		}
		return right;
    }

}
