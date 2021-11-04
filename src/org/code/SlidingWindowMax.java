package org.code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMax {

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		SlidingWindowMax swm = new SlidingWindowMax();
		int k = 3;
		int[] res = swm.maxSlidingWindow(nums, k);
		for (int val : res) {
			System.out.print(val + " ");
		}
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}

		ArrayList<Integer> ans = new ArrayList<Integer>();
		int left = 0, right = 0;
		Deque<Integer> deq = new ArrayDeque<Integer>();
		while (right < nums.length) {
			while (!deq.isEmpty() && nums[right] >= nums[deq.getLast()]) {
				deq.removeLast();
			}
			deq.addLast(right);
			// if the left most index is out of bound then it has to be popped
			if (right - k == deq.getFirst()) {
				deq.removeFirst();
			}

			if (right + 1 >= k) {
				ans.add(nums[deq.getFirst()]);
				left++;
			}
			right++;
		}
		int[] res = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			res[i] = ans.get(i);
		}
		return res;
	}

	public int[] maxSlidingWindow2(int[] nums, int k) {
		Deque<Integer> q = new ArrayDeque<>(); // stores *indices*
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
				q.removeLast();
			}
			q.addLast(i);
			// remove first element if it's outside the window
			if (q.getFirst() == i - k) {
				q.removeFirst();
			}
			// if window has k elements add to results (first k-1 windows have < k elements
			// because we start from empty window and add 1 element each iteration)
			if (i >= k - 1) {
				res.add(nums[q.peek()]);
			}
		}
		return res.stream().mapToInt(i -> i).toArray();
	}

}
