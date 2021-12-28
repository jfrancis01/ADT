package org.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AlienDictionary {

	ConcurrentHashMap<String, HashSet<String>> graph = new ConcurrentHashMap<String, HashSet<String>>();
	ConcurrentHashMap<String, Integer> indegree = new ConcurrentHashMap<String, Integer>();

	public String alienOrder(String[] words) {
		StringBuilder sb = new StringBuilder("");
		for (String word : words) {
			for (char c : word.toCharArray()) {
				indegree.put(c + "", 0);
				graph.put(c + "", new HashSet<String>());
			}
		}
		buildGraph(words);
		// now that the graph is built, we implement Khan's Algorithm
		Queue<String> queue = new LinkedList<String>();
		// add all zero indegree's to the list
		Set<String> keys = indegree.keySet();
		for (String key : keys) {
			if (indegree.get(key) == 0) {
				queue.add(key);
			}
		}
		while (!queue.isEmpty()) {
			String c = queue.poll();
			sb.append(c);
			// find all the neighbours and reduce indegree by 1
			HashSet<String> children = graph.get(c);
			for (String child : children) {
				int degree = indegree.get(child);
				--degree;
				if (degree == 0) {
					queue.add(child);
				} else {
					indegree.put(child, degree);
				}
			}
		}
		return sb.toString();
	}

	private void buildGraph(String[] words) {
		int left = 0;
		int right = left + 1;

		while (left < words.length && right < words.length) {
			String word1 = words[left];
			String word2 = words[right];

			int length = word1.length();
			if (word1.length() > word2.length() && word1.startsWith(word2)) {
				return;
			}
			if (word1.length() > word2.length()) {
				length = word2.length();
			}
			int index = 0;
			while (index < length) {
				char c1 = word1.charAt(index);
				char c2 = word2.charAt(index);
				if (c1 == c2) {
					if (!graph.containsKey(c1 + "")) {
						graph.put(c1 + "", new HashSet<String>());
					}
					if (!indegree.containsKey(c1 + "")) {
						indegree.put(c1 + "", 0);
					}
					index++;
				} else {
					if (!graph.containsKey(c1 + "")) {
						graph.put(c1 + "", new HashSet<String>());
					}
					if (!graph.containsKey(c2 + "")) {
						graph.put(c2 + "", new HashSet<String>());
					}

					HashSet<String> children = graph.get(c1 + "");
					boolean added = children.add(c2 + "");
					graph.put(c1 + "", children);

					if (!indegree.containsKey(c1 + "")) {
						indegree.put(c1 + "", 0);
					}
					if (!indegree.containsKey(c2 + "")) {
						indegree.put(c2 + "", 0);
					}

					if (added) {
						indegree.put(c2 + "", indegree.get(c2 + "") + 1);
					}

					break;
				}
			}
			left++;
			right++;
		}
	}

	public static void main(String[] args) {
		String[] words = { "ac", "ab", "zc", "zb" };
		AlienDictionary ad = new AlienDictionary();
		System.out.println(ad.alienOrder(words));
	}

}
