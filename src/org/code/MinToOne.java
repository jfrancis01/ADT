package org.code;

/**
 * Problem : Minimum Steps To One Problem Statement: On a positive integer, you
 * can perform any one of the following 3 steps. 1.) Subtract 1 from it. ( n = n
 * - 1 ) , 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n
 * / 2 ) , 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n
 * / 3 ). Now the question is, given a positive integer n, find the minimum
 * number of steps that takes n to 1
 * 
 * eg: 1.)For n = 1 , output: 0 2.) For n = 4 , output: 2 ( 4 /2 = 2 /2 = 1 )
 * 3.) For n = 7 , output: 3 ( 7 -1 = 6 /3 = 2 /2 = 1 )
 * 
 * @author joel
 *
 */

public class MinToOne {
	
	public static void main(String argv[]) {
		int n = 500;
		int steps = 0;
		int minSteps = Integer.MAX_VALUE;
		int[] cache = new int[n + 1];
		
		int[] newCache = new int[n + 1];
		for(int i = 2; i < n + 1; i ++) {
			cache[i] = -1;
		}
		
		for(int i = 2; i < n + 1; i ++) {
			newCache[i] = Integer.MAX_VALUE;
		}
		
		
		System.out.println(minToOne(n, steps, minSteps, cache));
		minToOneDynamic(n, cache);
	}

	private static int minToOne(int n, int steps, int minSteps, int[] cache) {
		
		if(cache[n] >= 0) {
			return cache[n];
		}
		
		if(n - 1 > 0) {
			int s = 1 +  minToOne(n - 1, steps + 1, minSteps, cache);
			if(minSteps > s) {
				minSteps = s;
			}
			
		}
		
		if(n % 2 == 0) {
			int s = 1 +  minToOne(n/2, steps + 1, minSteps, cache);
			if(minSteps > s) {
				minSteps = s;
			}
			
		}
		
		if(n % 3 == 0) {
			int s = 1 +  minToOne(n/3, steps + 1, minSteps, cache);
			if(minSteps > s) {
				minSteps = s;
			}
			
		}
		cache[n] = minSteps;
		return minSteps;
		
	}
	
	private static void minToOneDynamic(int n, int[] cache) {
		
		for(int subproblem = 2; subproblem <= n; subproblem++ ) {
			
			cache[subproblem] = Math.min(cache[subproblem - 1] + 1, cache[subproblem]);
			
			if(subproblem % 2 == 0) Math.min(cache[subproblem/2] + 1, cache[subproblem]);
			
			if(subproblem % 3 == 0) Math.min(cache[subproblem/3] + 1, cache[subproblem]);
		}
		
		System.out.println("The minimum steps to make " + n + " is: " + cache[n]);
	}
	
}
