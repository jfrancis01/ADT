package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum2 {
	
	Set<List<Integer>> triplets = new HashSet<>();
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //sort to remove duplicate solutions
        for(int i = 0; i < nums.length; i++) {
        	find2Sum(i, nums);
        }
        return new ArrayList<>(triplets);
    }
    public void find2Sum(int index, int[] nums){
        int target = -1 * nums[index];
        int left = index + 1;
        int right = nums.length - 1;
        while(left < right ){
            if(nums[left] + nums[right] == target){
                ArrayList<Integer> row = new ArrayList<Integer>();
                row.add(nums[left]);
                row.add(nums[right]);
                row.add(target * -1);
                triplets.add(row);
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
		ThreeSum2 ts2 = new ThreeSum2();
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> ans = ts2.threeSum(nums);
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}

}
