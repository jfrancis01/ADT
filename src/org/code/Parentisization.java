package org.code;

import java.util.ArrayList;
import java.util.List;

public class Parentisization {

	public static void main(String[] args) {
		String s = "2*3-4*5";
		Parentisization p = new Parentisization();
		List<Integer> ans = p.diffWaysToCompute(s);
		for(int val:ans) {
			System.out.println(ans);
		}
	}
	
	public List<Integer> diffWaysToCompute(String expression) {
		List<Integer> res = new ArrayList<Integer>();
		for(int i  = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if(c == '+' || c == '-' || c == '*') {
				List<Integer> al  = diffWaysToCompute(expression.substring(0, i));
				List<Integer> bl = diffWaysToCompute(expression.substring(i + 1));
				for(int x : al) {
					for(int y : bl) {
						if(c == '+') {
							res.add(x + y);
						}
						else if(c == '-') {
							res.add(x - y);
						}
						else {
							res.add( x * y);
						}
					}
				}
			}
		}
		if(res.size() == 0)res.add(Integer.valueOf(expression));
		return res;
    }
	public void printsubStrings(String expression) {
		int length = expression.length();
		for(int i = 0; i < length; i++) {
			for(int j = i; j < length; j++) {
				String str = "";
				for(int k = i; k <=j ; k++) {
					str+= expression.charAt(k);
				}
				System.out.println(str);
			}
		}
	}
}
