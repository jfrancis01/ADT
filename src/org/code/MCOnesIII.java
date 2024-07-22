package org.code;


public class MCOnesIII {

	public static void main(String[] args) {
		MCOnesIII mcIII = new MCOnesIII();
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		System.out.println(mcIII.longestOnes(nums, k));
	}
	
	public int longestOnes(int[] nums, int k) {
        int startPtr = 0;
        int readPtr = 0;
        int current = 0;
        int max = Integer.MIN_VALUE;
        int tempK = k;
        while(startPtr < nums.length){
        	if(nums[readPtr] == 1) {
        		current++;
        		readPtr++;
        	}
        	else {
        		if(tempK > 0) {
        			current++;
        			readPtr++;
        			tempK--;
        		}
        		else {
        			max = Math.max(max, current);
        			current = 0;
        			tempK = k;
        			if(readPtr == startPtr) {
        				startPtr++;
        			}
        			else {
        				startPtr = readPtr;
        			}
        		}
        	}
        }
        return max;
    }

}
