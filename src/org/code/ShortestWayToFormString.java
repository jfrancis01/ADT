package org.code;

import java.util.ArrayList;

public class ShortestWayToFormString {

	ArrayList<String> subs = new ArrayList<String>();
	int min = Integer.MAX_VALUE;

	/*
	 * public int shortestWay(String source, String target) {
	 * printSubsequences(source, "", 0); shortestWay(source, target, 0, "", 0);
	 * return min; }
	 */

	public int shortestWay(String source, String target) {
		int ans = 0;
		int j = 0;
		char[] t = target.toCharArray();
		char[] s = source.toCharArray();
		while (j < t.length) {
			int i = 0;
			boolean notFound = true;
			while (i < s.length && j < t.length) {
				if (s[i] == t[j]) {
					j++;
					notFound = false;
				}
				i++;
			}
			if (notFound)
				return -1;
			ans++;
		}
		return ans;
	}

	private void shortestWay(String source, String target, int start, String test, int count) {
		if (test.length() > target.length()) {
			return;
		}
		if (test.length() == target.length()) {
			if (test.equals(target)) {
				min = Math.min(min, count);
			}
			return;
		}
		for (int i = 0; i < subs.size(); i++) {
			shortestWay(source, target, i, test + subs.get(i), count + 1);
		}
	}

	private void printSubsequences(String str, String seq, int start) {
		if (start >= str.length()) {
			if(seq.isEmpty()||seq.isBlank()) return;
			subs.add(seq);
			return;
		}
		char c = str.charAt(start);
		printSubsequences(str, seq + c, start + 1);
		printSubsequences(str, seq, start + 1);
	}

	public static void main(String[] args) {
		ShortestWayToFormString shtway = new ShortestWayToFormString();
		int min = shtway.shortestWay("abc", "abcbc");
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

}
