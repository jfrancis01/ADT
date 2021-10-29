package org.code;

import java.util.HashMap;
import java.util.Stack;

public class NextGenerationElement {

	public static void main(String[] args) {
		int[] nums1 = {2, 4}, nums2 = {1,2,3,4};
		NextGenerationElement nge = new NextGenerationElement();
		int[] ans = nge.nextGreaterElement(nums1, nums2);
		for(int val: ans) {
			System.out.print(val +  " ");
		}
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		//first we fins the next greatest for each index in num2 using a decreasing stack and store
		// it in a HashMap. Then we iterate through nums1 and simply pull from
		//the hashmap to create the ans array
		Stack<Integer> stack = new Stack<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i  = 0; i < nums2.length; i++) {
			while(!stack.isEmpty() && nums2[i] >= nums2[stack.peek()]) {
				int val = stack.pop();
				map.put(nums2[val], i);
			}
			stack.push(i);
		}
		//push remaining not found numbers into the HashMap
		while(!stack.isEmpty()) {
			int index = stack.pop();
			map.put(nums2[index], -1);
		}
		
		int[] ans = new int[nums1.length];
		for(int i = 0; i < nums1.length; i++) {
			int val = map.get(nums1[i]);
			ans[i] = val == -1? -1: nums2[val];
		}
		return ans;
	}

}
