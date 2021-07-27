package org.code;

public class ArrayIntegerLimit {
	
	static int count = 0;
	
	public static void main(String argv[]) {
		int[] arr1 = {2,3,5};
		int[] arr2 = {5};
		int[] arr3 = {2,3,10};
		int[] arr4 = {1, 2};
		int target = 11;
		getWays(arr1, arr2, arr3, arr4, 0, 0, 0, 0, arr1.length, arr2.length, arr3.length, arr4.length, target);
		System.out.println(count);
	}
	
	public static void getWays(int[] arr1, int[] arr2, int[] arr3, int[] arr4, int start1, int start2, int start3, int start4, 
int end1, int end2, int end3, int end4, int target) {
		
		if(start1 >= end1 || start2 >= end2 || start3 >= end3 || start4 >= end4) {
			return;
		}
		if(arr1[start1] + arr2[start2] + arr3[start3] + arr4[start4] <= target) {
			System.out.println(arr1[start1] + " " + arr2[start2]+ " " + arr3[start3]+ " " + arr4[start4]);
			count++;
		}
		
		getWays(arr1, arr2, arr3, arr4, start1 + 1, start2, start3, start4, end1, end2, end3, end4, target);
		getWays(arr1, arr2, arr3, arr4,start1, start2 + 1, start3, start4, end1, end2, end3, end4, target);
		getWays(arr1, arr2, arr3, arr4,start1, start2, start3 + 1, start4, end1, end2, end3, end4, target);
		getWays(arr1, arr2, arr3, arr4,start1, start2, start3, start4 + 1, end1, end2, end3, end4, target);
	}
	

}
