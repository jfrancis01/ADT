package org.code;

import java.util.HashMap;

public class LongestRepeatingSubstring {

	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
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
				max = Math.max(max, (right - left) + 1);
			} else {
				int index = map.get(c);
				left = Math.max(left, index + 1);
				map.put(c, right);
				max = Math.max(max, (right - left) + 1);
			}
			right++;
		}
		return max;
	}

	public static void main(String[] args) {
		LongestRepeatingSubstring lrs = new LongestRepeatingSubstring();
		System.out.println(lrs.lengthOfLongestSubstring("dvdf"));
	}

}
