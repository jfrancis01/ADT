package org.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SetIt {

	public static void main(String[] args) {
		HashSet<Character> set = new HashSet<Character>();
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		set.add('f');
		set.add('u');
		set.add('c');
		set.add('k');
		Iterator<Character> it = set.iterator();
		while (it.hasNext()) {
			char c = it.next();
			if (count.containsKey(c)) {
				count.put(c, count.get(c) + 1);
			} else {
				count.put(c, 1);
			}
		}
	}
}
