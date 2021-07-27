package org.code;

public class StaircaseRecursion {
	
	public static void main (String argv[]) {
		int target = 7;
		int ans = climbStairs(target, 0, 0);
		System.out.println(ans + " ways: ");
		int[] combo = new int[100];
		
		climbStairsPrint(target, 0, 0, combo);
	}
	
	/**
	 * This method will return the number of ways
	 * @param target
	 * @param sum
	 * @param count
	 * @return
	 */
	public static int climbStairs(int target, int sum, int count) {
		
		if(sum == target) {
			return 1;
		}
		
		if (sum > target) {
			return 0;
		}
		
		for(int i = 1; i <=3; i ++ ) {
			//choose
			sum+= i;
			//explore
			count += climbStairs(target, sum, 0);
			//undo
			sum-= i;
		}
		
		return count;
	}
	
	/**
	 * This method will just print out each combination
	 * @param target
	 * @param sum
	 */
	public static void climbStairsPrint(int target, int sum, int index, int[]combo) {
		
		if(sum == target) {
			for(int i = 0 ; i < index; i ++) {
				System.out.print(combo[i] + " ");
			}
			System.out.println();
		}
		
		if (sum > target) {
			return;
		}
		

		for(int i = 1; i <=3; i ++ ) {
			//choose
			sum+= i;
			combo[index] = i;
			//explore
			climbStairsPrint(target, sum, index+1, combo);
			//undo
			sum-= i;
		}
		
	}

}
