package org.code;

import java.util.ArrayList;

/**
 * Research sliding window
 * https://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
 * @author Joel
 * {1, 6, 7, 9} < 14
 */

public class TripletSum {
	
	private static int count;

	public static void main(String argv[]) {
		int[] arr = { 5,1,3,4,7};
		int target = 12;
		//findTrips(arr, target);
		//System.out.println(count);
		findTripsRecur(arr, 0, 0, target, 0, new ArrayList<Integer>());
		System.out.println(count);
	}

	public static void findTrips(int[] arr, int sum) {
		for(int i = 0; i < arr.length;i++){
			for(int j =  i + 1; j < arr.length;j++){
				for(int k = j + 1; k < arr.length; k++){
					if(arr[i] + arr[j] + arr[k] < sum){
						System.out.println( arr[i] + " " + arr[j]+ " " + arr[k]);
						count++;
					}
				}
			}
		}
	}
	
	public static void findTripsRecur(int[] arr, int start, int nums, int target, int sum, ArrayList<Integer> combo) {
		if(nums == 3) {
			if(sum < target) {
				count++;
				for(int val : combo) {
					System.out.print(val + " ");
				}
				System.out.println();
				return;
			}
		}
		if(start >= arr.length) {
			return;
		}
		if(nums > 3) {
			return;
		}
		//add the number to the lsit
		combo.add(arr[start]);
		//chooose the number
		findTripsRecur(arr, start + 1, nums + 1, target, sum + arr[start], combo );
		//remove from the list
		combo.remove(combo.size() - 1);
		//dont take the number
		findTripsRecur(arr, start + 1, nums, target, sum, combo);
	}
}
