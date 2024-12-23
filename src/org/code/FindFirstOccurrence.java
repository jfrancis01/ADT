package org.code;

import java.util.ArrayList;
import java.util.List;

public class FindFirstOccurrence {

	public static void main(String[] args) {
		FindFirstOccurrence ffo = new FindFirstOccurrence();
		List list = new ArrayList<Integer>();
		list.add(4);
		list.add(6);
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(20);
		System.out.println(ffo.findFirstOccurrence(list, 8));

	}
	
	public static int findFirstOccurrence(List<Integer> arr, int target) {
        int idx = -1;
        int start = 0;
        int end = arr.size() - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int val = arr.get(mid);
            if(target <= val){
                idx = mid;
                end = mid-1 ;
            }
            else{
                start = mid + 1;
            }
        }
        return idx;
    }

}
