package org.code;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {

	public static void main(String[] args) {
		int[][] list = {{1,2}, {2,3}, {3,4}, {1,3}};
		Arrays.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] < o2[1]? -1: 1;
			}
			
		});
		
		System.out.println("Sorted");
	}

}
