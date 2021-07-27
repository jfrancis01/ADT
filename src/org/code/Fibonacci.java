package org.code;

import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 48;
		int[] fibs = new int[n + 1];
		Arrays.fill(fibs, -1);
		fibs[0]= 0;
		fibs[1] = 1;
		System.out.println(fib(0,1, n));
		System.out.println(fib(n, fibs));
	}
	
	/*
	 * This technique uses memoization as we store
	 * answers to subproblems and there are overlapping problems
	 * so we can just use the answer if it exists
	 */
	public static int fib(int n, int[] fibs) {
		if(fibs[n] != -1) {
			return fibs[n];
		}
		int f = fib(n-1, fibs) + fib(n- 2, fibs);
		fibs[n] = f;
		return fibs[n];
	}
	/*
	 * Dynamic programming aims to solve a problem in an iterative
	 * fashion. We tabulate instead of meoizing randonly. Each subproblem
	 * is solved in an iterative fashion and the answer of the sub problems
	 * help solve the big problem. This is called sub optimal structure
	 */
	
	public static int fib(int a, int b, int n) {
		int total = 0;
		for(int i = 2; i <=n ; i++) {
			total = a + b;
			a = b;
			b = total;
		}
		return total;
	}

} 
