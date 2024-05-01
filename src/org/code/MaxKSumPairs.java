package org.code;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxKSumPairs {

	public static void main(String[] args) {
		int[] nums = {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
		int k = 2;
		MaxKSumPairs mksp = new MaxKSumPairs();
		System.out.println(mksp.maxOperations(nums, k));
	}

	public int maxOperations(int[] nums, int k) {
		 HashMap<Integer,Integer>map=new HashMap<>();
	        int count=0;
	        for(int i=0;i<nums.length;i++){
	            //to check if that k-nums[i] present and had some value left or already paired
	            if(map.containsKey(k-nums[i])&&map.get(k-nums[i])>0){
	                count++;
	                map.put(k-nums[i],map.get(k-nums[i])-1);
	            }else{
	                //getOrDefault is easy way it directly checks if value is 0 returns 0 where I added 1
	                //and if some value is present then it return that value "similar to map.get(i)" and I added 1 on it 
	                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
	            }
	        }
	        return count;
	}

}
