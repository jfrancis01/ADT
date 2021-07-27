package org.code;

import java.util.HashMap;

public class ContiguousArray {

    public static void main(String argv[]){
        int[] nums = {0,0,1,0,0,0,1,1};
        System.out.println(findMaxLength(nums));
    }
    public static int findMaxLength(int[] nums) {
        int count = 0, maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1 );
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0) count++;
            else count--;

            if(map.containsKey(count)){
                maxLength = Math.max(maxLength, i - map.get(count));
            }
            else{
                map.put(count, i);
            }
        }
        return maxLength;
    }
}
