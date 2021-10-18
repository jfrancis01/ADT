package org.code;

public class ReorganizeString {
	
	 String ans = "";
	    public String reorganizeString(String s) {
	        permuteHelper(s, "");
	        return ans;
	    }
	    
	    private void permuteHelper(String s, String str){
	        if(s.isEmpty() || s.length() == 0){
	            if(check(str)){
	                ans = str;
	                return;
	            }
	        }
	        for(int i = 0; i < s.length(); i++){
	             permuteHelper(s.substring(0, i) + s.substring(i + 1),  s.substring(i, i + 1 ) + str);
	        }
	    }
	    
	    private boolean check(String str){
	        for(int i = 1; i < str.length(); i++){
	            if(str.charAt(i) == str.charAt(i - 1)){
	                return false;
	            }
	        }
	        return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
