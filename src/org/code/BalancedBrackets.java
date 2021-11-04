package org.code;

import java.util.ArrayList;

public class BalancedBrackets {
	ArrayList<String> strs = new ArrayList<String>();

	public static void main(String[] args) {
		String s = "(()())(())(()(()))";
		BalancedBrackets bb = new BalancedBrackets();
		System.out.println(bb.removeOuterParentheses(s));
	}


	public String removeOuterParentheses(String s) {
		StringBuilder sb = new StringBuilder("");
		removeOuterParenthesesHelper(s);
		for(int i = 0; i <strs.size(); i++) {
			String combo  = strs.get(i);
			sb.append(combo.substring(1, combo.length() - 1));
		}
		return sb.toString();
	}
	
	private void removeOuterParenthesesHelper(String s) {
		char[] current = s.toCharArray();
		int balance = 0;
		if(s.isEmpty() || s.length() == 0) return;
		for (int c = 0; c<current.length;c++) {
			if (current[c] == '(')
				balance++;
			else
				balance--;
			if(balance < 0)return;
			if(balance == 0) {
				strs.add(s.substring(0,  c+1));
				removeOuterParenthesesHelper(s.substring(c + 1));
				return;
			}
		}

	}

}
