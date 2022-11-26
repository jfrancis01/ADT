package org.code;

public class NotPossibleChange {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		NotPossibleChange npc = new NotPossibleChange();
		System.out.println(npc.nonConstructibleChange(coins));

	}

	public int nonConstructibleChange(int[] coins) {
		int total = 0;
		if (coins == null || coins.length == 0) {
			return 1;
		}
		for (int i = 0; i < coins.length; i++) {
			total += coins[i];
		}

		for (int amount = 1; amount <= total + 1; amount++) {
			int start = 0;
			long ans = makeChange(coins, amount, start);
			if (ans >= Integer.MAX_VALUE) {
				return amount;
			}
		}
		// should never come here
		return -1;
	}

	private long makeChange(int[] coins, int amount, int start) {
		if (amount == 0) {
			return 0;
		}
		if (start >= coins.length) {
			return Integer.MAX_VALUE;
		}
		long minCoins = Integer.MAX_VALUE;
		for (int i = start; i < coins.length; i++) {
			if (amount - coins[i] >= 0) {
				long count = makeChange(coins, amount - coins[i], i + 1);
				minCoins = Math.min(minCoins, count + 1);
			}
		}

		return minCoins;
	}

}
