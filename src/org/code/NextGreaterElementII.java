package org.code;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementII {

	public static void main(String[] args) {
		int[] nums = {5,4,3,2,1};
		NextGreaterElementII ngII = new NextGreaterElementII();
		int[] ans = ngII.nextGreaterElements(nums);
		for(int val: ans) {
			System.out.print(val + " ");
		}
	}

	public int[] nextGreaterElements(int[] nums) {
		if(nums.length == 1) return new int[]{-1};
		int[] res = new int[nums.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(i)) {
				// if we haven't found the next greater for the current index
				int start = i;
				do {
					while (!stack.isEmpty() && nums[start] > nums[stack.peek()]) {
						map.put(stack.pop(), start);
					}
					stack.push(start);
					if (start == nums.length - 1) {
						start = start % (nums.length - 1);
					}
					else{ 
						start++;
					}
				}while(start != i);
				if(!map.containsKey(i)) {
					map.put(i, -1);
				}
			}
		}
		int index = 0;
		for(int val : map.values()) {
			if(val == - 1)res[index] = -1;
			else res[index] = nums[val];
			index++;
		}
		return res;
	}

}
