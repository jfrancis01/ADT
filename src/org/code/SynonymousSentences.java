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
			if(!combo.contains(text)) {
				combo.add(text);
			}
			return;
		}
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				Pattern word = Pattern.compile("\\b" + synonyms.get(start).get(0) + "\\b");
				Matcher match = word.matcher(text);
				String synonym = synonyms.get(start).get(1);
				if (match.find()) {// if the word is present
					generateSentencesHelper(start + 1, synonyms,
							text.substring(0, match.start()) + synonym + text.substring(match.end()), combo);
				}
				// or don't take the first set
				generateSentencesHelper(start + 1, synonyms, text, combo);
			}
			else {
				Pattern word = Pattern.compile("\\b" + synonyms.get(start).get(1) + "\\b");
				Matcher match = word.matcher(text);
				String synonym = synonyms.get(start).get(0);
				if (match.find()) {// if the word is present
					generateSentencesHelper(start + 1, synonyms,
							text.substring(0, match.start()) + synonym + text.substring(match.end()), combo);
				}
				// or don't take the first set
				generateSentencesHelper(start + 1, synonyms, text, combo);
			}

		}

	}

}
