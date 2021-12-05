package org.code;

public class MatrixTest {

	public static void main(String[] args) {
		int[][] matrix = {{-1, 0, 1}, {1, -1, 0}, {0, -1, 0}};
		System.out.println("Matrix before: ");
		MatrixTest mt = new MatrixTest();
		mt.printMatrix(matrix);
		System.out.println("Matrix after: ");
		mt.modifyMatrix(matrix);
		mt.printMatrix(matrix);
	}
	
	public void modifyMatrix(int[][] matrix) {
		for(int i  = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = matrix[i][j] + 5;
			}
		}
	}
	
	public void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j <matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("***********************");
	}

}
