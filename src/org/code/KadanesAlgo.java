package org.code;

public class KadanesAlgo {

	public static void main(String[] args) {
		int[] arry = {3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4};
		KadanesAlgo ka = new KadanesAlgo();
		System.out.println(ka.kadanesAlgorithm(arry));
	}

	public int kadanesAlgorithm(int[] array) {
		int start = 0;
		return helper(array, start);
	}

	private int helper(int[] array, int start) {
		if (start >= array.length) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		for (int i = start; i < array.length; i++) {
			int with = array[i] + helper(array, i + 1);
			int without = helper(array, i + 1);
			max = Math.max(max, Math.max(with, without));
		}
		return max;
	}
}
