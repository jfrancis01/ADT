package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		// sort starting point in ascending order
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
		ArrayList<int[]> holder = new ArrayList<int[]>();
		// now that they are sorted,
		for (int i = 0; i < intervals.length; i++) {
			int[] incoming = intervals[i];
			int[] existing = null;
			if (holder.isEmpty()) {
				holder.add(incoming);
			} else {
				// get the last element
				existing = holder.get(holder.size() - 1);
				if ((incoming[1] <= existing[1]) || (incoming[0] <= existing[0]) || (incoming[0] <= existing[1])) {
					int[] merge = { Math.min(incoming[0], existing[0]), Math.max(incoming[1], existing[1]) };
					holder.remove(holder.size() - 1);
					holder.add(merge);
				} else {
					holder.add(incoming);
				}
			}
		}
		int[][] ans = new int[holder.size()][2];
		int index = 0;
		for (int[] item : holder) {
			ans[index] = item;
			index++;
		}
		return ans;
	}
}
