package org.code;

import java.util.HashMap;

public class DecodeWays {
	
	public int numDecodings(String s) {
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, Integer> cache = new HashMap<String, Integer>();
		int pos = 1;
		for (int i = 65; i <= 90; i++) {
			map.put(String.valueOf(pos), Character.toString((char) i));
			pos++;
		}
		return numDecodingsHelper(s, map, cache);
	}

	public int numDecodingsHelper(String s, HashMap<String, String> map, HashMap<String, Integer> cache) {
		
		//check cache
		if(cache.containsKey(s)) {
			return cache.get(s);
		}
		
		if (s.isEmpty()) {
			return 1;
		}
		int count = 0;
		String sub = s.substring(0, 1);
		if (map.containsKey(sub)) {
			count += numDecodingsHelper(s.substring(1), map, cache);
		}
		String sub2 = null;
		if (s.length() >= 2) {
			sub2  = s.substring(0, 2);
			if(map.containsKey(sub2)) {
				count += numDecodingsHelper(s.substring(2), map, cache);
			}
			
		}
		//add the count to the cache
		cache.put(s, count);
		return count;
	}
	
	public static void main (String argcv[]) {
		DecodeWays dw = new DecodeWays();
		System.out.println("Total # of ways:  " + dw.numDecodings("1106"));
	}
}
