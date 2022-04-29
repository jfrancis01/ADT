package org.code;

public class SplitArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		int m = 2;
		SplitArray sa = new SplitArray();
		System.out.println(sa.splitArray(nums, m));

	}

	public int splitArray(int[] nums, int m) {
		int start  = 0;
		int n = nums.length;
		int[][] cache = new int[n + 1][ m + 1];
		for(int i  = 0; i < cache.length; i++) {
			for(int j  = 0; j < cache[0].length; j ++) {
				cache[i][j] = -1;
			}
		}
		cache[0][0] = 0;
		return helper(start, nums, m, n, cache);
	}
	
	private int helper(int start, int[] nums, int m, int n, int[][]cache) {
		//base cases
		if(m == 0 &&  start >= n) {
			return 0;
		}
		if(m == 0 || start >= n) {
			return Integer.MAX_VALUE;
		}
		if(cache[start][m] != -1) {
			return cache[start][m];
		}
		int max = Integer.MIN_VALUE;
		int ans  = Integer.MAX_VALUE;
		int currentSum = 0;
		for(int i = start; i < n; i++ ) {
			currentSum+= nums[i];
			int rest = helper(i + 1, nums, m - 1, n, cache);
			max = Math.max(currentSum, rest);
			ans = Math.min(max, ans);
		}
		cache[start][m] = ans;
		return ans;
	}
	
	private int sum(int start, int[] nums, int n) {
		int sum  = 0;
		for(int i=0; i < n; i++) {
			sum+= nums[i];
		}
		return sum;
	}

}
