package org.code;

public class PlusOne {

	public static void main(String[] args) {
		int[] digits = { 1, 2, 3 };
		PlusOne po = new PlusOne();
		int[] ans = po.plusOne(digits);
		for (int i : ans) {
			System.out.print(i);
		}
	}

	public int[] plusOne(int[] digits) {
		int length = digits.length - 1;
		// the last element is not 9
		if (digits[length] < 9) {
			digits[length]++;
			return digits;
		}
		for (int i = length; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i]++;
				break;
			}
		}
		if (digits[0] == 0) {
			int[] newArray = new int[digits.length + 1];
			newArray[0] = 1;
			return newArray;
		}
		return digits;
	}

}
