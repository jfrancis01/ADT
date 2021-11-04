package org.code;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiff {
	
	/*
	 * This problem can be solved with a a monotonic queue. The reason being that
	 * at any point in time within the given window, the absolute difference is 
	 * between the max and the minimum. How do we keep track of the max and the minimum?
	 * Well, we use a monotonic queue to solve it! Use one queue for the max and a another queue for the 
	 * min
	 */

	public static void main(String[] args) {
		int[] nums = {10, 1,2,4,7,2};
		int limit = 5;
		LongestContinuousSubarrayWithAbsoluteDiff obj = new LongestContinuousSubarrayWithAbsoluteDiff();
		System.out.println(obj.longestSubarray(nums, 5));
		
	}
	
	public int longestSubarray(int[] nums, int limit) {
		int ans = 1;
		int l = 0;
		Deque<Integer> max_q = new ArrayDeque<Integer>();
		Deque<Integer> min_q = new ArrayDeque<Integer>();
		
		for(int index  = 0; index < nums.length; index++) {
			//first rule is before appending anything, whether the queue needs to be monotonically
			//increasing or decreasing, you need to POP!
			if(!max_q.isEmpty() && nums[index] >= nums[max_q.getLast()]) {
				max_q.removeLast();
			}
			max_q.addLast(index);
			
			//repeat the same thing to get the minimum
			
			if(!min_q.isEmpty() && nums[index] <= nums[min_q.getLast()]) {
				min_q.removeLast();
			}
			min_q.addLast(index);
			
			//find the absolute difference
			while(nums[max_q.getFirst()] - nums[min_q.getFirst()] > limit) {
				if (nums[max_q.peekFirst()] == nums[l]) max_q.pollFirst();
				if (nums[min_q.peekFirst()] == nums[l]) min_q.pollFirst();
				l++;
			}
			ans = Math.max(ans, index-l + 1);
		}
		return ans;
	}
	
	public int longestSubarray2(int[] nums, int limit) {
        int start = 0;
        int end = 0;
        int res = 1;
        
        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
            
        while (start <= end && end < nums.length) {
            minQ.offer(nums[end]);
            maxQ.offer(nums[end]);
            int minNum = minQ.peek();
            int maxNum = maxQ.peek();
            if (maxNum - minNum <= limit) {
                end++;
                res = Math.max(res, end - start);
            } else {
                boolean t = minQ.remove(nums[start]);
                boolean tt = maxQ.remove(nums[start]);
                start++;
                end++; // When ">limit" you also need to change your end, if you do not do so, you will push the same number twice.
            }
        }
        return res;
    }

}
