package org.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class ThreeSum {
    
    public List<List<Integer>> myList = new ArrayList<List<Integer>>();
    public HashSet<ArrayList<Integer>> mySet = new HashSet<ArrayList<Integer>>();
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 1 || nums.length == 2) return null;
        threeSumHelper(nums, 0, 0, 0, new ArrayList<Integer>());
        for(ArrayList<Integer> combo: mySet){
            myList.add(combo);
        }
        return myList;
    }
    
    public void threeSumHelper(int[] arr, int start, int sum, int nums, ArrayList<Integer> combo){
        if(nums == 3){
            if(sum == 0){
                mySet.add((ArrayList<Integer>)combo.clone());
                return;
            }
        }
        if(nums > 3 || start >=arr.length){
            return;
        }
        combo.add(arr[start]);
        threeSumHelper(arr, start + 1, sum + arr[start], nums + 1, combo);
        combo.remove(combo.size() - 1);
        threeSumHelper(arr, start + 1, sum, nums, combo);
    }
}
