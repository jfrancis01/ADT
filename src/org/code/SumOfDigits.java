package org.code;

public class SumOfDigits {
	public static void main(String argv[]) {
		int num = 123456;
		System.out.println(sumOfDigits(num));
	}
	public static int sumOfDigits(int num) {
		if(num == 0) {
			return 0;
		}
		 return num%10 + sumOfDigits(num/10);
	}
}
