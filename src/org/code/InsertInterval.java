package org.code;

import java.util.ArrayList;

public class InsertInterval {

	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();
		int intervals[][] = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 4, 8 };
		int[][] ans = ii.insert(intervals, newInterval);
		for (int i = 0; i < ans.length; i++) {
			int[] arr = ans[i];
			System.out.print(arr[0] + "->" + arr[1]);
			System.out.print(" ");
		}
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		ArrayList<int[]> inters = new ArrayList<int[]>();
		ArrayList<int[]> temp = new ArrayList<int[]>();
		boolean inserted = false;
		for (int i = 0; i < intervals.length; i++) {
			int[] arr1 = intervals[i];
			int[] arr2 = new int[2];
			if (i == 0) {
				arr2[0] = Integer.MIN_VALUE;
				arr2[1] = Integer.MIN_VALUE;
			} else {
				arr2 = intervals[i - 1];
			}
			if (!inserted && newInterval[0] <= arr1[0]) {
				inters.add(newInterval);
				inters.add(arr1);
				inserted = true;
			} else if (!inserted && newInterval[0] >= arr1[0] && newInterval[0] <= arr2[0]) {
				inters.add(arr1);
				inters.add(newInterval);
				inserted = true;
			} else {
				inters.add(intervals[i]);
			}

		}
		//this is if the initial intervals are empty
		if (!inserted) {
			inters.add(newInterval);
		}

		for (int i = 0; i < inters.size(); i++) {
			int[] incoming = inters.get(i);
			if (temp.isEmpty()) {
				temp.add(incoming);
			} else {
				int[] arr = new int[2];
				int[] curr = temp.get(temp.size() - 1);
				if (incoming[0] > curr[1] && incoming[1] > curr[1]) {
					temp.add(incoming);
				} else if (incoming[0] >= curr[1] && incoming[1] <= curr[1]) {
					temp.remove(curr);
					arr[0] = curr[0];
					arr[1] = curr[1];
					temp.add(arr);
				} else if (incoming[0] <= curr[1] && incoming[1] >= curr[1]) {
					temp.remove(curr);
					arr[0] = curr[0];
					arr[1] = incoming[1];
					temp.add(arr);
				} else {
					continue;
				}
			}
		}

		int[][] ans = new int[temp.size()][2];
		for (int i = 0; i < temp.size(); i++) {
			ans[i] = temp.get(i);
		}
		return ans;
	}

}
