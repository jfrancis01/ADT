package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {

	private List<Integer> ans = new ArrayList<>();

	public static void main(String[] args) {
		FindAllAnagrams faa = new FindAllAnagrams();
		faa.findAnagrams("baa", "aa");
		for (int val : faa.ans) {
			System.out.print(val + " ");
		}
	}

	public List<Integer> findAnagrams(String s, String p) {
		if (p.length() > s.length())
			return ans;
		HashMap<Character, Integer> omap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> window = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (!omap.containsKey(c)) {
				omap.put(c, 1);
			} else {
				omap.put(c, omap.get(c) + 1);
			}
		}
		
		for(int start = 0; start < s.length(); start++) {
			char c = s.charAt(start);
			//add it to the window
			if(!window.containsKey(c)) {
				window.put(c, 1);
			}
			else {
				window.put(c, window.get(c) + 1);
			}
			//check the current length
			if(start >= p.length()) {
				char ch = s.charAt(start - p.length());
				if(window.get(ch) == 1) {
					window.remove(ch);
				}
				else {
					window.put(ch, window.get(ch) -1);
				}
			}
			
			if(omap.equals(window)) {
				ans.add(start - p.length() + 1);
			}
			
		}
		
		return ans;
	}

	/**
	 * The time limit was exceeded. Going to try another approach
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public List<Integer> findAnagrams2(String s, String p) {

		if (p.length() > s.length())
			return ans;
		HashMap<Character, Integer> omap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> window = new HashMap<Character, Integer>();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (!omap.containsKey(c)) {
				omap.put(c, 1);
			} else {
				omap.put(c, omap.get(c) + 1);
			}
		}
		int start = 0;
		int end = 0;
		int length = p.length();
		int currentLength = 0;
		while (start < s.length() && end < s.length()) {
			end = start;
			while (end < s.length()) {
				char c = s.charAt(end);
				if (!omap.containsKey(c)) {
					++start;
					window.clear();
					currentLength = 0;
					break;
				} else {
					if (!window.containsKey(c)) {
						window.put(c, 1);
					} else {
						window.put(c, window.get(c) + 1);
						if (window.get(c) > omap.get(c)) {
							++start;
							window.clear();
							currentLength = 0;
							break;
						}
					}

					currentLength = end - start + 1;
					if (currentLength == length) {
						ans.add(start);
					}
					end++;
				}
			}
		}
		return ans;
	}

}
