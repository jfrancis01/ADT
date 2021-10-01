package org.code;

import java.util.ArrayList;
import java.util.List;

public class WordBreakAgain {

	public static void main(String[] args) {
		WordBreakAgain wba = new WordBreakAgain();
		int start = 0;
		String s = "catsandog";
		List<String> wordDict = new ArrayList<String>();	
		wordDict.add("cats");
		wordDict.add("dog");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("cat");
		wba.wordBreak(s, wordDict, start);
	}

	public boolean wordBreak(String s, List<String> wordDict, int start) {
		if(s.length() == 0 || s.isEmpty()) {
			return true;
		}
		for(int i = start; i < s.length(); i++) {
			String word = s.substring(0, i + 1);
			if(exists(word, wordDict)) {
				boolean with = wordBreak(s.substring(i + 1), wordDict, 0);
				boolean without = wordBreak(s, wordDict, i + 1);
			}
		}
		return false;
	}
	
	public boolean exists(String word, List<String> wordDict) {
		return wordDict.contains(word);
	}

}
