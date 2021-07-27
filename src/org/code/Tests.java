package org.code;

import java.util.ArrayList;

public class Tests {
	
	public static void main(String args[]) {
		ArrayList<int[]> test = new ArrayList<>();
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {5,6,7,};
		
		test.add(arr1);
		test.add(arr2);
		
		int[] newArray = {arr1[0], arr2[0], arr1[3]};
		System.out.println("worked?");
	}

}
