package org.code;

public class RodCutting {
	
	public static void main(String argv[]) {
		int length = 4;
		int costs[]= {1,5,8,9,10,17,17,20};
		int cache[] = new int[costs.length + 1];
		for(int i = 0; i < cache.length; i++) {
			cache[i] = -1;
		}
		cache[0] = 0;
		System.out.println(rodCutting(length, costs, cache));
	}
	
	public static int rodCutting(int length, int costs[], int[]cache) {
		if( cache[length] != -1) {
			return cache[length];
		}
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= costs.length; i++) {
			if(i <= length) {
				max = Math.max(max, costs[i - 1] + rodCutting(length - i, costs, cache));
			}
		}
		cache[length] = max;
		return max;
	}
}
