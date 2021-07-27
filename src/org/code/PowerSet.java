package org.code;

import java.util.ArrayList;

/**
 * 
 * @author joel
 * Find the powerset of a set of numbers
 */


public class PowerSet {

	public static void main(String argv[]) {
		int[] arr = {1, 2, 3};
		ArrayList<String> set = powerSet(arr);
		set.forEach(System.out::println);
		
	}
	
	public static ArrayList<String> powerSet(int[] arr) {
		String combo = new String();
		return powerSetHelper(arr, combo, 0, new ArrayList<String>());
	}

	private static ArrayList<String> powerSetHelper(int[] arr, String combo, int start, ArrayList<String> set) {
		
		if(start >= arr.length) {
			if(combo.isEmpty()) {
				set.add("empty");
			}
			set.add(combo);
			return set;
		}
		
		//choose
		combo += String.valueOf(arr[start]);
		//explore
		powerSetHelper(arr, combo, start + 1, set);
		//un-choose
		combo = combo.substring(0, combo.length()- 1);
		powerSetHelper(arr, combo, start + 1, set);
		
		return set;
		
	}

}