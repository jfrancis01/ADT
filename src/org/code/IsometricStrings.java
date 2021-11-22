package org.code;

import java.util.HashMap;
import java.util.HashSet;

public class IsometricStrings {

	public boolean isIsomorphic(String str1, String str2) {
		  HashMap<Character, Character> characterMap = new HashMap<>();
	        HashSet<Character> used = new HashSet<>();
	        if (str1.length() != str2.length()) {
	            return false;
	        }
	        int n = str1.length();
	        for (int i = 0; i < n; i++) {
	            char aChar = str1.charAt(i);
	            char bChar = str2.charAt(i);
	            if (characterMap.containsKey(aChar)) {
	                if (characterMap.get(aChar) != bChar) {
	                    return false;
	                }
	            } else {
	                if (used.contains(bChar)) {
	                    return false;
	                }
	                characterMap.put(aChar, bChar);
	                used.add(bChar);
	            }
	        }
	        return true;
	}

	public static void main(String argv[]) {
		IsometricStrings is = new IsometricStrings();
		System.out.println(is.isIsomorphic("paper", "title"));
	}

}
