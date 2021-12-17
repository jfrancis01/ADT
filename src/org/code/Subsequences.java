package org.code;

public class Subsequences {
	
	public static void main(String[] args) {
		String str = "abc";
		Subsequences sq = new Subsequences();
		sq.printSubsequences(str);
	}
	
	public void printSubsequences(String str) {
		printSubsequences(str, "", 0);
	}
	
	private void printSubsequences(String str, String seq, int start) {
		if(start >= str.length()) {
			System.out.println(seq);
			return;
		}
		char c =  str.charAt(start);
		printSubsequences(str, seq + c, start + 1);
		printSubsequences(str, seq, start + 1);
	}

}
