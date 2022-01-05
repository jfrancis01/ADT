package org.code;

import java.util.HashMap;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
	}

	public String minWindow(String s, String t) {
		if(s.isEmpty() || t.isEmpty()|| s.length() < t.length()) return "";
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
		for (int end = start; end < s.length();) {
			boolean tooMany = false;
			while (!window.equals(omap) && end < s.length()) {
				char ch = s.charAt(end);
				if (omap.containsKey(ch)) {
					if (!window.containsKey(ch)) {
						window.put(ch, 1);
					} else {
						int count = window.get(ch);
						if (count + 1 > omap.get(ch)) {
							tooMany = true;
							start = end;
							break;
						}
						else {
							window.put(ch, window.get(ch) + 1);
						}
					}
				}
				end++;
			}

			if (!tooMany) {
				int tempStart = start;
				while (start < s.length() && !omap.containsKey(s.charAt(start))) {
					++start;
				}
				String str = null;
				str = s.substring(start, end);
				if(ans.isEmpty()) {
					ans = str;
				}
				else {
					if( !str.isEmpty() && str.length() < ans.length()) {
						ans = str;
					}
				}
				start = end-1;
				//System.out.println(str);
			}
			
			window.clear();
		}
		return ans;
	}//the problem is now with duplicates creating an issue
}
