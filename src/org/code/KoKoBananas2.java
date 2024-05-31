package org.code;

import java.util.Arrays;

public class KoKoBananas2 {

	public static void main(String[] args) {
		int[]piles = {312884470};
		int h = 312884469;
		KoKoBananas2 kb2 = new KoKoBananas2();
		System.out.println(kb2.minEatingSpeed(piles, h));
	}

	public int minEatingSpeed(int[] piles, int h) {
		Arrays.sort(piles);
		int min = 0;
		int max = piles[piles.length - 1];
		int current = Integer.MAX_VALUE;
		int ans = binarySearch(min, max, piles, h);
		return ans;
	}

	private int binarySearch(int min, int max, int[] piles, int h) {
		int b_index = -1;
		while (min <= max) {
			int mid = min + (max - min) / 2;
			int res = check(mid, piles, h);
			if (res < h) {
				max = mid - 1;
			}
			else{
				min = mid + 1;
				b_index = mid;
			}
		}
		if(check(min, piles, h) <=h) {
			return min;
		}
		return b_index;
	}

	private int check(int mid, int[] piles, int h) {
		int total = 0;
		for (int i = 0; i < piles.length; i++) {
			if (mid >= piles[i]) {
				total++;
			} else {
				int r = piles[i];
				while (r  > 0) {
					r = r - mid;
					total++;
				}
			}
		}
		return total;
	}

}
