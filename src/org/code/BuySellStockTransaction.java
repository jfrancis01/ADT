package org.code;

public class BuySellStockTransaction {

	public static void main(String[] args) {
		int[] prices = { 1, 3, 2, 8, 4, 9 };
		BuySellStockTransaction bsst = new BuySellStockTransaction();
		System.out.println(bsst.maxProfit(prices, 2));
	}

	public int maxProfit(int[] prices, int fee) {
		int start = 0;
		return maxProfitHelper(prices, fee, start);
	}

	private int maxProfitHelper(int[] prices, int fee, int start) {
		int max = 0;
		for (int i = start; i < prices.length; i++) {
			int total = 0;
			// buy here
			total += -1 * prices[i];
			// include transaction fee
			total += -fee;
			int profit;
			for (int j = i + 1; j < prices.length; j++) {
				profit = total + prices[j] + maxProfitHelper(prices, fee, j + 1);
				max = Math.max(profit, max);
			}
		}
		return max;
	}

}
