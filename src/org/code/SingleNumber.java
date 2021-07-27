package org.code;

import java.util.HashSet;

public class SingleNumber {
    public static void main(String argv[]) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
       HashSet<Integer> set = new HashSet<Integer>();
       for(int i: nums){
           if(!set.contains(i)){
               set.add(i);
           }
           else{
               set.remove(i);
           }
       }
       for(int i : set){
           return i;
       }
       return -1;
    }
}
