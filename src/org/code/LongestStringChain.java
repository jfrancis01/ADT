package org.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LongestStringChain {

	public static void main(String[] args) {
		String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
		LongestStringChain lsc = new LongestStringChain();
		System.out.println(lsc.longestStrChain(words));
	}
	public int longestStrChain(String[] words) {
		int longest = 0;
		sortByLength(words);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < words.length; i++) {
			String word = words[i];
			if(map.isEmpty()) {
				map.put(word, 1);
				longest = 1;
			}
			else {
				//here we do the logic to see if we can add and remove a character and search the map
				map.put(word, 1);
				for(int index = 0; index < word.length(); index++) {
					StringBuilder sb = new StringBuilder("");
					if(index == 0) {
						sb.append(word.substring(index + 1));
					}
					else {
						sb.append(word.substring(0, index));
						sb.append(word.substring(index + 1));
					}
					String predecessor = sb.toString();
					if(map.containsKey(predecessor)) {
						map.put(word, Math.max(map.get(word), map.get(predecessor) + 1));
					}
				}
				longest = Math.max(map.get(word), longest);
			}
			
		}
        return longest;
    }
	public void sortByLength(String[] words) {
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(final String s1, final String s2) {
				return s1.length() < s2.length()? -1:1;
			}
		});
	}

}
