package org.code;

public class IsSubsequence {

	public static void main(String[] args) {
		IsSubsequence iss = new IsSubsequence();
		System.out.println(iss.isSubsequence("acb", "ahbgdc"));
	}

	public boolean isSubsequence(String s, String t) {
		int i = 0;
		int last = 0;
		int found = 0;
		if (s.length() > t.length())
			return false;
		while (i < s.length() && s.length() - i <= t.length() - last) {
			found = t.indexOf(s.charAt(i), last);
			if (found == -1) {
				return false;
			}
			last = found + 1;
			i++;
		}
		if (i > s.length())
			return true;
		return false;
	}

}
