package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpiralTraversal {

	public static void main(String[] args) {
		//int[][]array = {{1,2, 3, 4},{10,11,12,5}, {9,8,7,6}};
		//int[][] array = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
		int[][ ]array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		SpiralTraversal st = new SpiralTraversal();
		List<Integer> ans = st.spiralTraverse(array);
		for (int num : ans) {
			System.out.print(num + " ");
		}
	}

	public List<Integer> spiralTraverse(int[][] array) {
		List<Integer> ans = new ArrayList<Integer>();
		int m = array.length; // rows
		int n = array[0].length; // columns
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		int startRow = 0;
		int startCol = 0;
		int endRow = m - 1;
		int endCol = n - 1;
		while (startRow <= endRow && startCol <= endCol) {
			for (i = startCol; i <= endCol; i++) {
				ans.add(array[startRow][i]);
			}
			for (j = startRow + 1; j <= endRow; j++) {
				ans.add(array[j][endCol]);
			}
			for (k = endCol - 1; k >= startCol; k--) {
				if(startRow == endRow)break;
				ans.add(array[endRow][k]);
			}
			for (l = endRow -1; l >= startRow + 1 ; l--) {
				if(startCol == endCol)break;
				ans.add(array[l][startCol]);
			}

			startRow++;
			endRow--;
			startCol++;
			endCol--;
		}
		return ans;
	}

}
