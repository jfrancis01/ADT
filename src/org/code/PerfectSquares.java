package org.code;

import java.util.ArrayList;
import java.util.Arrays;

public class PerfectSquares {

	public static void main(String[] args) {
		PerfectSquares sq = new PerfectSquares();
		int n = 13;
		System.out.println(sq.numSquares(n));
	}

	public int numSquares(int n) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i < Math.sqrt(n); i++) {
			nums.add(i * i);
		}
		int[]cache = new int[n + 1];
		Arrays.fill(cache, Integer.MAX_VALUE);
		return helper(n, nums, cache);
	}
	public int helper(int n , ArrayList<Integer>nums, int[]cache) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(cache[n] != Integer.MAX_VALUE) {
			return cache[n];
		}
		int count = Integer.MAX_VALUE;
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i) <= n ) {
				int current =  1 + helper(n - nums.get(i), nums, cache);
				count = Math.min(current, count);
			}
		}
		cache[n] = count;
		return count;
	}

}
