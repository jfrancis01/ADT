package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class AlienDictionary {

	public static void main(String[] args) {
		AlienDictionary ad = new AlienDictionary();
		String[] words = { "ab", "adc" };
		System.out.println(ad.alienOrder(words));
	}

	/**
	 * Compare the words in pairs to build the graph, then Topologically order the
	 * words and read them to form the word
	 * 
	 * @param words
	 * @return
	 */
	public String alienOrder(String[] words) {
		StringBuilder sb = new StringBuilder("");
		HashMap<Character, Integer> inDegree = new HashMap<>();
		HashMap<Character, HashSet<Character>> topoGraph = new HashMap<Character, HashSet<Character>>();
		
		for (String word : words) {
            for (char c : word.toCharArray()) {
                topoGraph.put(c, new HashSet<>());
            }
        }
		
		for (int index = 1; index < words.length; index++) {
			String word1 = words[index - 1];
			String word2 = words[index];

			int w1Length = word1.length(); // ett
			int w2Length = word2.length(); // rftt
			int minLength = Math.min(w1Length, w2Length);

			int start = 0;
			while (start < minLength) {
				Character c1 = word1.charAt(start);
				Character c2 = word2.charAt(start);
				if (c1 != c2) {

					if (topoGraph.containsKey(c1)) {
						HashSet<Character> vals = topoGraph.get(c1);
						boolean found = vals.add(c2);
						if (found) {
							inDegree.computeIfPresent(c2, (key, val) -> val + 1);
						}
						topoGraph.put(c1, vals);
					} else {
						HashSet<Character> vals = new HashSet<Character>();
						vals.add(c2);
						inDegree.computeIfPresent(c2, (key, val) -> val + 1);
						topoGraph.put(c1, vals);
					}
				}
				//inDegree.putIfAbsent(c1, 0);
				//inDegree.putIfAbsent(c2, 0);
				start++;
			}
		}
		
		//Now we run the topological sort algorithm 
		//First find the node with 0 in-degree
		while(!inDegree.isEmpty()) {
			boolean found = false;
			Character keyToRemove = null;
			for(Iterator<Character> iterator = inDegree.keySet().iterator(); iterator.hasNext();) {
				Character ckey = iterator.next();
				if(inDegree.get(ckey) == 0) {
					found = true;
					keyToRemove = ckey;
					HashSet<Character> neighbours = topoGraph.getOrDefault(ckey, null);
					if(neighbours != null) {
						//get each of them and reduce their indegrees by 1
						for (Character c : neighbours) {
							inDegree.computeIfPresent(c, (key, val) -> val - 1);
						}
					}
					//remove the current 0 indegree node from the list
					sb.append(ckey);
					break;
				}
			}
			if(!found) return "";
			inDegree.remove(keyToRemove);
		}

		return sb.toString();
	}

}
