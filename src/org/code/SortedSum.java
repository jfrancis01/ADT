package org.code;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortedSum {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(4);
		myList.add(3);
		myList.add(2);
		myList.add(1);
		System.out.println(SortedSum.sortedSum(myList));
	}

	public static int sortedSum(List<Integer> a) {

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			int currentSum = 0;
			// push on to the top the heap
			heap.add(a.get(i));
			int heapSize = heap.size();
			int[] temp = new int[heapSize];
			int index = 0;
			for (int j = 0; j < heapSize; j++) {
				int val = heap.poll();
				temp[index] = val;
				index++;
				currentSum+= val * (j + 1);
			}
			// add the numbers back into the heap
			for (int k = 0; k < index; k++) {
				heap.add(temp[k]);
			}
			sum+=currentSum;
		}
		return sum;

	}

}
