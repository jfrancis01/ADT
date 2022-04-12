package org.code;

public class DistinctSubsequence {

	public static void main(String[] args) {
		String  s = "babgbag";
		String t = "bag";
		DistinctSubsequence ds = new DistinctSubsequence();
		System.out.println(ds.numDistinct(s, t));
	}

	public int numDistinct(String s, String t) {
		int count = 0;
		int[] cache = new int[s.length()];
		for(int i = 0; i < cache.length; i++) {
			cache[i] = -1;
		}
		count  += helper(s, t, 0, "", cache);
		return count;
	}
	
	public int helper(String s, String t, int i, String combo, int[] cache) {
		
		if(combo.equals(t)) {
			return 1;
		}
		
		if(combo.length() > t.length()) {
			return 0;
		}
		
		if(i >= s.length()) {
			return 0;
		}
		//if(cache[i] != -1) {
		//	return cache[i];
		//}
		int with  = 0;
		int without = 0;
		with = helper(s, t, i + 1, combo + s.charAt(i), cache);
		without = helper(s, t, i + 1, combo, cache);
		cache[i] = with + without;
		return with + without;
	}

}
