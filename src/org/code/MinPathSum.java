package org.code;

import java.util.HashMap;

public class MinPathSum {
	//TODO You need to optimize the time it takes
	//This is a dynamic programming problem
	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static void main(String argv[]) {
			/*
			 * int[][]grid = { {1,3,1}, 
			 * 				   {1,5,1}, 
			 * 				   {4,2,1} };
			 */
		/*
		 * int[][] grid = { {1, 2, 3}, {4, 8, 2}, {1, 5, 3} };
		 */
		//int[][] grid = {{1,3,2}};
		//int grid[][] = {{4,7, 8, 6, 6}, {6,7, 3, 9, 2}, {3,8,1,2,4}, {7,1,7, 3,7}, {2,9,8,9,3}};
		int[][] grid = {{5,3,4,10},{8,2,9,5}, {10,0,6,8}};
		map.put(1, Integer.MAX_VALUE);
		minPathSum(grid);
		System.out.println(map.get(1));
	}
    public static void minPathSum(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length  - 1;
        dfs(grid, 0, 0, m, n, 0);
    }
    
    public static  void dfs(int[][] grid, int row, int col, int m, int n, int sum){
        if(row > m || col > n || row < 0 || col <0) return;
        if(row == m && col == n) { 
        	sum+=grid[m][n]; 
        	if(map.get(1) > sum) {
        		map.put(1, sum);
        	}
        	return; 
        }
        sum += grid[row][col];
        dfs(grid, row, col + 1, m, n , sum);
        dfs(grid, row + 1, col, m, n, sum);
    }
}

/*
 * 	Leetcode: Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
Understand the problem:
The problem asks for find the minimum path sum, which is still close to the Unique Path I and II. Note that the grid is filled with non-negative numbers. 

Naive Solution:
The native solution is to use recursion. We get all possible unique paths and get the sum of the path. We only need to maintain the minimum path sum. 
public class Solution {
    private int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int m = grid.length;
        int n = grid[0].length;
         
        minPathSumHelper(0, 0, m, n, 0, grid);
         
        return min;
    }
     
    private void minPathSumHelper(int r, int c, int m, int n, int curSum, int[][] grid) {
        if (r > m - 1 || c > n - 1) {
            return;
        }
        curSum += grid[r][c];
         
        if (r == m - 1 && c == n - 1) {
            if (curSum < min) {
                min = curSum;
            }
            return;
        }
         
        if (curSum > min) {
            return;
        }
         
        minPathSumHelper(r + 1, c, m, n, curSum, grid);
        minPathSumHelper(r, c + 1, m, n, curSum, grid);
    }
}

Discussion:
No surprise the solution got the TLE error, since its time complexity is at the order of exponential.  So we must naturally think of a DP solution.

An iterative-based DP solution:
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int m = grid.length;
        int n = grid[0].length;
         
        int[][] dp = new int[m][n];
         
        dp[0][0] = grid[0][0];;
         
        // update the first row
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
         
        // update the first column
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
         
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
         
        return dp[m - 1][n - 1];
    }
}

One-dimensional DP Solution:
Again, we can optimize the space by using an 1D DP solution. So dp[i] means the minimum path sum from starting to column i. 

Code (Java):
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int m = grid.length;
        int n = grid[0].length;
         
        int[] dp = new int[n];
        dp[0] = grid[0][0];
         
        // set the first row
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
         
        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
         
        return dp[n - 1];
    }
}

Summary:
The path sum I, II, minimum path sum are a set of very classic DP problem. Try to understand the native recursive solution first. Then think about recursive-based DP, 2D DP and 1D DP solution.


Update on 4/2/19: rolling array
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];
         
        int sum = 0;
        for (int i = 0; i < n; i++) {
            dp[0][i] = sum + grid[0][i];
            sum += grid[0][i];
        }
         
        int old = 0;
        int cur = 0;
        for (int i = 1; i < m; i++) {
            old = cur;
            cur = 1 - cur;
            dp[cur][0] = dp[old][0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[cur][j] = Math.min(dp[old][j], dp[cur][j - 1]) + grid[i][j];
            }
        }
         
        return dp[cur][n - 1];
    }
}
 */
