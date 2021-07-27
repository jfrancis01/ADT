package org.code;

public class CheckPalindrome {
	
	public static void main (String argv[]) {
		String s = "ppq";
		System.out.println(s + " is palindrome: " + isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		return isPalindromeHelper(s, start, end);
	}
	
	public static boolean isPalindromeHelper(String s, int start, int end) {
		if(start >= end) {
			return true;
		}
		return s.charAt(start) == s.charAt(end) && isPalindromeHelper(s, ++start, --end);
	}
}
