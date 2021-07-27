package org.code;

public class PalindromeNumber {
	
	public static void main(String argv[]) {
		int x = 121;
		System.out.println(isPalindrome(x));
	}
	
	public static boolean isPalindrome(int x) {
        Long num = new Long(x);
        Long reverse = 0L;
        while(num != 0){
            long last = num % 10;
            num = num/10;
            reverse = reverse * 10 + last;
        }
        return reverse == (long)x;
    }

}
