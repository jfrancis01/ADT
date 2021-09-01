package org.code;

public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		int[] nums = {2,1,5,0,4,6};
		IncreasingTripletSubsequence lis = new IncreasingTripletSubsequence();
		System.out.println(lis.increasingTriplet(nums));
	}
	
	public boolean increasingTriplet(int[] nums) {
		if(nums.length < 3) return false;
		int left = Integer.MAX_VALUE;
		int mid = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] <= left) {
				left = nums[i];
			}
			else if(nums[i] > left &&  nums[i] <= mid) {
				mid = nums[i];
			}
			else {
				return true;
			}
		}
		return false;
	}
}
