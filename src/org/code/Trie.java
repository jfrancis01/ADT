package org.code;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	class TrieNode {
		Map<Character, TrieNode> children;
		boolean end = false;
	}
	
	private TrieNode root = null;

	public Trie() {
		root = new TrieNode();
		root.children = new HashMap<Character, TrieNode>();
	}

	public void insert(String word) {

		for(int i  = 0; i < word.length(); i++) {
			boolean last =  i == word.length()-1? true:false;
			insertHelper(word.charAt(i), root, last);
		}
	}
	
	private void insertHelper(Character c , TrieNode node, boolean last) {
		if (node.children.isEmpty() || !node.children.containsKey(c)) {
			TrieNode newNode = new TrieNode();
			node.children.put(c, newNode);
			node.end = last;
		}
		else {
			
		}
	}
	public boolean search(String word) {
		return false;
	}

	public boolean startsWith(String prefix) {
		return false;
	}

	public static void main(String[] args) {

	}

}
