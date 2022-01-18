package org.code;

import java.util.HashMap;

public class SubarraysDivisibleByK {

	public static void main(String[] args) {
		SubarraysDivisibleByK sdk = new SubarraysDivisibleByK();
		int[] nums = { 3, 1, 2, 5, 1 };
		int k = 3;
		System.out.println(sdk.subarraysDivByK(nums, k));
	}

	public int subarraysDivByK(int[] nums, int k) {
		int pSum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			pSum+= nums[i];
			int remainder = pSum % k;
			int compliment = (k- remainder) % k;
			if(map.containsKey(compliment)) {
				count+= map.get(compliment);
			}
			if(map.containsKey(compliment)) {
				map.put(compliment, map.get(compliment) + 1);
			}
			else {
				map.put(compliment, 1);
			}
		}
		return count;
	}

}
