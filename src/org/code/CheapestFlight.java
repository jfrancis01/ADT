package org.code;

import java.util.Arrays;

public class CheapestFlight {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] prices = new int[n];
		// initialize all to to be infinity
		Arrays.fill(prices, Integer.MAX_VALUE);
		// initialize price of src to be 0 because we are starting from there!
		prices[src] = 0;
		for (int i = 0; i < k + 1; i++) {
			int[] tempPrices = prices.clone();
			for (int j = 0; j < flights.length; j++) {
				int s = flights[j][0];
				int d = flights[j][1];
				int p = flights[j][2];

				if (prices[s] == Integer.MAX_VALUE) {
					continue;
				}
				if (prices[s] + p < tempPrices[d]) {
					tempPrices[d] = prices[s] + p;
				}
			}
			prices = tempPrices;
		}
		return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
	}

}
