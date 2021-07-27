package org.code;

public class KnapSack {
	private static int maxProfit = Integer.MIN_VALUE;

	public static void main(String[] argv) {
		int[] values = { 4, 14, 10, 5 };
		int[] weights = { 3, 7, 10, 6 };
		int capacity = 20;

		knapSack(weights, values, capacity);
		System.out.println("Max Profit: " + maxProfit);
		maxProfit = Integer.MIN_VALUE;
		System.out.println("Max Profit: " + knapSack2(weights, values, capacity));
		KSIterative(weights, values, capacity);
	}

	public static void knapSack(int[] weights, int[] values, int capacity) {
		knapSackHelper(weights, values, capacity, 0, 0, 0);
	}
	
	public static int knapSack2(int[] weights, int[] values, int capacity) {
		int[][] cache = new int[capacity + 1][weights.length];
		for(int i = 0; i< cache.length; i++) {
			for(int j = 0; j< cache[0].length;j++ ) {
				cache[i][j]  = -1;
			}
		}
		return knapSackHelper2(weights, values,capacity, weights.length - 1, cache);
	}

	public static void knapSackHelper(int[] weights, int[] values, int capacity, int currentV, int currentW,
			int start) {
		if (start >= weights.length && currentW <= capacity) {
			maxProfit = currentV > maxProfit ? currentV : maxProfit;
			return;
		}

		if (currentW > capacity) {
			return;
		}
		currentW += weights[start];
		currentV += values[start];
		knapSackHelper(weights, values, capacity, currentV, currentW, start + 1);
		currentW -= weights[start];
		currentV -= values[start];
		knapSackHelper(weights, values, capacity, currentV, currentW, start + 1);
	}
	
	public static int knapSackHelper2(int[] weights, int[] values, int capacity, int start, int[][] cache) {
		
		if(start ==-1 ||capacity == 0) {
			return 0;
		}
		if(cache[capacity][start] != -1) {
			return cache[capacity][start];
		}
		if(weights[start] <= capacity) {
			int with = values[start] + knapSackHelper2(weights, values, capacity - weights[start], start - 1, cache);
			int without = knapSackHelper2(weights, values, capacity, start - 1, cache);
			cache[capacity][ start] = Math.max(with, without);
			return cache[capacity][ start];
		}
		else {
			return knapSackHelper2(weights, values, capacity, start - 1, cache);
		}
	}
	
	public static void KSIterative(int[]weights, int[] values, int capacity) {
		int[][]cache = new int[capacity + 1	][weights.length + 1];
		for(int index = 1; index <=weights.length; index++) {
			for(int w = 1; w <=capacity; w++) {
				if(weights[index - 1] <= w) {
					cache[w][index] = Math.max(values[index - 1] + cache[w - weights[index - 1]][index - 1], cache[w][index - 1]);
				}
				else {
					cache[w][index] = cache[w][index - 1];
				}
			}
		}
		System.out.println("Max Profit: " + cache[capacity][weights.length]);
	}
	
}
