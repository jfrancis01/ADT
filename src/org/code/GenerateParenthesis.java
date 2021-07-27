package org.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

	List<String> valid = new ArrayList<String>();
	HashSet<String> checkDup = new HashSet<String>();

	// constructor
	public GenerateParenthesis() {

	}

	public List<String> generateParenthesis(int n) {
		ArrayList<Character> choice = new ArrayList<Character>();
		for (int i = 0; i < n; i++) {
			choice.add('(');
			choice.add(')');
		}
		generateHelper(n, 0 ,choice, "");
		return valid;
	}

	private void generateHelper(int n, int start, ArrayList<Character> choice, String combo) {
		if (choice.size() == 0) {
			if (validate(combo)) {
				if(checkDup.isEmpty()) {
					checkDup.add(combo);
					valid.add(combo);
				}else {
					if(!checkDup.contains(combo)) {
						checkDup.add(combo);
						valid.add(combo);
					}
				}
			}
		}
		for (int i = 0; i < choice.size(); i++) {
			// choose
			char str = choice.remove(i);
			// explore
			generateHelper(n, start + 1, choice, combo + str);
			// undo
			choice.add(i, str);
		}
	}

	private boolean validate(String combo) {
		char[] test = combo.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < test.length; i++) {
			char c = test[i];
			if (c == '(') {
				stack.push(c);
			}
			else if(stack.isEmpty() && c == ')') {
				return false;
			}
			else {
				if( stack.peek() == '(') {
					stack.pop();
				}

			}
		}
		return stack.isEmpty();

	}

	public static void main(String argv[]) {
		GenerateParenthesis gp = new GenerateParenthesis();
		gp.generateParenthesis(5);
		for (String str : gp.valid) {
			System.out.println(str);
		}
	}
}
