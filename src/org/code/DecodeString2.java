package org.code;

import java.util.Stack;

public class DecodeString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String decodeString(String s) {
        Stack<String> stack = new Stack<String>();
        int i;
        char c;
        StringBuilder sb = new StringBuilder("");
        int length = s.length();
        for(i = 0; i < length; i++){
            c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(c + "");
            }
            else if (c == '['){
                stack.push('[' + "");
            }
            //if a closing bracket is encountered then pop until a number
            else {
                while(!stack.isEmpty() &&  stack.peek().equals("[")){
                    sb.append(c+"", 0, 0);
                }
                stack.pop(); //pop the opening bracket
                //get the numbers;
                int n = Integer.parseInt(stack.pop());
                for(i  = 1; i< n; i++) {
                	
                }
            }
        }
        return null;
    }

}
