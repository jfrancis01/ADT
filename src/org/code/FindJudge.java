package org.code;

public class FindJudge {
	
	public static void main(String argv[]) {
		int trust[][] = {{1,3}, {1, 4}, {2, 3}, {2,4}, {4,3}};
		int N = 4;
		System.out.println(findJudge(N, trust));
	}
	
	
	public static int findJudge(int N, int[][] trust) {
		int[][] adjMat = new int[N][N];
		for (int i = 0; i < trust.length; i++) {
			int from = trust[i][0];
			int to = trust[i][1];
			adjMat[from - 1][to - 1] = 1;
		}
		print(adjMat, N);
		for (int i = 0; i < N; i++) {
			int rowSum = rowSum(i, N, adjMat);
			int colSum = colSum(i, N, adjMat);
			if (rowSum == 0 && colSum == N-1) {
				return i + 1;
			}
		}
		return -1;
	}

	private static void print(int[][] adjMat, int N) {
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < N; j++) {
				System.out.print(adjMat[i][j] + " ");
			}
			System.out.println();
		}
		
	}


	public static int rowSum(int row, int colEnd, int[][] adjMat) {
		int sum = 0;
		for (int j = 0; j < colEnd; j++) {
			sum += adjMat[row][j];
		}
		return sum;
	}

	public static int colSum(int col, int rowEnd, int[][] adjMat) {
		int sum = 0;
		for (int i = 0; i < rowEnd; i++) {
			sum += adjMat[i][col];
		}
		return sum;
	}
}
