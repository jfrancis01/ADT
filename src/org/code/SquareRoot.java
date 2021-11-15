package org.code;

public class SquareRoot {

	public int squareRoot(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		int left = 2;
		int right = n;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (mid * mid == n)
				return mid;
			else if (mid * mid > n)
				right = mid - 1;
			else
				left = mid - 1;
		}
		return left;
	}
	
	public static void main(String argv[]) {
		int n = 8;
		SquareRoot sqr = new SquareRoot();
		System.out.println(sqr.squareRoot(n));
	}

}
