package org.code;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> first = new ArrayList<Integer>();
		first.add(2);
		List<Integer> second = new ArrayList<Integer>();
		second.add(3);
		second.add(4);
		List<Integer> third = new ArrayList<Integer>();
		third.add(6);
		third.add(5);
		third.add(7);
		List<Integer> fourth = new ArrayList<Integer>();
		fourth.add(4);
		fourth.add(1);
		fourth.add(8);
		fourth.add(3);
		triangle.add(first);
		triangle.add(second);
		triangle.add(third);
		triangle.add(fourth);
		Triangle t = new Triangle();
		System.out.println(t.minimumTotal(triangle));
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int start = 0;
		int col = 0;
		int end = triangle.get(triangle.size() - 1).size();
		int[][] cache = new int[triangle.get(triangle.size() - 1).size()][triangle.get(triangle.size() - 1).size()];
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[0].length; j++) {
				cache[i][j] = -1;
			}
		}
		return helper(triangle, start, col, end, cache);
	}

	public int helper(List<List<Integer>> triangle, int start, int col, int end, int[][] cache) {
		if (start >= end || col < 0 || col > start) {
			return 0;
		}
		if (cache[start][col] != -1) {
			return cache[start][col];
		}
		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		left = triangle.get(start).get(col) + helper(triangle, start + 1, col, end, cache);
		right = triangle.get(start).get(col) + helper(triangle, start + 1, col + 1, end, cache);

		min = Math.min(left, right);
		cache[start][col] = min;
		return min;
	}
}
