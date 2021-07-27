package org.code;

public class StringPermuation {
	
	public static void main(String argv[]) {
		String str ="god";
		printAnagrams(str);
	}
	public static void printAnagrams(String str) {
		printAnagramsHelper(str, "");
	}
	private static void printAnagramsHelper(String str, String string) {
		if(str.isEmpty() || str == "") {
			System.out.println(string);
		}
		for(int i = 0; i < str.length(); i++) {
			//choose;
			String c = str.substring(i, i + 1);
			printAnagramsHelper(str.substring(0, i) + str.substring(i + 1), string + c);
		}
	}
}
