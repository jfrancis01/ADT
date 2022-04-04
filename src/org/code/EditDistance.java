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
		int m =  word1.length();
		int n = word2.length();
		int[][] cache = new int[m][n];
		for(int  i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				cache[i][j] = -1;
			}
		}
		return helper(word1, word2, 0, 0, cache);
	}
	
	public int helper(String word1, String word2, int i, int j, int[][]cache) {
		
		if(i == word1.length()) {
			return word2.length() - j;
		}
		if(j == word2.length()) {
			return word1.length() -i;
		}
		if(cache[i][j] != -1) {
			return cache[i][j];
		}
		
		if(word1.charAt(i) == word2.charAt(j)) {
			cache[i][j] =  helper(word1, word2, i + 1, j + 1, cache);
			return cache[i][j];
		}
		else {
			//here we have 3 options
			//1. delete a character
			//2. add a character
			//3. replace a character
			cache[i][j] =  Math.min(1 + helper(word1, word2,i + 1, j + 1, cache),Math.min( 1 + helper(word1, word2, i + 1, j, cache), 
					1 + helper(word1, word2, i, j + 1, cache)));
			return cache[i][j];
		}
	}

}
