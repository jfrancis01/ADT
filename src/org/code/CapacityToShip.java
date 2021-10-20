package org.code;

public class CapacityToShip {

	public int shipWithinDays(int[] weights, int D) {
		int weightSum = 0;
		int maxWeight = 0;

		for (int ind = 0; ind < weights.length; ind++) {
			weightSum = weightSum + weights[ind];
			maxWeight = Math.max(weights[ind], maxWeight);
		}

		int min = maxWeight;
		int max = weightSum;
		int mid = min;

		while (min < max) {
			mid = min + (max - min) / 2;
			int day = 1;
			int sum = 0;
			for (int weight : weights) {
				if (sum + weight > mid) {
					day++;
					sum = weight;
				} else {
					sum = sum + weight;
				}
			}
			if (day <= D) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		return min;
	}

	public static void main(String[] args) {
		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int days = 5;
		CapacityToShip cts = new CapacityToShip();
		System.out.println(cts.shipWithinDays(weights, days));
	}

}
