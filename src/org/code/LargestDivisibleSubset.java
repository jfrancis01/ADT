package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	
	List<Integer> max = new ArrayList<Integer>();

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		LargestDivisibleSubset lds = new LargestDivisibleSubset();
		List<Integer> ans = lds.largestDivisibleSubset(nums);
		for(int val: ans) {
			System.out.print(val + " ");
		}
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		//first we sort the numbers because if the new number coming in is a % b (prervious #) is 0
		//then the numbers previous to it are also divisible. 
		Arrays.sort(nums);
		//not this becomes the same as the LIs problem
		int start = 0;
		List<Integer> current = new ArrayList<Integer>();
		helper(nums, start, current);
		return max;
	}
	
	public void helper(int[] nums, int start, List<Integer>current) {
		if(start >= nums.length ) {
			if(current.size() > max.size()) {
				max.clear();
				max.addAll(current);
			}
			return;
		}
		
		if(start == 0 || nums[start] % nums[start - 1] == 0) {
			current.add(nums[start]);
			helper(nums, start + 1, current);
			current.remove(current.size() - 1);
		}
		helper(nums, start + 1, current);
	}

}
