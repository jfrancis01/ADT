package org.code;

public class CapacityToShip2 {

	public int shipWithinDays(int[] weights, int days) {
		// first find the maximum weight
		int max_weight = Integer.MIN_VALUE;
		int total_weight = 0;
		for (int weight = 0; weight < weights.length; weight++) {
			max_weight = Math.max(max_weight, weights[weight]);
			total_weight += weights[weight];
		}
		int ans = checkValue(weights, max_weight , total_weight , days);
		return ans;
	}
	
	private int checkValue(int[] weights, int left, int right,  int days) {
		int b_index = -1;
		while(left <= right){
			int mid = left + (right - left)/2;
			int current_day = 1;
			int current_weight = 0;
			for(int i  = 0; i < weights.length;i++) {
				if(current_weight + weights[i] > mid) {
					current_weight  = weights[i];
					current_day++;
				}
				else {
					current_weight += weights[i];
				}
			}
			if(current_day <= days) {
				b_index = mid;
				right = mid - 1;
			}
			else if(current_day > days) {
				left = mid + 1;
			}
		}
		return b_index;
	}
	
	public static void main(String argv[]) {
		CapacityToShip2 ct2 = new CapacityToShip2();
		int[] weights = {10,50,100,100,50,100,100,100};
		int d  = 5;
		System.out.println("minimum weight = " + ct2.shipWithinDays(weights, d));
	}

}
