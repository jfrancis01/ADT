package org.code;

public class SearchRange {

	public static void main(String[] args) {
		int[] nums = {1,1,2,2,3,3,3,3,3,3,4,4,5,7,7,8,8,10};
		SearchRange sr = new SearchRange();
		int[]ans = sr.searchRange(nums, 3);
		for(int val : ans) {
			System.out.print(val + " ");
		}
	}
	
	public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums.length == 1 && nums[0] == target){
            ans[0] = 0;
            ans[1] =0;
            return ans;
        }
        if(nums.length == 1 && nums[0] != target){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        int index = binarysearch(0, nums.length - 1, nums, target);
        
        if(index == -1){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        
        while(index != nums.length - 1 && nums[index + 1] == target){
            int right = binarysearch(index + 1, nums.length - 1, nums, target);
            ans[1] = right;
            index = right;
        }
        ans[1] = index;
    
        while (index != 0 && nums[index - 1] == target ){
             int left = binarysearch(0, index - 1, nums, target);
            ans[0]= left;
            index = left;
        }
        ans[0] = index;
        return ans;
    }
    
    private int binarysearch(int start, int end, int[] nums, int target){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(nums[mid] == target) return mid;
        else if( nums[mid] < target ) return binarysearch(mid +1, end, nums, target);
        else return binarysearch(start, mid - 1, nums, target);
    }

}
