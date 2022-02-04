package org.code;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class ReorganizeString {

	String ans = "";

	public String reorganizeString2(String s) {
		permuteHelper(s, "");
		return ans;
	}

	private void permuteHelper(String s, String str) {
		if (s.isEmpty() || s.length() == 0) {
			if (check(str)) {
				ans = str;
				return;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			permuteHelper(s.substring(0, i) + s.substring(i + 1), s.substring(i, i + 1) + str);
		}
	}

	private boolean check(String str) {
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				return false;
			}
		}
		return true;
	}

	class Data {
		char c;
		int freq;

		public Data(char c, int freq) {
			this.c = c;
			this.freq = freq;
		}
	}

	public String reorganizeString(String s) {
		PriorityQueue<Data> pq = new PriorityQueue<Data>(new Comparator<Data>() {
			@Override
			public int compare(Data d1, Data d2) {
				return d1.freq > d2.freq ? -1 : 1;
			}

		});
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}

		Set<Character> keys = map.keySet();
		for (char key : keys) {
			pq.add(new Data(key, map.get(key)));
		}

		StringBuilder sb = new StringBuilder("");
		Data previous = null;
		Data current = null;
		while (!pq.isEmpty()) {
			current = pq.poll();
			if (sb.length() == 0 || sb.charAt(sb.length() - 1) != current.c) {
				sb.append(current.c);
				current.freq = current.freq - 1;
				if (previous == null) {
					previous = current;
				} else {
					if (previous.freq > 0) {
						pq.add(previous);
					}
					previous = current;
				}
			} else {
				return "";
			}
		}
		return pq.isEmpty() && current.freq == 0 && previous.freq == 0? sb.toString():"";
	}

	public static void main(String[] args) {
		ReorganizeString rs = new ReorganizeString();
		System.out.println(rs.reorganizeString("vvvlo"));
	}

}
