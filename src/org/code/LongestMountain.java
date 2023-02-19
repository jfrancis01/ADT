package org.code;

public class LongestMountain {

	public static void main(String[] args) {
		int[] array = {2,3,3,2,0,2};
		LongestMountain lm = new LongestMountain();
		System.out.println(lm.longestMountain(array));
	}

	public int longestMountain(int[] array) {
		int pos = 0;
		int i = pos;
		int j = i + 1;
		int epos = j;
		boolean hasPos = false;
		int maxLength = Integer.MIN_VALUE;
		while (i < array.length && j < array.length) {
			if (array[j] > array[i]) {
				i++;
				j++;
				hasPos = true;
			} else if (array[j] == array[i]) {
				pos = j;
				i = pos;
				j = i + 1;
				hasPos = false;
			} else {
				if (i == 0) {
					++i;
					pos = i;
					j = i + 1;
				} else {
					if (!hasPos) {
						++pos;
						i = pos;
						j = i + 1;
						epos = j;
					} else {
						epos = j;
						while (j < array.length && j + 1 < array.length && array[j + 1] < array[j]) {
							j++;
						}
						int curr = (j - pos) + 1;
						if (curr > 2 && hasPos) {
							maxLength = Math.max(maxLength, curr);
						}
						i = epos;
						pos = i;
						j = i + 1;
					}
				}
			}
		}
		return maxLength > Integer.MIN_VALUE ? maxLength : 0;
	}
}
