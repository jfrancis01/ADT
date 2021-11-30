package org.code;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	
	List<List<String>> ans = new ArrayList<List<String>>();

	public List<List<String>> partition(String s) {
		int start  = 0;
		
	}

	public static void main(String[] args) {
		
		PalindromePartitioning pp = new PalindromePartitioning();
		pp.partition("aab");
	}
	
	private boolean isPalindrome(String s) {
		StringBuilder str = new StringBuilder(s);
		str.reverse();
		return s.equals(str.toString());
	}

}
