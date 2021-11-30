package org.code;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	List<List<String>> ans = new ArrayList<List<String>>();

	public List<List<String>> partition(String s) {
		int start = 0;
		ArrayList<String> combo = new ArrayList<String>();
		partitionHelper(s, combo);
		return ans;
	}

	private void partitionHelper(String s, ArrayList<String> combo) {
		if(s.isBlank() || s.isEmpty()) {
			ans.add((List<String>) combo.clone());
			return;
		}
		for(int i  = 0; i < s.length(); i++) {
			String word = s.substring(0, i + 1);
			if(isPalindrome(word)) {
				combo.add(word);
				partitionHelper(s.substring(i + 1), combo );
				combo.remove(combo.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s) {
		StringBuilder str = new StringBuilder(s);
		str.reverse();
		return s.equals(str.toString());
	}

	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		List<List<String>> ans  = pp.partition("ccaab");
		for(List<String> combo : ans) {
			for(String str: combo) {
				System.out.print(str +  " ");
			}
			System.out.println();
		}
	}

}
