package org.code;

public class SamsCoinChange {

	private static int[] coins = new int[] { 2 };
	private static int[] cache;

	public static void main(String[] argv){
		int ans = makeChange(3);
		System.out.println(ans);
	}

	public static int makeChange(int c) {
		// Initialize cache with values as -1
		cache = new int[c + 1];
		for (int i = 1; i < c + 1; i++)
			cache[i] = -1;
		return makeChange(c, cache);
	}

	// Overloaded recursive function
	private static int makeChange(int c, int[] cache) {
		// Return the value if it’s in the cache
		if (cache[c] >= 0)
			return cache[c];
		int minCoins = Integer.MAX_VALUE;
		// Find the best coin
		for (int coin : coins) {
			if (c - coin >= 0) {
				int currMinCoins = makeChange(c - coin, cache);
				if (currMinCoins < minCoins)
					minCoins = currMinCoins;
			}
		}
		// Save the value into the cache
		cache[c] = minCoins + 1;
		return cache[c];
	}
}
