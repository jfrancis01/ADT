package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
	
	int[][] result = null;

	public int[][] merge(int[][] intervals) {
		
		if (intervals == null)
			return null;
		if (intervals.length == 1)
			return intervals;
		int i = 0;
		ArrayList<int[]> temp = new ArrayList<>();
		
		/// first sot the arrays in the increaseing order of their strarts
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
		
		for (i = 0; i < intervals.length; i++) {
			// if the result list is empty
			if (temp.isEmpty()) {
				// compare i and i + 1
				int[] arr1 = intervals[i];
				int[] arr2 = intervals[i + 1];
				
				if (arr1[1] >= arr2[0] && arr1[1] <= arr2[1]) {
					int[] newArry  = { arr1[0], arr2[1]};
					temp.add(newArry);
				}
				else if(!(arr2[1] >= arr1[0] && arr2[1] <= arr1[1])) {
					temp.add(arr1);
					temp.add(arr2);
				}
				else {
					temp.add(arr1);
				}
				i++;
			}
			else {//you know there is atleast one interval so get the one that was added last
				int[] existing = temp.get(temp.size() - 1);
				int[] incoming = intervals[i];
				
				if(existing[1] >= incoming[0] && existing[1] <= incoming[1]) {
					temp.remove(temp.size() - 1);
					int[] newArry  = { existing[0], incoming[1]};
					temp.add(newArry);
				}
				else if(!(incoming[1] >= existing[0] && incoming[1] <= existing[1])) {
					temp.add(incoming);
				}
				else {
					//do nothing
				}
			}
		}
		result = addToReturnList(result, temp);
		return result;
	}
	
	public int[][] addToReturnList(int[][]result, ArrayList<int[]> temp) {
		result = new int[temp.size()][2];
		for(int i = 0; i < temp.size(); i++) {
			result[i] = temp.get(i);
		}
		return result;
	}

	public static void main(String argv[]) {
		MergeIntervals mi = new MergeIntervals();
		int[][] intervals = {{1,4},{0,2},{3,5}};
				//{{1,4},{5,6}};
				//{{1,3},{2,6},{8,10},{15,18}};
				//{{6, 8}, {1, 9}, {2, 4}, {4, 7}};
				//{{1,4},{4,5}};
		int[][] result = mi.merge(intervals);
		for(int i = 0; i <result.length;i++) {
			for(int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
