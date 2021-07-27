package org.code;

public class MinCoinsDynamic {
	
	public static void main(String[] argv) {
		int[] coins = { 1, 4, 9};
		int target = 12;
		int[] cache = new int[target + 1];
		for(int i = 1; i < target + 1; i ++) {
			cache[i] = Integer.MAX_VALUE;
		}
		makeChange(coins, target, cache);
		
		System.out.println(Long.MAX_VALUE);
		
	}
	
	public static void makeChange(int[] coins, int target, int[] cache) {
		
		for(int subproblem = 1; subproblem <= target; subproblem++) {
			for(int coin: coins) {
				if(subproblem - coin >= 0) {
					cache[subproblem] = Math.min(cache[subproblem - coin] + 1, cache[subproblem]);
				}
			}
		}
		
		System.out.println(cache[target]);
	}
}
