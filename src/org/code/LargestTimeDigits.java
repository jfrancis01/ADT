package org.code;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestTimeDigits {

	String maxTime = "";;

	public String largestTimeFromDigits(int[] arr) {
		ArrayList<Integer> choices = new ArrayList<Integer>();
		for (int val : arr) {
			choices.add(val);
		}
		largestTimeFromDigitsHelper( choices, new ArrayList<Integer>());
		if (maxTime.isBlank() || maxTime.isEmpty())
			return "";
		return maxTime.substring(0, 2) + ":" + maxTime.substring(2);
	}

	private void largestTimeFromDigitsHelper( ArrayList<Integer> choices, ArrayList<Integer> combo) {
		if (choices.size() == 0) {
			StringBuilder sb = new StringBuilder("");
			for (int val : combo) {
				sb.append(val);
				System.out.print(val + " ");
			}
			System.out.println();
			if (isValid(sb.toString())) {
				if (maxTime.isEmpty() || maxTime.isBlank()) {
					maxTime = sb.toString();
				} else {
					maxTime = Integer.parseInt(maxTime) > Integer.parseInt(sb.toString()) ? maxTime : sb.toString();
				}
			}

			return;
		}

		for (int index = 0; index < choices.size(); index++) {
			int num = choices.get(index);
			choices.remove(index);
			combo.add(num);
			// explore
			largestTimeFromDigitsHelper( choices, combo);
			// unchoose
			combo.remove(combo.size() - 1);
			choices.add(index, num);
		}
	}

	private boolean isValid(String str) {
		 
	    int hour = Integer.valueOf( str.substring(0,2));
	    int minute = Integer.valueOf( str.substring(2, 4));

	    return hour < 24 && minute <= 59;
	}

	public static void main(String argv[]) {
		int[] arr = { 1,9,6,0};
		LargestTimeDigits ltd = new LargestTimeDigits();
		System.out.println(ltd.largestTimeFromDigits(arr));
	}

}
