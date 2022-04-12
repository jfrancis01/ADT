package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MonotonicStack {

	public static void main(String[] args) {
		int[] ints = {3,1,6,2,5,4};
		MonotonicStack ms = new MonotonicStack();
		List<Integer> nums = new ArrayList<Integer>();
		for(int val : ints) {
			nums.add(val);
		}
		ms.monoStack(nums);
	}
	
	public void monoStack(List<Integer> nums) {
		Stack<Integer> s = new Stack<Integer>();
		for(int val : nums) {
			while(!s.isEmpty() && s.get(s.size() - 1) <= val) {
				s.remove(s.size() - 1);
			}
			s.add(val);
		}
	}
}
