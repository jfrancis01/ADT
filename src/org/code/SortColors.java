package org.code;

public class SortColors {

	public static void main(String[] args) {
		SortColors sc = new SortColors();
		int[] nums = {2,0,2,1,1,0};
		sc.sortColors(nums);
		for(int val : nums) {
			System.out.print(val + " , ");
		}
	}
	
    public void sortColors(int[] nums) {
        int readPointer = 0;
        int tempReadPointer = 0;
        for(int i = 0; i<=2; i++) {
        	while(readPointer < nums.length) {
        		tempReadPointer = readPointer;
        		if(nums[readPointer] == i) {
        			readPointer++;
        		}
        		int writePointer = readPointer + 1;
        		while(writePointer < nums.length) {
        			if(nums[writePointer] == i ) {
        				swap(readPointer, writePointer, nums);
        				readPointer++;
        				break;
        			}
        			writePointer++;
        		}
        		if(tempReadPointer == readPointer) {
        			break;
        		}
        	}
        }
    }
    
    private void swap(int i, int j, int[]nums) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }

}
