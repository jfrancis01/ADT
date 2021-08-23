package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum2 {
	
	List<List<Integer>> ans = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //sort to remove duplicate solutions
        for(int i  = 0; i< nums.length; i++){
            find2Sum(i, nums);
        }
        return ans;
    }
    public void find2Sum(int index, int[] nums){
        int target = -1 * nums[index];
        int left = index;
        int right = nums.length - 1;
        while(left < right ){
            if(nums[left] + nums[right] == target){
                ArrayList<Integer> row = new ArrayList<Integer>();
                row.add(nums[left]);
                row.add(nums[right]);
                row.add(target * -1);
                ans.add(row);
                break;
            }
            else if(nums[left] + nums[right] < target){
                left++;
            }
            else{
                right--;
            }
        }
    }

	public static void main(String[] args) {
		
	}

}
