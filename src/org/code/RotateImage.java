package org.code;

public class RotateImage {
	
	public void rotate(int[][] matrix) {
		transpose(matrix);
		reflect(matrix);
	}
	
	public static void main(String argv[]) {
		int[][] matrix  = {{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		
		RotateImage ri = new RotateImage();
		ri.rotate(matrix);
		ri.print(matrix);
	}
	
	private void transpose(int[][] matrix) {
		int temp  = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i; j <matrix[0].length; j++) {
				 temp = matrix[j][i];
				 matrix[j][i] = matrix[i][j];
				 matrix[i][j] = temp;
			}
		}
		System.out.println("Done transposing");
	}
	
	private void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
	
	private void print(int[][]matrix) {
		for(int i = 0; i < matrix.length;i++) {
			for(int j=0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
