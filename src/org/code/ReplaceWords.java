package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {

	public static void main(String[] args) {
		List<String> dict = new ArrayList<String>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
		String sentence = "the cattle was rattled by the battery";
		ReplaceWords rp = new ReplaceWords();
		System.out.println(rp.replaceWords(dict, sentence));
	}

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean isWord;

		public TrieNode() {
			children = new HashMap<Character, TrieNode>();
			isWord = false;
		}
	}

	public String replaceWords(List<String> dictionary, String sentence) {
		TrieNode root = new TrieNode();
		// add all the roots into the tree.
		for (String str : dictionary) {
			insertWord(str, root, root, 0);
		}
		StringBuilder sb = new StringBuilder("");
		// go through the sentence and search for prefixes
		String[] words = sentence.split(" ");
		for (String str : words) {
			String ans = searchWord(str, root, 0);
			if (ans.isBlank() || ans.isEmpty()) {
				sb.append(str + " ");
			} else {
				sb.append(ans + " ");
			}
		}
		return sb.toString().trim();
	}

	private void insertWord(String word, TrieNode parent, TrieNode node, int index) {
		if (index >= word.length()) {
			parent.isWord = true;
			return;
		}

		TrieNode n = null;
		if (!(node.children.containsKey(word.charAt(index)))) {
			n = new TrieNode();
			node.children.put(word.charAt(index), n);
		} else {
			n = node.children.get(word.charAt(index));
		}
		insertWord(word, node, n, index + 1);
	}

	private String searchWord(String word, TrieNode node, int index) {
		if (index >= word.length() || !(node.children.containsKey(word.charAt(index)))) {
			return "";
		}
		if(node.isWord) {
			return word.substring(0, index + 1);
		}
		return searchWord(word, node.children.get(word.charAt(index)), index + 1);
	}

}
