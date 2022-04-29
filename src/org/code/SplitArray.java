package org.code;

public class SplitArray {

	public static void main(String[] args) {
		int[] nums = {7,2,5,10,8};
		int m = 2;
		SplitArray sa = new SplitArray();
		System.out.println(sa.splitArray(nums, m));

	}

	public int splitArray(int[] nums, int m) {
		int start  = 0;
		int n = nums.length;
		return helper(start, nums, m, n);
	}
	
	private int helper(int start, int[] nums, int m, int n) {
		if(start >= n) {
			return Integer.MAX_VALUE;
		}
		if( m == 1) {
			return sum(start, nums, n);
		}
		int max = Integer.MAX_VALUE;
		int ans  = Integer.MAX_VALUE;
		int currentSum = 0;
		for(int i = start; i < n; i++ ) {
			currentSum+= nums[i];
			int rest = helper(start + 1, nums, m - 1, n);
			max = Math.max(currentSum, rest);
		}
		return Math.min(max, ans);
	}
	
	private int sum(int start, int[] nums, int n) {
		int sum  = 0;
		for(int i=0; i < n; i++) {
			sum+= nums[i];
		}
		return sum;
	}

}
