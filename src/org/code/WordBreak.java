package org.code;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string s and a a dictionay containing a list of words, write a
 * function to break the string completely into valid words, Print all such
 * possible sentences. The same word in the dictionary may be reused multiple
 * times.
 */
public class WordBreak {
	
	public static List<String> ans = new ArrayList<String>();
	
	public static void main(String argv[]) {
		String s = "catsanddog";
		List<String> wordDic = new ArrayList();
		wordDic.add("cat");
		wordDic.add("cats");
		wordDic.add("and");
		wordDic.add("sand");
		wordDic.add("dog");
		wordBreak(s, wordDic);
		String s2= "pineapplepenapple";
		List<String> wordDic2 = new ArrayList();
		wordDic2.add("apple");
		wordDic2.add("pen");
		wordDic2.add("applepen");
		wordDic2.add("pine");
		wordDic2.add("pineapple");
		wordBreak(s2, wordDic2);
	}
	
	public static List<String> wordBreak(String s, List<String> wordDict) {
		wordBreakHelper(s, wordDict, "", "");
		return ans;
	}
	
	public static void wordBreakHelper(String s, List<String> wordDict , String combo, String current){
		if(s.isEmpty() || s.isBlank()) {
			System.out.print(combo);
			System.out.println();
			//ans.add(combo.trim());
			return;
		}
		for(int i = 0; i < s.length(); i++) {
			String val  = s.substring(i, i+1);
			current+=val;
			if(isValidWord(current, wordDict)) {
				String temp = combo;
				combo+= current + " ";
				wordBreakHelper(s.substring(i + 1), wordDict, combo, "");
				combo=temp;
			}
		}
	}
	
	public static boolean isValidWord(String combo, List<String> wordDict) {
		for(String str: wordDict) {
			if(str.equalsIgnoreCase(combo)) {
				return true;
			}
		}
		return false;
	}
}
