package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceTwoArrays {

	public static void main(String[] args) {
		DifferenceTwoArrays dta = new DifferenceTwoArrays();
		System.out.println(dta.findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
	}

	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		Set<Integer> left = new HashSet<Integer>();
		Set<Integer> right = new HashSet<Integer>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		int i;
		for(i  = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);
		}
		for(i  = 0; i < nums2.length; i++) {
			set2.add(nums2[i]);
		}
		for (i = 0; i < nums1.length; i++) {
			if (set2.contains(nums1[i])) {
				continue;
			}
			else {
				left.add(nums1[i]);
			}
		}
		for (i = 0; i < nums2.length; i++) {
			if (set1.contains(nums2[i])) {
				continue;
			}
			else {
				right.add(nums2[i]);
			}
		}
		ans.add(new ArrayList<>(left));
		ans.add(new ArrayList<>(right));
		return ans;
	}

}
