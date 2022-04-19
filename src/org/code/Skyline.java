package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

	public static void main(String[] args) {
		int[][] building = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
		SkylineSolution ss = new SkylineSolution();
		List<List<Integer>> output = ss.getSkyline(building);
		for (int i = 0; i < output.size(); i++) {
			List<Integer> mylist = output.get(i);
			for (int val : mylist) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

	}

	public List<List<Integer>> getSkyline(int[][] buildings) {
		int n = buildings.length;
		List<List<Integer>> output = new ArrayList<List<Integer>>();

		if (n == 0)
			return output;
		if (n == 1) {
			int xStart = buildings[0][0];
			int y = buildings[0][2];
			int xEnd = buildings[0][1];

			output.add(new ArrayList<Integer>() {
				{
					add(xStart);
					add(y);
				}
			});
			output.add(new ArrayList<Integer>() {
				{
					add(xEnd);
					add(0);
				}
			});
			return output;
		}

		List<List<Integer>> rightSkyline, leftSkyline;
		leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
		rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));

		return mergeSkylines(leftSkyline, rightSkyline);
	}

	public List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>> right) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();

		int pL = 0, pR = 0;
		int nL = left.size();
		int nR = right.size();
		int currY = 0, leftY = 0, rightY = 0;
		int x, maxY;

		while (pL < nL && pR < nR) {
			if (left.get(pL).get(0) < right.get(pR).get(0)) {
				x = left.get(pL).get(0);
				leftY = left.get(pL).get(1);
				pL++;
			} else {
				x = right.get(pR).get(0);
				rightY = right.get(pR).get(1);
				pR++;
			}

			maxY = Math.max(leftY, rightY);
			// update output if there is a skyline change
			if (currY != maxY) {
				updateOutput(output, x, maxY);
				currY = maxY;
			}
		}

		// there is only left skyline
		appendSkyline(output, left, pL, nL, currY);

		// there is only right skyline
		appendSkyline(output, right, pR, nR, currY);

		return output;
	}

	public void updateOutput(List<List<Integer>> output, int x, int y) {
		// if skyline change is not vertical -
		// add the new point
		if (output.isEmpty() || output.get(output.size() - 1).get(0) != x)
			output.add(new ArrayList<Integer>() {
				{
					add(x);
					add(y);
				}
			});
		// if skyline change is vertical -
		// update the last point
		else {
			output.get(output.size() - 1).set(1, y);
		}
	}

	/**
	 * Append the rest of the skyline elements with indice (p, n) to the final
	 * output.
	 */
	public void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline, int p, int n, int currY) {
		while (p < n) {
			List<Integer> point = skyline.get(p);
			int x = point.get(0);
			int y = point.get(1);
			p++;

			// update output
			// if there is a skyline change
			if (currY != y) {
				updateOutput(output, x, y);
				currY = y;
			}
		}
	}

}
