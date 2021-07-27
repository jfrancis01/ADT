package org.code;

import java.util.Stack;

public class CheckValidParenthesis {
	
	public static void main(String argv[]) {
		//(())((())()()(*)(*()(())())())()()((()())((()))(*"
		
		String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*"; //"(*()";
		boolean answer = checkValidString(s);
		System.out.println(answer);
	}
	
	public static boolean checkValidString(String s) {
		Stack<Character> stack = new Stack<>();// stack will hold only opening brackets '('
		Stack<Character> asterix = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if(current == ')') {
				if(!stack.isEmpty()) {
					stack.pop();
				}
				if(!asterix.isEmpty()) {
					//treat the * as a opening bracket '('
					asterix.pop();
				}
			}
			else if(current == '*') {
				asterix.push(current);
			}
			else {
				stack.push(current);
			}
	
		}
		
		while(!stack.isEmpty() && stack.pop() > asterix.size()) {
			return false;
		}
		
		return true;
	}
	
}
