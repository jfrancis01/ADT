package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {

	List<List<Integer>> ans = new ArrayList<List<Integer>>();

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				int target_2 = target - (nums[i] + nums[j]);
				//initialize two pointers
				int front = j + 1;
				int end = nums.length - 1;
				
				while(front < end) {
					if(nums[front] + nums[end] == target_2) {
						front++;
						end--;
						ArrayList<Integer> combo = new ArrayList<Integer>();
						combo.add(nums[i]);
						combo.add(nums[j]);
						combo.add(nums[front]);
						combo.add(nums[end]);
						ans.add(combo);
						while(front < end  && nums[front] == nums[front -1]) {
							front++;
						}
					}
					else if (nums[front] + nums[end] < target_2) {
						front++;
					}
					else {
						end--;
					}
				}
				while(j + 1 < nums.length && nums[j] == nums[j + 1]) {
					j++;
				}
			}
			while(i + 1< nums.length && nums[i] == nums[i + 1]) {
				i++;
			}
		}
		printAnswers();
		return ans;
	}


	public static void main(String[] args) {
		int[] nums = {2,2,2,2,2};
		FourSum fs = new FourSum();
		fs.fourSum(nums, 8);
	}
	
	private void printAnswers() {
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}

}
