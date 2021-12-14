package org.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.length() != endWord.length()) {
			return 0;
		}
		HashSet<String> wordSet = new HashSet(wordList);
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		wordList.remove(beginWord);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				String current = queue.poll();
				if (current.equals(endWord))
					return level;
				for (int i = 0; i < current.length(); i++) {
					char c = current.charAt(i);
					for (char temp = 'a'; temp <= 'z'; temp++) {
						String word = current.substring(0, i) + temp + current.substring(i + 1);
						if (wordSet.contains(word)) {
							queue.add(word);
							wordSet.remove(word);
						}
					}
				}
				--size;
			}
			++level;
		}
		return 0;
	}

	public static void main(String[] args) {
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");

		String beginWord = "hit";
		String endWord = "cog";
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength(beginWord, endWord, wordList));
	}

}
