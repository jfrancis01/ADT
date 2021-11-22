package org.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SynonymousSentences {
	List<String> combo = new ArrayList<String>();

	public static void main(String[] args) {
		List<List<String>> synonyms = new ArrayList<List<String>>();
		ArrayList set1 = new ArrayList<String>();
		set1.add("v");
		set1.add("yr");
		String text = "v v v v yZ";
		synonyms.add(set1);
		SynonymousSentences ss = new SynonymousSentences();
		List<String> ans = ss.generateSentences(synonyms, text);
		for (String val : ans) {
			System.out.println(val);
		}
	}

	public List<String> generateSentences(List<List<String>> synonyms, String text) {

		generateSentencesHelper(0, synonyms, text, combo);
		Collections.sort(combo);
		return combo;

	}

	private void generateSentencesHelper(int start, List<List<String>> synonyms, String text, List<String> combo) {
		if (start >= synonyms.size()) {
			if (!combo.contains(text)) {
				combo.add(text);
			}
			return;
		}
		String[] words = text.split(" ");
		String newText  = "";
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				for(int j  = 0; j < words.length; j++) {
					if(words[j].equals(synonyms.get(start).get(0))) {
						words[j] = synonyms.get(start).get(1);
					}
				}
				newText = String.join(" ", words);
				//take it
				generateSentencesHelper(start + 1, synonyms, newText, combo);
			} else {
				for(int j  = 0; j < words.length; j++) {
					if(words[j].equals(synonyms.get(start).get(1))) {
						words[j] = synonyms.get(start).get(0);
					}
				}
				newText = String.join(" ", words);
				//take it
				generateSentencesHelper(start + 1, synonyms, newText, combo);
			}

		}

	}

}
