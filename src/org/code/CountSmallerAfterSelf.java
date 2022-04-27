package org.code;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerAfterSelf {

	public static void main(String[] args) {
		int[] nums = { 5, 2, 6, 1 }; // { 5, 2, 1, 3, 7, 6 };
		CountSmallerAfterSelf csas = new CountSmallerAfterSelf();
		List<Integer> ans = csas.countSmaller(nums);
		for (int val : ans) {
			System.out.print(val + " ");
		}

	}

	public class Item {
		int val;
		int index;

		public Item(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}

	public List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		Item[] items = new Item[n];
		for (int i = 0; i < n; i++) {
			items[i] = new Item(nums[i], i);
		}
		int[] count = new int[n];
		mergeSort(items, 0, n - 1, count);
		List<Integer> ans = new ArrayList<Integer>();
		for (int c : count) {
			ans.add(c);
		}
		return ans;
	}

	public void mergeSort(Item[] items, int lo, int hi, int[] count) {
		if (lo >= hi) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		mergeSort(items, lo, mid, count);
		mergeSort(items, mid + 1, hi, count);
		merge(items, lo, mid, mid + 1, hi, count);
	}

	private void merge(Item[] items, int lo, int loEnd, int hi, int hiEnd, int[] count) {
		int p = lo;
		int q = hi;
		int size = hiEnd - lo + 1;
		Item[] sorted = new Item[size];
		int index = 0;
		int rightCounter = 0;

		while (p <= loEnd && q <= hiEnd) {
			if (items[p].val > items[q].val) {
				sorted[index] = items[q];
				rightCounter++;
				index++;
				q++;
			} else {
				count[items[p].index] += rightCounter;
				sorted[index] = items[p];
				index++;
				p++;
			}
		}
		// after it come out of this loop, we have to check and see which list
		// needs to be appended
		if (p <= loEnd) {
			count[items[p].index] += rightCounter;
			sorted[index] = items[p];
			index++;
			p++;
		}
		if (q <= hiEnd) {
			sorted[index] = items[q];
			index++;
			q++;
		}
		System.arraycopy(sorted, 0, items, lo, size);
	}
}
