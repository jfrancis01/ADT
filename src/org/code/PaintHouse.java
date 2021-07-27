package org.code;

import java.util.ArrayList;

public class PaintHouse {

	public int min_cost = Integer.MAX_VALUE;

	public static void main(String argv[]) {
		int costs[][] = {{18,17,7},{20,19,4},{5,8,15},{6,3,17},{7,6,6},{8,1,9},{1,11,19},{20,13,18},{15,17,3},{16,20,15},{16,7,15},{15,3,12},{19,5,10},{8,18,15},{2,16,17},{12,17,16},{10,8,16},{6,8,15},{14,3,18},{15,18,2},{20,10,20},{4,18,4},{7,8,2},{4,1,8},{8,13,20},{12,20,4}};
				//{{17,2,17},{8,4,10},{6,3,19}, {4,8,12}}; 
				//{ { 5, 8, 6 }, { 19, 14, 13 }, { 7, 5, 12 }, { 14, 15, 17 }, { 3, 20, 10 } };
		PaintHouse ph = new PaintHouse();
		ph.minCost(costs);
		System.out.println("Min Cost: " + ph.min_cost);
	}

	public void minCost(int[][] costs) {
		int sum = 0;
		int start = 0;
		int prevColor = -1;
		int cache[][] = new int[costs.length + 1][costs[0].length + 1];
		//minCostHelper(costs, sum, start, prevColor, new ArrayList<Integer>());
		System.out.println(minCostHelper(costs, 0, -1, cache));
	}

	public void minCostHelper(int[][] costs, int sum, int start,int prevColor, ArrayList<Integer> combo) {
		
		if (start >= costs.length) {
			/*
			 * for (int val : combo) { System.out.print(val + " "); }
			 * System.out.print(" Sum: " + sum); System.out.println();
			 */
			min_cost = Math.min(min_cost, sum);
			return;
		}

		for (int j = 0; j < costs[0].length; j++) {
			if (prevColor != j) {
				sum += costs[start][j];
				combo.add(costs[start][j]);
				minCostHelper(costs, sum, start + 1, j, combo);
				sum -= costs[start][j];
				combo.remove(combo.size() - 1);
			} else {
				continue;
			}
		}
	}
	
	public int minCostHelper(int[][]costs, int start, int prevColor, int[][]cache) {
		if(start >= costs.length) return 0;
		if(prevColor != -1 && cache[start][prevColor] != 0) {
			return cache[start][prevColor];
		}
		int min = Integer.MAX_VALUE;
		for(int color = 0; color <3; color++) {
			if(prevColor != color) {
				min = Math.min(min, costs[start][color] + minCostHelper(costs, start + 1, color, cache));
			}
		}
		if(prevColor != - 1) {
			cache[start][prevColor] = min;
		}
		return min;
	}
}
