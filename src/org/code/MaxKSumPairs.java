package org.code;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxKSumPairs {

	public static void main(String[] args) {
		int[] nums = {1, 2,3, 4};
		int k = 5;
		MaxKSumPairs mksp = new MaxKSumPairs();
		System.out.println(mksp.maxOperations(nums, k));
	}

	public int maxOperations(int[] nums, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int ops = 0;
		for(int i  = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while()
		for(int i  = 0;  i < nums.length;  i++) {
			int num = list.get(i);
			int diff = k - nums[i];
			if(map.containsKey(diff)) {
				map.remove(diff);
				list.remove(i);
				ops++;
			}
		}
	}

}
