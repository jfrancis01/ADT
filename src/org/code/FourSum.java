package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {

	List<List<Integer>> ans = new ArrayList<List<Integer>>();

	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<Integer> nodups = new ArrayList<Integer>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			nodups.add(nums[i]);
		}
		findCombos(0, target, new ArrayList<Integer>(), nodups);
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
		return ans;
	}

	private void findCombos(int start, int target, 
			ArrayList<Integer> combo, ArrayList<Integer> nodups){

        if(target == 0 && combo.size() == 4) {
        	ans.add((List<Integer>) combo.clone());
        	return;
        }
		if(start >= nodups.size()) {
			return;
		}
        for(int i = start; i <nodups.size(); i++ ) {
        	if(nodups.get(i) <= target) {
        		combo.add(nodups.get(i));
        		findCombos(i + 1, target - nodups.get(i), combo, nodups);
        		combo.remove(combo.size() - 1);
        	}
        }
    }

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		FourSum fs = new FourSum();
		fs.fourSum(nums, 0);
	}

}
