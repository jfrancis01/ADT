package org.code;

public class Subsequence {

	public static void main(String[] args) {
		Subsequence sq = new Subsequence();
		System.out.println(sq.isSubsequence("abc", "ahbgdc"));

	}

	public boolean isSubsequence(String s, String t) {
		if (s.isEmpty() || s.equals(t))
			return true;
		return helper(s, t, "");
	}

	public boolean helper(String s, String t, String ans) {

		if(ans.equals(s)) {
			return true;
		}
		if(t.length() == 0) {
			return false;
		}
		
		boolean with = helper(s, t.substring(1), ans + t.charAt(0));
		boolean without = helper(s, t.substring(1), ans);
		
		if(with || without) return true;
		return false;
	}

}
