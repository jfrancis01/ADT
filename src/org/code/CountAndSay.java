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
		StringBuilder sb = new StringBuilder("");
		for(int j = 2; j <= n ; j++) {
			char c = start.charAt(0);
			int count = 1;
			for(int i = 1; i < start.length(); i ++) {
				if(c != start.charAt(i)) {
					sb.append(count);
					sb.append(c);
					count = 1;
					c = start.charAt(i);
				}
				else {
					count++;
				}
			}
			//don't forget to append the last character, if they are all the same
			//this will work as well.
			sb.append(count);
			sb.append(c);
			start = sb.toString();
			sb.setLength(0);
		}
		return start;
	}
}
