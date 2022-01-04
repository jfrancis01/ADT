package org.code;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {

	private HashMap<Character, Integer> map = new HashMap<Character, Integer>();

	public int lengthOfLongestSubstring(String s) {
		if (s.isEmpty())
			return 0;
		if (s.length() == 1)
			return 1;
		int left = 0;
		int right = 0;
		int max = Integer.MIN_VALUE;
		while (left < s.length() && right < s.length()) {
			char c = s.charAt(right);
			if (!map.containsKey(c)) {
				map.put(c, right);
			} else {
				int index = map.get(c);
				left = map.get(c);
				map.put(c, right);
				left = index + 1;
				max = Math.max(max, (right - left) + 1);
			}
			right++;
		}
		return max = Math.max(max, (right - left) + 1);
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeating lswrc = new LongestSubstringWithoutRepeating();
		System.out.println(lswrc.lengthOfLongestSubstring("au"));
	}

}
