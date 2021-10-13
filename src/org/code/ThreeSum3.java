package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum3 {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i - 1] != nums[i]) {
				ans = twoSum(nums[i], i, nums, ans);
			}
		}
		return ans;
	}

	private List<List<Integer>> twoSum(int target, int index,  int nums[], List<List<Integer>> ans) {
		int start = index  + 1;
		int end = nums.length - 1;
		 while(start < end) {
			 if(nums[start] + nums[end] ==  -1 * target) {
				 ArrayList<Integer> combo = new ArrayList<Integer>();
				 combo.add(target);
				 combo.add(nums[start]);
				 combo.add(nums[end]);
				 ans.add(combo);
                 start++;
                 end--;
                 while(start < end && nums[start - 1] == nums[start]){
                     start++;
                 }
			 }
			 else if(nums[start] + nums[end] > -1 * target) {
				 end--;
			 }
			 else {
				 start++;
			 }
			 
		 }
		 
		 return ans;
	}

	public static void main(String[] args) {
		ThreeSum3 ts3 = new ThreeSum3();
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> ans = ts3.threeSum(nums);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}

}
