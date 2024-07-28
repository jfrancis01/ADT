package org.code;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	/**
	 * TrieNode data structure inner class
	 */
	class TrieNode {
		Map<Character, TrieNode> children;
		boolean end = false;
	}
	
	private TrieNode root = null;

	public Trie() {
		root = new TrieNode();
		root.children = new HashMap<Character, TrieNode>();
		root.end = false;
	}

	public void insert(String word) {

		for(int i  = 0; i < word.length(); i++) {
			boolean last = i == word.length()-1? true:false;
			insertHelper(word.charAt(i), root, last);
		}
	}
	
	private void insertHelper(Character c , TrieNode node, boolean last) {
		if(node.end == false) {
			return;
		}
		
	}
	public boolean search(String word) {
		return false;
	}

	public boolean startsWith(String prefix) {
		return false;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
	}

}
