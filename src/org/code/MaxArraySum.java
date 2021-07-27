package org.code;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxArraySum {
	static int max = Integer.MIN_VALUE;

	public static void main(String argv[]) {
		int[] nums = { 1,2,1,1};
		System.out.println("Max: " + MaxArraySum.maxSubsetSum(nums));
	}

	public static int maxSubsetSum(int[] arr) {
		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
		return maxSumHelper(arr, 0, arr.length, 0, new ArrayList<Integer>(), cache);
	}

	public static int maxSumHelper(int[] arr, int start, int end, int sum, ArrayList<Integer> combo,
			HashMap<Integer, Integer> cache) {

		if (cache.containsKey(start)) {
			return cache.get(start);
		}

		if (start >= end) {

			for (int i = 0; i < combo.size(); i++) {
				System.out.print(combo.get(i) + " ");
			}

			return sum;
		}
		//for (int i = start; i < arr.length; i++) {
			combo.add(arr[start]);
			int withMax = maxSumHelper(arr, start + 2, end, sum + arr[start], combo, cache);
			combo.remove(combo.size() - 1);
			int withoutMax = maxSumHelper(arr, start + 1, end, sum, combo, cache);
			cache.put(start, Math.max(withMax, withoutMax));
			max = Math.max(max, Math.max(withMax, withoutMax));
		//}
		return max;
	}

}
