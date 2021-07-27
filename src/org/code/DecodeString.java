package org.code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
		//String s = "2[20[bc]31[xy]]xd4[rt]";
		//String s = "3[a]2[b4[F]c]";
		//String s = "3[a]2[b4[F]c]";
		//String s = "3[a2[b3[cde]]]";
		//String s = "2[abc]3[cd]xyz";
		//String s = "11[a]3[b]4[c]";
		//String s = "3[a2[xyz]]";
        DecodeString ds  = new DecodeString();
        System.out.println(ds.decodeString(s));
        Character c;
	}
	
	public String decodeString(String s) {
		
		StringBuilder result = new StringBuilder("");//for the result
		StringBuilder temp = new StringBuilder(""); //this is for the current string;
		Stack<Integer> numStack = new Stack<Integer>();
		Queue<Character> numQ = new LinkedList<Character>(); // queue to keep track of numbers
		Stack<Character> mainQ = new Stack<Character>(); // queue to keep track of alphabets
		Stack<String> subQ = new Stack<String>(); // queue to keep track of inner elements
		
		char[] sArray = s.toCharArray();
		int sLength = sArray.length -1;
		
		for(int index = 0; index <= sLength; index++ ) {
			char c = sArray[index];
 			if(Character.isDigit(c)) {
				numQ.add(c);
			}
			else if(c != '[' && mainQ.isEmpty()) {
				result.append(c);
			}
			else {
				if(c == ']') {
					while( mainQ.peek() != '['){
						temp.insert(0, mainQ.pop());
					}
					mainQ.pop(); //pop off the '['
					String reps = "";
					StringBuilder subq = new StringBuilder("");
					if(!mainQ.isEmpty()) {
						if(!subQ.isEmpty()) {
							while(!subQ.isEmpty()) {
								subq.insert(0, subQ.pop());
							}
						}
						reps= calculateReps(numStack.pop(), temp.toString() + subq.toString());
						subQ.add(reps);
					}
					else {
						StringBuilder addition = new StringBuilder("");
	                    while(!subQ.isEmpty()){
	                        addition.insert(0,subQ.pop());
	                    }
	                    reps = calculateReps(numStack.pop(), temp.toString() + addition.toString());
	                    result.append(reps);
					}
					temp.setLength(0);
				}
				else {
					if(c == '[') {
						//check what is in the numQ and combine into one number for use after the popping
						StringBuilder number = new StringBuilder("");
						while(!numQ.isEmpty()) {
							number.append(numQ.poll());
						}
						numStack.add(Integer.parseInt(number.toString())); 
					}
					if(!subQ.isEmpty() && c != '[') {
						subQ.add(c+"");
					}
					else {
						mainQ.add(c);
					}
				}
			}
		}
		return result.toString();
	}
	
	public String calculateReps(int val, String string){
        StringBuilder resultRep = new StringBuilder();
        for(int i  = 0; i < val; i++){
            resultRep.append(string);
        }
        return resultRep.toString();
    }

}
