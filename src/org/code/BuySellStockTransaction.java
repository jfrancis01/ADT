package org.code;

import java.util.Arrays;

public class BuySellStockTransaction {

	public static void main(String[] args) {
		int[] prices = { 1,3,2,8,4,9 };
		BuySellStockTransaction bsst = new BuySellStockTransaction();
		System.out.println(bsst.maxProfit(prices, 2));
	}

	public int maxProfit(int[] prices, int fee) {
		int start = 0;
		int size = prices.length;
		int[]cache = new int[size + 1];
		Arrays.fill(cache, -1);
		return maxProfitHelper(prices, fee, start, cache);
	}

	private int maxProfitHelper(int[] prices, int fee, int start, int[]cache) {
		int max = 0;
		if(cache[start] != -1) {
			return cache[start];
		}
		for (int i = start; i < prices.length; i++) {
			int total = 0;
			// buy here
			total += -1 * prices[i];
			// include transaction fee
			total += -fee;
			int profit;
			for (int j = i + 1; j < prices.length; j++) {
				//sell here and then do another transaction
				profit = total + prices[j] + maxProfitHelper(prices, fee, j + 1, cache);
				//save the maximum 
				max = Math.max(profit, max);
			}
		}
		cache[start] = max;
		return cache[start];
	}

}
