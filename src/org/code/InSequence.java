package org.code;

public class InSequence {
	
	public static void main(String argv[]) {
		int[] arr = {2,4,5,6,7};
		System.out.println(isInSequence(arr.length - 1, arr));
	}
	
	public static boolean isInSequence(int start, int[] arr) {
		if(start == 0) {
			return true;
		}
		return arr[start - 1] == arr[start] - 1 && isInSequence(start - 1, arr);
	}
}
