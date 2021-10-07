package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

	public static void main(String[] args) {
		NonOverlappingIntervals noi = new NonOverlappingIntervals();
		int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
		System.out.println(noi.eraseOverlapIntervals(intervals));
	}
	
	/**
	 * The ide here is to keep the intervals small so if you have an intersection with a bigger interval 
	 * remove it by taking the minimum end of tthe two ends of the intervals to prevent further overlap
	 * @param intervals
	 * @return
	 */
	public int eraseOverlapIntervals(int[][] intervals) {
		if(intervals.length == 1) return 0;
		
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
		
		ArrayList<int[]> myList = new ArrayList<int[]>();
		ArrayList<int[]> finalList = new ArrayList<int[]>();
		for(int[] temp : intervals) {
			myList.add(temp);
		}
		
		for(int i  = 0; i < myList.size(); i++) {
			int[] incoming = myList.get(i);
			
			if(finalList.isEmpty()) {
				finalList.add(incoming);
			}
			else {
				int[] current = finalList.get(finalList.size() - 1);
				if(incoming[0] < current[1]) {
					int[] arr = new int[2];
					arr[0] = incoming[0];
					arr[1] = Math.min(incoming[1], current[1]);
					finalList.remove(current);
					finalList.add(arr);
				}
				else {
					finalList.add(incoming);
				}
			}
		}
		
		return myList.size() - finalList.size();
	}

}
