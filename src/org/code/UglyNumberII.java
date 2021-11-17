package org.code;

public class UglyNumberII {

	public static void main(String[] args) {
		UglyNumberII  ugII = new UglyNumberII();
		System.out.println(ugII.nthUglyNumber(1690));
	}
	
	public int nthUglyNumber(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		int p1 = 0, p2 = 0, p3 = 0;
		for(int i = 1; i < n; i ++ ) {
			int multiple2 = dp[p1]  * 2;
			int multiple3 = dp[p2] * 3;
			int multiple5 = dp[p3] * 5;
			
			dp[i] = Math.min(multiple2, Math.min(multiple3, multiple5));
			
			if(dp[i] == multiple2)  p1++;
			if(dp[i] == multiple3)  p2++;
			if(dp[i] == multiple5)  p3++;
		}
		return dp[n-1];
	}

}
