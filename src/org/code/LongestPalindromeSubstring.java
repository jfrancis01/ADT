package org.code;

public class LongestPalindromeSubstring {

    public static void main(String argv[]){
        System.out.println("Answer: " + longestPalindrome2("abadd"));
    }

    /**
     * This is the brute force O(n^2) approach.
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s.length() == 1 || s.isEmpty()) return s;

        int maxSize = 1;
        int currentSize = 0;
        String maxPal = String.valueOf(s.charAt(0));
        for(int i = 0; i <= s.length() - 1; i++){
            String current = String.valueOf(s.charAt(i));
            StringBuilder word = new StringBuilder("");
            word.append(current);
            for(int j = i + 1; j <= s.length() - 1; j++){
                word.append(String.valueOf(s.charAt(j)));
                int length = checkPalindrome(word.toString());
                if(length > maxSize){
                    maxSize = length;
                    maxPal = word.toString();
                }
            }
        }
        return maxPal;
    }

    public static int checkPalindrome(String currentString){
        if(currentString.equalsIgnoreCase(new StringBuilder(currentString).reverse().toString())){
            return currentString.length();
        }
        return 0;
    }

    /**
     * Expand from the center
     *  0 1 2
     *  a b a
     *
     *  index = 1
     *  left = 0
     *  right = 2
     *  2 - 0 + 1 = 3 is the total length;
     */
    public static String longestPalindrome2(String s){
    	String res1 = "";
    	String res2 = "";
    	int sLen = s.length();
    	if(s.isEmpty() || s.contentEquals(" ") || s == null) return "";
    	if(sLen == 1) return s;
    	char[] chars = s.toCharArray();
    	//we need to check for even and odd palindrome
    	res1 = palHelper(chars, true, s);
    	res2 = palHelper(chars, false, s);
    	if(res1.length() > res2.length()) {
    		return res1;
    	}
    	return res2;
    }
    
    public static String palHelper(char[] chars, boolean checkOdd, String s) {
    	String res = "";
		int i;
		int sLen = chars.length;
    	int count = 0;
    	int start;
    	int end;
    	
    	if(checkOdd) {
        	for(i = 0; i < sLen; i++) {
        		start = i;
        		end = i;
        		while(start >= 0 && end<= sLen - 1 && chars[start] == chars[end] ) {
        			count++;
        			start = start - 1;
        			end = end + 1;
        		}
        		String temp = s.substring(start + 1 , end);
        		if(temp.length() > res.length()) {
        			res = temp;
        		}
        	}
    	}
    	else {
    		for(i = 0; i < sLen - 1; i++) {
    			if(chars[i]  == chars[i + 1]) {
    				start = i ;
    				end = i + 1;
    				while(start >= 0 && end<= sLen - 1 && chars[start] == chars[end] ) {
            			count++;
            			start = start - 1;
            			end = end + 1;
            		}
    				String temp = s.substring(start + 1 , end);
            		if(temp.length() > res.length()) {
            			res = temp;
            		}
    			}
    		}
    	}
    	
    	return res;
    }

}
