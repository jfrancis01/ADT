package org.code;

public class JumpGameII {

	public static void main(String[] args) {
		int[] nums = {2,3,0,1,4};
		JumpGameII jg = new JumpGameII();
		System.out.println(jg.jump(nums));
	}

	public int jump(int[] nums) {
		int start  = 0;
		int[]cache = new int[nums.length];
		for(int i = 0 ; i < nums.length; i++) {
			cache[i] = -1;
		}
		cache[nums.length - 1] = 0;
		return helper(nums, start, cache);
	}
	
	private int helper(int[] nums, int start, int[] cache) {
		if(start >= nums.length) {
			return Integer.MAX_VALUE - 1;
		}
		if(start == nums.length - 1) {
			return 0;
		}
		if(cache[start] != -1) {
			return cache[start];
		}
		int count = Integer.MAX_VALUE - 1;
		for(int i = 1; i <= nums[start]; i++) {
			int current = 1 + helper(nums, start + i, cache);
			count = Math.min(count,  current);
			cache[start] = count;
		}
		return count;
	}

}
