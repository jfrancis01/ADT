package org.code;

import java.util.ArrayList;

public class ChooseKIntegers {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		int k = 8;
		int start = 0;
		chooseKIntegers(nums, start, new ArrayList<Integer>(), k);
	}
	
	public static void chooseKIntegers(int[] nums, int start, ArrayList<Integer>combo, int k) {
		
		if(start >= nums.length) {
			if(combo.size() == k) {
				for(int i = 0; i < combo.size();i++) {
					System.out.print(combo.get(i));
				}
				System.out.println();
			}
			return;
		}
		
		//choose
		combo.add(nums[start]);
		//explore
		chooseKIntegers(nums, start + 1, combo, k);
		//unchoose
		combo.remove(combo.size()-1);
		//explore again
		chooseKIntegers(nums, start + 1, combo, k);
	}
}
