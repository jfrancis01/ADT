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
		insertHelper(word, 0, this.root);
	}
	
	private void insertHelper(String word, int index , TrieNode node) {
		if(index >= word.length()) {
			node.end = true;
			return;
		}
		if(!node.children.containsKey(word.charAt(index))) {
			TrieNode newNode = new TrieNode();
			newNode.children = new HashMap<Character, TrieNode>();
			if(index == word.length() - 1) {
				newNode.end = true;
			}
			node.children.put(word.charAt(index), newNode);
		}
		insertHelper(word, index + 1, node.children.get(word.charAt(index)));
	}
	
	public boolean search(String word) {
		return searchHelper(word, 0, this.root);
	}
	
	private boolean searchHelper(String word, int index, TrieNode node) {
		if(index >= word.length()) {
			return node.end;
		}
		if(node.children.containsKey(word.charAt(index))) {
			return searchHelper(word, index + 1, node.children.get(word.charAt(index)));
		}
		else {
			return false;
		}
	}

	public boolean startsWith(String prefix) {
		return startsWithHelper(prefix, 0, this.root);
	}
	
	private boolean startsWithHelper(String prefix, int index, TrieNode node) {
		if(index >= prefix.length()) {
			return true;
		}
		if(node.children.containsKey(prefix.charAt(index))) {
			return startsWithHelper(prefix, index + 1, node.children.get(prefix.charAt(index)));
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}

}
