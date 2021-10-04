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
		System.out.println(wba.wordBreak(s, wordDict, start));
	}

	public boolean wordBreak(String s, List<String> wordDict, int start) {
		if(start == s.length()) {
			return true;
		}
		for(int end = start; end < s.length(); end++) {
			if(exists(s.substring(start, end), wordDict) && wordBreak (s, wordDict, end + 1));
		}
		return false;
	}
	
	public boolean exists(String word, List<String> wordDict) {
		return wordDict.contains(word);
	}

}
