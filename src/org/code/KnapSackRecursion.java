package org.code;

/*
 * Each object has a weight and specific profit
 * How would you figure out what weights to choose
 * to maximize the profits
 * 
 * Pick 1 + Pick 2 + Pick3 ? check profit save and try again
 * When picking try to get the index of the chosen item. Once you pick an item,
 * you cannot pick it again. this is why it is called the 0/1 knapsack problem
 * 
 * 
 * First let's break it down:
 * 
 * 1. First find all the combinations that are less than or equal to the capacity!
 * 
 * 
 * What is the maximum profit one can get! then we can figure out how to display
 * the chosen values
 */

public class KnapSackRecursion {
	
	int[] combos = new int[100];

	public static void main(String[] args) {
		
		int n = 4;
		int capacity = 8;
		int profit[] = {1, 2, 5, 6};
		int weight[] = {2, 3, 4, 5};
		
	}
	
	

}
