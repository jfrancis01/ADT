package org.code;

import java.util.LinkedHashMap;

public class CountAndSay {
	
	public static void main(String argv[]) {
		int n = 5;
		CountAndSay cs = new CountAndSay();
		System.out.println(cs.countAndSay(n));
	}
	
	public String countAndSay(int n) {
		
		String start = "1";
		if(n == 1) return start;
		StringBuilder sb = null;
		
		for(int i = 2; i <=n; i++) {
			//use the HashMap to find the frequency of the characters
			LinkedHashMap<Character, Integer> hmap = new LinkedHashMap<Character, Integer>();		
			for(int j = 0; j < start.length(); j++) {
				hmap.put(start.charAt(j), hmap.getOrDefault(start.charAt(j), 0) + 1);
			}
			sb = new StringBuilder("");
			for(Character key : hmap.keySet()) {
				int num = hmap.get(key);
				sb.append(num);
				sb.append(key);
			}
			start =sb.toString();
		}
		
		return sb.toString();
	}
}
