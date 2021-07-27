package org.code;

import java.util.HashMap;

/**
 * This is a memoization approach where you cache already computed answers.
 * However true Dynamic Programming is an iterative caching solution, where you
 * solve the smaller sub problems before you get the solution to the targeted
 * problem
 * 
 * @author joel
 *
 */

public class MinCoinsMemoization {

	public static void main(String[] argv) {
		int target = 6249;
		int[] coins = { 186, 419, 83, 408 };// {1,5,6,9};//{1, 3, 9, 19, 26 };//{3};
		int[] cache = new int[target + 1];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i <=target; i++) {
			map.put(Integer.valueOf(i), Integer.MAX_VALUE);
		}

		// initialize the cache
		for (int i = 1; i < target + 1; i++) {
			cache[i] = -1;
		}
		System.out.println("Top-down approach: " + makeChangeTopDown(coins, target, cache));
		// initialize the cache
		for (int i = 1; i < target + 1; i++) {
			cache[i] = -1;
		}
		System.out.println(
				"Bottom-up backtracking: " + makeChangeBacktracking(0, coins, target, 0, Integer.MAX_VALUE, cache));

		System.out.println("Simon's Algo: " + makeChangeSimon(target, coins, target, 0, Integer.MAX_VALUE, map));
		for (int i = 0; i < target; i++) {
			System.out.println("count: " + i + ": " + map.get(i));
		}
	}

	public static int makeChangeTopDown(int[] coins, int target, int[] cache) {

		int minCoins = Integer.MAX_VALUE;

		// base case - if the value is 0 then return zero
		if (cache[target] > -1) {
			return cache[target];
		}

		for (int coin : coins) {

			// this subtraction means that we used the coin
			if (target - coin >= 0) {
				int c = makeChangeTopDown(coins, target - coin, cache);
				if (minCoins > c + 1) {
					minCoins = c + 1;
				}
			}
		}
		cache[target] = minCoins;
		return minCoins;

	}

	public static int makeChangeBacktracking(int sum, int[] coins, int target, int count, int minCoins, int[] cache) {

		if (sum == target)
			return count;

		for (int coin : coins) {
			// choose
			sum += coin;
			// explore
			if (sum <= target) { // if it is greater than the target then why recurse???
				int c = makeChangeBacktracking(sum, coins, target, count + 1, minCoins, cache);
				if (minCoins > c) {
					minCoins = c;
				}
				// undo
				sum -= coin;
			}
		}
		return minCoins;
	}

	public static int makeChangeSimon(int sum, int[] coins, int target, int count, int minCoins,
			HashMap<Integer, Integer> map) {

		if (sum == 0) {
			return count;
		}

		if (map.get(Integer.valueOf(sum)) < Integer.MAX_VALUE) {
			return map.get(Integer.valueOf(sum));
		}

		for (int coin : coins) {

			if (target - coin >= 0) {
				int c = makeChangeSimon(target - coin, coins, target, count + 1, minCoins, map);
				minCoins = (c < minCoins) ? c : minCoins;
			}
		}
		//if (minCoins < map.get(Integer.valueOf(sum))) {
			map.put(Integer.valueOf(sum), Integer.valueOf(minCoins));
		//}
		return minCoins;
	}

}
