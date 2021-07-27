package org.code;

public class LCS {

	public int longestCommonSubsequence(String text1, String text2) {
		int[][] cache = new int[text1.length()][text2.length()];
		StringBuilder sb1 = new StringBuilder(text1);
		StringBuilder sb2 = new StringBuilder(text2);
		return LCSHelper(sb1, sb2, 0, 0, cache);
	}

	public int LCSHelper(StringBuilder sb1, StringBuilder sb2, int i, int j, int[][] cache) {

		if (i >= sb1.length() || j >= sb2.length()) {
			return 0;
		}

		else if (cache[i][j] != 0) {
			return cache[i][j];
		}

		else if (sb1.charAt(i) == sb2.charAt(j)) {
			cache[i][j] = 1 + LCSHelper(sb1, sb2, i + 1, j + 1, cache);
			return cache[i][j];

		} else {
			return Math.max(LCSHelper(sb1, sb2, i + 1, j, cache), LCSHelper(sb1, sb2, i, j + 1, cache));
		}
	}

}
