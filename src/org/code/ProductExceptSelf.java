package org.code;

public class ProductExceptSelf {
	
	public static void main (String argv[]) {
		int[] nums = {1, 2, 3, 4};
		int[] reverse = new int[nums.length];
		int[] output = new int [nums.length];
		
		int index = nums.length - 1;
		for(int i = 0 ; i < nums.length; i++) {
			 reverse[i] = nums[index];
			 index--;
		}
		productExceptSelf(nums, reverse, output);
	}
	
	public static void productExceptSelf(int[] nums, int[] reverse, int[] output) {
		for(int index = 0; index < nums.length; index++) {// for each number
			int forward = 1;
			int backward = 1;
			int i = index + 1;
			int j = nums.length - 1 - index + 1;
			while( i <= nums.length - 1 ) {
				forward *= nums[i];
				i++;
			}
			while(j <= nums.length - 1) {
				backward *= reverse[j];
				j++;
			}
			output[index] = forward * backward;
		}
		
		for(int k = 0 ; k < nums.length; k++) {
			System.out.print(output[k] + " ");
		}
	}
	

}
