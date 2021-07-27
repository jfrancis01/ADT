package org.code;

public class ChangeDistinctCombinations {
	
	public static void main(String argv[]) {
		int[] coins = {1, 2, 5};
		int amount = 5;
		System.out.println("Total Ways: " + ways(coins, amount, 0, 0, 0));
	}
	
	public static int ways(int[] coins, int amount, int sum, int count, int index) {
		
		if(sum > amount) {
			return 0;
		}
		if(sum == amount) {
			return 1;
		}
		
		for(int i = index ; i <coins.length; i++) {
			//choose
			sum += coins[i];
			//explore
			count += ways(coins, amount, sum, 0, i);
			//undo
			sum -= coins[i];
		}
		
		return count;
	}

}
