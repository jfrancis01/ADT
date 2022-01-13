package org.code;

import java.util.HashMap;

public class CountNiceSubArrays {

	public static void main(String[] args) {
		CountNiceSubArrays csubs = new CountNiceSubArrays();
		int[] nums = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
		System.out.println(csubs.numberOfSubarrays3(nums, 2));

	}

	/**
	 * Whenever the count of odd numbers reach k, for each high boundary of the
	 * sliding window, we have indexOfLeftMostOddInWin - lowBound options for the
	 * low boundary, where indexOfLeftMostOddInWin is the index of the leftmost odd
	 * number within the window, and lowBound is the index of the low boundary
	 * exclusively; Whenever the count of odd numbers more than k, shrink the low
	 * boundary so that the count back to k;
	 */

	public int numberOfSubarrays(int[] nums, int k) {
		int ans = 0, indexOfLeftMostOddInWin = 0, lowBound = -1;
		for (int num : nums) {
			k -= num % 2;
			if (nums[indexOfLeftMostOddInWin] % 2 == 0) // move to the index of first odd.
				++indexOfLeftMostOddInWin;
			if (k < 0) { // more than k odds in window, need to shrink from low bound.
				lowBound = indexOfLeftMostOddInWin; // update the low bound value.
			}
			while (k < 0) {
				k += nums[++indexOfLeftMostOddInWin] % 2; // move to the index of next odd.
			}
			if (k == 0) { // accumulated k odd numbers in window.
				ans += indexOfLeftMostOddInWin - lowBound; // update result.
			}
		}
		return ans;
	}

	public int numberOfSubarrays2(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int res = 0;
        int count = 0;
        while (end < nums.length) {
            if (nums[end] % 2 == 1) {
                k--;
                count = 0;
            }
            while (k == 0) {
                if (nums[start] % 2 == 1) {
                    k++;
                }
                start++;
                count++;
            }
            res += count;
            end++;
        }
        return res;
	}
	
	public int numberOfSubarrays3(int[] nums, int k) {
		int ans = 0;
		//first we convert all the odd numbers to 1 and even numbers to 0
		for(int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] % 2;
		}
		//now the question becomes find the number of subarrays whose sum is K because
		//k odd numbers sum to k
		int pSum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		for(int i = 0; i < nums.length; i++) {
			pSum += nums[i];
			int diff = pSum - k;
			if(map.containsKey(diff)) {
				ans+= map.get(diff);
			}
			map.put(pSum, map.getOrDefault(pSum, 0) + 1);
		}
		return ans;
	}

}
