package org.code;

public class LongsestPalindromeSubstring2 {

	public static void main(String[] args) {
		LongsestPalindromeSubstring2 lps2 = new LongsestPalindromeSubstring2();
		String s= "babad";
		System.out.println(lps2.longestPalindrome(s));
	}

	public String longestPalindrome(String s) {
		String oddlongest = "";
		for(int i = 0; i < s.length(); i++) {
			
			int left = i;
			int right = i;
			while(left >=0 && right <= s.length() - 1) {
				if(s.charAt(left) == s.charAt(right)) {
					left--;
					right++;
				}
				else {
					break;
				}
			}
			String current = s.substring(left + 1, right);
			if(current.length() > oddlongest.length()) {
				oddlongest = current;
			}
		}
		
		String evenlongest = "";
		for(int i = 0; i < s.length(); i++) {
			
			int left = i;
			int right = i + 1;
			while(left >=0 && right <= s.length() - 1) {
				if(s.charAt(left) == s.charAt(right)) {
					left--;
					right++;
				}
				else {
					break;
				}
			}
			String current = s.substring(left + 1, right);
			if(current.length() > evenlongest.length()) {
				evenlongest = current;
			}
		}
		return oddlongest.length() > evenlongest.length()? oddlongest : evenlongest;
	}

}
