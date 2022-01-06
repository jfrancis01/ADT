package org.code;

import java.util.HashMap;
import java.util.Set;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
	}

	public String minWindow(String s, String t) {
		if (s.isEmpty() || t.isEmpty() || s.length() < t.length())
			return "";
		String ans = "";

		HashMap<Character, Integer> omap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> window = new HashMap<Character, Integer>();

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (!omap.containsKey(c)) {
				omap.put(c, 1);
			} else {
				omap.put(c, omap.get(c) + 1);
			}
		}

		int start = 0;
		int end = 0;
		while (start < s.length() && end < s.length()) {
			while (!areMapsEqual(omap, window) && end < s.length()) {
				char ch = s.charAt(end);
				if (omap.containsKey(ch)) {
					if (!window.containsKey(ch)) {
						window.put(ch, 1);
					} else {
						window.put(ch, window.get(ch) + 1);
					}
				}
				end++;
			}
			int tempStart = start;
			if (areMapsEqual(omap, window)) {
				while (start <= end) {
					char c = s.charAt(start);
					if (!omap.containsKey(c)) {
						++start;
					} else if (omap.containsKey(c)) {
						int count = window.get(c);
						if (!(count - 1 >= omap.get(c))) {
							break;
						} else {
							window.put(c, window.get(c) - 1);
							++start;
						}
					}
				}
				String str = null;
				str = s.substring(start, end);
				if (ans.isEmpty()) {
					ans = str;
				} else {
					if (!str.isEmpty() && str.length() < ans.length()) {
						ans = str;
					}
				}
				start = tempStart;
				start++;
				end = start;
				//System.out.println(str);
			}

			window.clear();
		}
		return ans;
	}

	private boolean areMapsEqual(HashMap<Character, Integer> omap, HashMap<Character, Integer> window) {
		Set<Character> omapKeys = omap.keySet();
		Set<Character> windowKeys = window.keySet();
		for (char c : omapKeys) {
			if (!windowKeys.contains(c)) {
				return false;
			} else {
				int count = window.get(c);
				if (!(count >= omap.get(c))) {
					return false;
				}
			}
		}
		return true;
	}
}
