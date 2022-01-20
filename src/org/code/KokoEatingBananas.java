package org.code;

import java.util.Arrays;

public class KokoEatingBananas {

	public static void main(String[] args) {
		int[] piles = {3,6, 7, 11};
		int h = 8;
		KokoEatingBananas keb = new KokoEatingBananas();
		System.out.println(keb.minEatingSpeed(piles, h));
	}

	public int minEatingSpeed(int[] piles, int h) {
		// first we sort the array
		Arrays.sort(piles);
		int ans = binarySearch(piles, 1, piles[piles.length - 1], h);
		return ans;
	}

	public int binarySearch(int[] piles, int low, int high, int h) {
		int b_index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int count = 0;
			for (int i = 0; i < piles.length; i++) {
				count+= piles[i]/mid;
				if(piles[i] % mid != 0) {
					count++;
				}
			}
			if (count > h) {
				low = mid + 1;
			}
			else{
				b_index = mid;
				high = mid - 1;
			}
		}
		return b_index;
	}
}
