package org.code;

public class DistinctSubsequence {

	public static void main(String[] args) {
		String  s = "rabbbit";
		String t = "rabbit";
		DistinctSubsequence ds = new DistinctSubsequence();
		System.out.println(ds.numDistinct(s, t));
	}

	public int numDistinct(String s, String t) {
		int count = 0;
		count  += helper(s, t, 0, "");
		return count;
	}
	
	public int helper(String s, String t, int i, String combo) {
		
		if(combo.equals(t)) {
			return 1;
		}
		
		if(combo.length() > t.length()) {
			return 0;
		}
		
		if(i >= s.length()) {
			return 0;
		}
		int with  = 0;
		int without = 0;
		with = helper(s, t, i + 1, combo + s.charAt(i));
		without = helper(s, t, i + 1, combo);
	
		return with + without;
	}

}
