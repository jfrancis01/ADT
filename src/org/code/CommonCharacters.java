package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CommonCharacters {

	public static void main(String[] args) {
		CommonCharacters cc = new CommonCharacters();
		String[] strings = {"abc", "bcd", "cbaccd"};
		String[] ans = cc.commonCharacters(strings);
		for(String letters : ans) {
			System.out.print(letters + " ");
		}
	}

	public String[] commonCharacters(String[] strings) {
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    for(String word : strings){
	      HashSet<Character> chars = new HashSet<Character>();
	      char[] letters = word.toCharArray();
	      for( char c : letters){
	        chars.add(c);
	      }
	      Iterator<Character> it = chars.iterator();
	      while(it.hasNext()){
	        char c = (char) it.next();
	        if(map.containsKey(c)){
	          map.put(c, map.get(c) + 1);
	        }
	        else { 
	          map.put(c, 1);
	        }
	      }
	    }
	    ArrayList<Character> vals = new ArrayList<Character>();
	    int num_strings = strings.length;
	    for(char c : map.keySet()){
	      if(map.get(c) == num_strings){
	        vals.add(c);
	      }
	    }
	    String[] ans = new String[vals.size()];
	    for(int i  = 0; i < vals.size(); i++){
	      ans[i] = vals.get(i) + "";
	    }
	    return ans;
	  }

}
