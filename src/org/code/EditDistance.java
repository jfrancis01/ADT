package org.code;

public class EditDistance {

	public static void main(String[] args) {
		
		String word1 = "algo";
		String word2 = "algomonster";
		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance(word1, word2));

	}

	public int minDistance(String word1, String word2) {
		if(word2.isEmpty() || word2.isEmpty()) return word1.length();
		if(word1.isEmpty() || word2.isBlank()) return word2.length();
		int i  = 0;
		int j  = 0;
		return helper(word1, word2, i, j);
	}
	
	public int helper(String word1, String word2, int i, int j) {
		if(i == word1.length()) {
			return word2.length() - j;
		}
		if(j == word2.length()) {
			return word1.length() -i;
		}
		
		if(word1.charAt(i) == word2.charAt(j)) {
			return helper(word1, word2, i + 1, j + 1);
		}
		else {
			//here we have 3 options
			//1. delete a character
			//2. add a character
			//3. replace a character
			return Math.min(1 + helper(word1, word2,i + 1, j + 1),Math.min( 1 + helper(word1, word2, i + 1, j), 
					1 + helper(word1, word2, i, j + 1)));
			
		}
	}

}
