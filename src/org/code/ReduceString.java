package org.code;

public class ReduceString {

	public static void main(String[] args) {
		ReduceString rs = new ReduceString();
		rs.StringChallenge("abccccccc");
	}
	
	public void StringChallenge(String str) {
		int res = str.length() + 1;
		int index = -1;
		while (res > str.length()) {
			
			res = str.length();
			
			if((index = str.indexOf("ab") )!= -1) {
				str = str.substring(0, index) + "c" + str.substring(index + 2);
			}
			if((index = str.indexOf("ba") )!= -1) {
				str = str.substring(0, index) + "c" + str.substring(index + 2);
			}
			if((index = str.indexOf("bc") )!= -1) {
				str = str.substring(0, index) + "a" + str.substring(index + 2);
			}
			if((index = str.indexOf("cb") )!= -1) {
				str = str.substring(0, index) + "a" + str.substring(index + 2);
			}
			if((index = str.indexOf("ac") )!= -1) {
				str = str.substring(0, index) + "b" + str.substring(index + 2);
			}
			if((index = str.indexOf("ca") )!= -1) {
				str = str.substring(0, index) + "b" + str.substring(index + 2);
			}
		}
		System.out.println(str + " " + str.length());
	}

}
