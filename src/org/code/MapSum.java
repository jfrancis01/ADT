package org.code;

import java.util.HashMap;

public class MapSum {

	private HashMap<Character, MapSum> children = null;
	private boolean isWord = false;
	private int value = 0;

	public MapSum() {
		children = new HashMap<Character, MapSum>();
	}

	public void insert(String word, int val) {
		insertHelper(word, 0, this, children, val);
	}

	private void insertHelper(String word, int index, MapSum node, HashMap<Character, MapSum> map, int val) {
		if (index >= word.length()) {
			node.isWord = true;
			node.value = val;
			return;
		}
		MapSum child = null;
		if (!map.containsKey(word.charAt(index))) {
			child = new MapSum();
			map.put(word.charAt(index), child);
			insertHelper(word, index + 1, child, child.children, val);
		} else {
			child = map.get(word.charAt(index));
			insertHelper(word, index + 1, child, child.children, val);
		}
	}

	public int sum(String prefix) {
		int sum = 0;
		int index = 0;
		return sumHelper(prefix, index, sum, this);
	}

	public int sumHelper(String prefix, int index, int sum, MapSum node) {
		if (index >= prefix.length()) {
			return 0;
		}
		if (node.children.isEmpty())
			return 0;
		if (!node.children.containsKey(prefix.charAt(index)))
			return 0;
		sum += node.value + sumHelper(prefix, index + 1, sum, node.children.get(prefix.charAt(index)));
		return sum;
	}

	/**
	 * Your MapSum object will be instantiated and called as such: MapSum obj = new
	 * MapSum(); obj.insert(key,val); int param_2 = obj.sum(prefix);
	 */
}
