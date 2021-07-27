package org.code;

/**
 * Find the minimum number of coins that sum to a given amount coins = {1, 5,
 * 10, 25} target = 6 Ans: 2 coins are required
 * 
 * @author joel
 *
 */

public class MinCoins {

	public static void main(String[] argv) {
		int minCoins = Integer.MAX_VALUE;
		int[] coins = { 1, 5, 10, 25 };
		System.out.println(makeChange(coins, 32, minCoins, 0));
	}

	public static int makeChange(int[] coins, int target, int minCoins, int currentCoins) {

		if (target == 0) {
			return currentCoins;
		}

		for (int coin : coins) {
			// choose
			if (target - coin >= 0) {
				// explore
				currentCoins++;
				int usedCoins = makeChange(coins, target - coin, minCoins, currentCoins);
				if (usedCoins < minCoins) {
					minCoins = usedCoins;
				}
				// reduce the number of coins used
				currentCoins = currentCoins - 1;
			}
		}
		return minCoins;
	}

}
