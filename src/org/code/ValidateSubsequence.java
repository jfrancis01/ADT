package org.code;

import java.util.ArrayList;
import java.util.List;

public class ValidateSubsequence {

	public boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		int ptr = 0;
		int i;
		boolean found = false;
		if (sequence.size() > array.size())
			return false;
		for (i = 0; i < sequence.size(); i++) {
			int num = sequence.get(i);
			while (ptr != array.size()) {
				if (array.get(ptr) == num) {
					found = true;
					break;
				}
				ptr++;
			}
			if (found) {
				found = false;
				ptr++;
			}
			else {
				return false;
			}
		}
		if (i >= sequence.size())
			return true;
		return false;
	}
	
	public static void main(String argv[]) {
		List<Integer> array = new ArrayList<Integer>();
		array.add(5);
		array.add(1);
		array.add(22);
		array.add(25);
		array.add(6);
		array.add(-1);
		array.add(8);
		array.add(10);
		List<Integer> sequence = new ArrayList<Integer>();
		sequence.add(1);
		sequence.add(6);
		sequence.add(-1);
		sequence.add(10);
		ValidateSubsequence vsq = new ValidateSubsequence();
		System.out.print(vsq.isValidSubsequence(array, sequence));
	}
}
