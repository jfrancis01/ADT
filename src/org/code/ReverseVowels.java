package org.code;

public class ReverseVowels {

	public static void main(String[] args) {
		ReverseVowels rv = new ReverseVowels();
		System.out.println(rv.reverseVowels("leetcode"));
	}
	
	public String reverseVowels(String s) {
		int i = 0;
		int j = s.length() - 1;
		StringBuilder sb = new StringBuilder(s);
		while(i < j) {
			if(isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
				char temp = s.charAt(i);
				sb.setCharAt(i, s.charAt(j));
				sb.setCharAt(j, temp);
				i++;
				j--;
			}
			else if (!isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
				i++;
			}
			else {
				j--;
			}
		}
		return sb.toString();
	}
	
	public boolean isVowel(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		}
		
		return false;
	}

}
