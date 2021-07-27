package org.code;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		int index = nums.length - 2;
		while(index >= 0 && nums[index] >= nums[index + 1] ) {
			index--;
		}
		
		if(index != - 1) {
			for(int i = nums.length - 1; i >index; i--) {
				if(nums[i] > nums[index]) {
					swap(i, index, nums);
					break;
				}
			}
		}
		
		reverse(index + 1, nums.length - 1, nums);
	}
	
	public void reverse(int start, int end, int[] nums) {
		while(start < end) {
			swap(start, end, nums);
			start++;
			end--;
		}
	}
	
	public void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String argv[]) {
		int[] nums = {1,3,5,4,2};
		NextPermutation np = new NextPermutation();
		np.nextPermutation(nums);
		for(int val: nums) {
			System.out.print(val + " ");
		}
	}
}
