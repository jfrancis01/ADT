package org.code;

import java.util.Arrays;

public class ClimbStairs {

	public static void main(String[] args) {
		int n = 2;
		ClimbStairs cs = new ClimbStairs();
		System.out.println(cs.climbStairs(n));
	}
	
	public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
		int[] cache = new int[n + 1];
		Arrays.fill(cache, -1);
		cache[0] = 0;
		cache[1] = 1;
		cache[2] = 2;
        return helper(n, 0, cache);
    }
	
	public int helper(int n, int i, int[] cache) {
		if(i > n ) return 0;
		if(cache[n - i] != -1) return cache[n-i];
		if(i == n) return 1;
		int onestep = 0;
		int twostep = 0;
		onestep+= helper(n, i + 1, cache);
		twostep+= helper(n, i + 2, cache);
		cache[n-i] = onestep + twostep;
		return onestep + twostep;
	}
}
