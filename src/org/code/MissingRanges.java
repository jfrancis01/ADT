package org.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*
 * This algorithm a memory limit exceed erro. 
 * Think about how to reduce the memory used
 */
public class MissingRanges {

	public static void main(String[] args) {
		MissingRanges mr = new MissingRanges();
		int[] nums = {0,1,3,50, 75};
		List<String> ans = mr.findMissingRanges(nums, 0, 99);
		for(String s : ans) {
			System.out.print(s + ", ");
		}
	}
	
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    	List<String> ans = new ArrayList<String>();
    	ArrayList<Integer> missing = new ArrayList<Integer>();
        for(int i = lower; i <=upper; i++) {
        	boolean found = binarySearch(nums, i,  0, nums.length - 1);
        	if(!found) {
        		missing.add(i);
        	}
        	else {
        		continue;
        	}
        }
        LinkedList<Integer> q = new LinkedList<Integer>();
        for(int i  = 0; i < missing.size(); i++) {
        	if(q.isEmpty()) {
        		q.add(missing.get(i));

        	}
        	else if (q.getLast().intValue() == missing.get(i) - 1) {
        		q.add(missing.get(i));
        	}
        	else {
        		int first = q.peek().intValue();
        		int last = q.getLast().intValue();
        		if(first != last){
        			ans.add(String.valueOf(first) + "->" + String.valueOf(last));
        		}
        		else {
        			ans.add(first + "");
        		}
        		q.clear();
        		q.add(missing.get(i));
        	}
        }
        if(!q.isEmpty()) {
        	int first = q.peek().intValue();
    		int last = q.getLast().intValue();
    		if(first != last){
    			ans.add(String.valueOf(first) + "->" + String.valueOf(last));
    		}
    		else {
    			ans.add(first + "");
    		}
        }
        return ans;
    }
    
    private boolean binarySearch(int[] nums, int target, int start, int end) {
    	while(start <= end) {
    		int mid = start + (end - start)/2;
    		if(nums[mid] == target) return true;
    		else if(nums[mid] > target) {
    			end = mid - 1;
    		}
    		else {
    			start = mid + 1 ;
    		}
    	}
    	return false;
    }
}
