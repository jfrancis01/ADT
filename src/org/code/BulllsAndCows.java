package org.code;

import java.util.ArrayList;
import java.util.HashMap;

public class BulllsAndCows {

	public static void main(String[] args) {
		String secret = "1807";
		String guess = "7810";
		BulllsAndCows bac = new BulllsAndCows();
		System.out.println(bac.getHint(secret, guess));
	}

	public String getHint(String secret, String guess) {
		HashMap<Integer, ArrayList<Integer>> secretMap = new HashMap<Integer, ArrayList<Integer>>();
		for(int i  = 0; i < secret.length(); i++) {
			int n = Character.getNumericValue((secret.charAt(i)));
			ArrayList<Integer> pos = null;
			if(!secretMap.containsKey(n)) {
				pos = new ArrayList<Integer>();
			}
			else {
				pos = secretMap.get(n);
			}
			pos.add(i);
			secretMap.put(n, pos);
			int bulls  = 0;
			int cows  = 0;
			for(int j  = 0; j < guess.length(); j++) {
				n = Character.getNumericValue((guess.charAt(i)));
				if(secretMap.containsKey(n)) {
					pos = secretMap.get(n);
					for(int k = 0; k < pos.size(); k++) {
						if(pos.get(k).intValue() == j) {
							bulls++;
						}
					}
				}
			}	
		}
	}

}
