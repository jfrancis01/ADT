package org.code;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class LetterCombinations {

	public static void main(String[] args) {
		LetterCombinations lc = new LetterCombinations();
		List<String> ans = lc.letterCombinations("234");
		for(String str : ans) {
			System.out.println(str);
		}
	}
	
	public List<String> letterCombinations(String digits) {
        Hashtable<Character, String> hm = new Hashtable();
        List<String> combos = new ArrayList<String>();
        ArrayList<String> row = null;
        hm.put('2',"abc" );
        hm.put('3', "def");
        hm.put('4', "ghi" );
        hm.put('5', "jkl" );
        hm.put('6', "mno" );
        hm.put('7', "pqrs" );
        hm.put('8', "tuv" );
        hm.put('9', "wxyz" );
        for(int i = 0; i <digits.length(); i++) {
        	char val = digits.charAt(i);
        	String str = hm.get(val);
        	if(combos.isEmpty()) {
        		row = new ArrayList<String>();
        		for(int j = 0; j < str.length(); j++) {
        			row.add(str.charAt(j) + "");
        		}
        	}
        	else {
        		row = new ArrayList<String>();
        		for(int k = 0; k< str.length(); k++) {
        			char c = str.charAt(k);
        			for(int j = 0; j < combos.size(); j++) {
        				row.add(combos.get(j) + c);
        			}
        		}
        	}
        	combos.clear();
        	combos.addAll(row);
        }
        return combos;
    }
}
