package org.code;

import java.util.Stack;

public class DailyTemperatures {
	
	public static void main(String argv[]) {
		int[] temps = {73, 74, 75, 71, 69, 72, 76};
		DailyTemperatures dt = new DailyTemperatures();
		int[] ans = dt.dailyTemperatures(temps);
		for(int val : ans) {
			System.out.print(val + " ");
		}
	}
	
	public int[] dailyTemperatures(int[] temps) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] ans = new int[temps.length];
		for(int i  = 0; i < temps.length; i++) {
			while(!stack.isEmpty() && temps[i] >= temps[stack.peek()]) {
				int val  = stack.pop();
				ans[val] = i - val;
			}
			stack.push(i);
		}
		return ans;
	}
}
