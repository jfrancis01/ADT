package org.code;

public class PalindromicSubstrings {
	
	public int countSubstrings(String s) {
        int left = 0; //left pointer
        int right = 0; //right pointer
        int length = s.length();
        int pos = 0; //position in the string
        
        int palCount = 0;
        
      //First we do with single characters
        for(pos = 0; pos < length; pos++){
            left = pos;
            right = pos;
            while( left >=0 && right <= length - 1){
                if(s.charAt(left) == s.charAt(right)){
                	palCount++;
                	left--;
                	right++;
                }
                else{
                    break;
                }
            }
        }
        
        //Now we attempt with double characters
        for(pos = 0; pos< length; pos++) {
        	if (pos + 1 <= length - 1) {
        		left = pos;
        		right = pos + 1;
        		while( left >=0 && right <= length - 1){
                    if(s.charAt(left) == s.charAt(right)){
                    	palCount++;
                        left--;
                    	right++;
                    }
                    else{
                        break;
                    }
                }
        	}
        }
        return palCount;
    }
	
	public static void main(String argv[]) {
		String s = "aaa";
		PalindromicSubstrings ps = new PalindromicSubstrings();
		System.out.println(ps.countSubstrings(s));
	}
}
