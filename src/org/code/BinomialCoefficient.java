package org.code;

public class BinomialCoefficient {

	public static void main(String argv[]) {
		int n = 144;
		int k = 5;
		int[][] cache = new int[n + 1][k + 1];
		System.out.println("Binomial Coefficient Recursive: " + findBC(n, k, cache));
		for(int i  = 0; i <n ;i++) {
			for(int j = 0; j <k; j++) {
				if(i == j) {
					cache[i][j] = 1;
				}
				cache[i][0] = 1;
			}
		}
		System.out.println("Binomial Coefficient Iterative: " + findBCIterative(n, k, cache));
	}

	public static int findBC(int n, int k, int[][] cache) {
		if (n == k || (k == 0))
			return 1;
		if(cache[n][k] != 0) return cache[n][k];

		int ans = findBC(n - 1, k - 1, cache) + findBC(n - 1, k, cache);
		cache[n][k] =ans;
		return ans;
	}
	
	public static int findBCIterative(int n, int k, int[][]cache) {
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < k; j++) {
				cache[i][j] = cache[i -1][k-1] + cache[i-1][j];
			}
		}
		return cache[n][k];
	}

}
