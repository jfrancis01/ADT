package org.code;

import java.util.LinkedHashMap;

public class CountAndSay {
	
	public static void main(String argv[]) {
		int n = 2;
		CountAndSay cs = new CountAndSay();
		System.out.println(cs.countAndSay(n));
	}
	
	public String countAndSay(int n) {
		
		String start = "55555";
		if(n == 1) return start;
		StringBuilder sb = new StringBuilder("");
		int count = 0;
		int i = 0;
		int j = i;
		while(i <= start.length() - 1) {
			j = i;
			while(j <= start.length() - 1) {
				if(start.charAt(i) == start.charAt(j)) {
					count++;
					j++;
				}
				else {
					i = j;
					sb.append(count);
					sb.append(start.charAt(i));
					break;
				}
			}
		}
		//after it exits this loop add the last character to the end
		return sb.toString();
	}
}
