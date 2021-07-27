package org.code;

import java.util.ArrayList;
import java.util.HashMap;

public class CoinWays {
	
	
	public static void main(String argv[]) {
		int coins[] = {1,2,5};
		int amount = 5;
		CoinWays cw = new CoinWays();
		System.out.println("Total Ways: " + cw.coinWays(coins, amount));
	}
	
	public int coinWays(int[] coins, int amount) {
		int start = 0;
		int[][]cache = new int[amount + 1][coins.length];
		return coinWaysHelper(coins, amount, start, new ArrayList<Integer>(), cache);
	}
	
	public int coinWaysHelper(int[] coins, int amount, int start, ArrayList<Integer>combo, int[][] cache) {
	
		if(amount == 0) {
			for(int val: combo) {
				System.out.print(val + " ");
			}
			System.out.println();
			return 1;
		}
		if(cache[amount][start] != 0) {
			return cache[amount][start]; 
		}
		int count = 0;
		for(int i = start; i < coins.length;i++) {
			if(coins[i] <= amount) {
				combo.add(coins[i]);
				count+= coinWaysHelper(coins, amount - coins[i], i, combo, cache);
				combo.remove(combo.size() - 1);
			}
		}
		cache[amount][start] = count;
		return count;
	}
}
