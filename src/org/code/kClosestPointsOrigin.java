package org.code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kClosestPointsOrigin {

	public static void main(String[] args) {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		kClosestPointsOrigin kcpo = new kClosestPointsOrigin();
		int[][] ans = kcpo.kClosest(points, 2);
		for(int i  = 0; i < ans.length; i++) {
			System.out.print("[" + ans[i][0] + ", " + ans[i][1] + " ]");
			System.out.println();
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				return getDistance(p1) > getDistance(p2) ? -1 : 1;
			}
		});
		int[][] ans = new int[k][2];
		for (int i = 0; i < points.length; i++) {
			heap.add(points[i]);

			if (heap.size() > k) {
				heap.poll();
			}
		}
		
		for(int i = 0; i < ans.length ;i++) {
			ans[i] = heap.poll();
		}

		return ans;
	}

	private int getDistance(int[] point) {
		int distance = (point[0]) * (point[0]) + (point[1]) * (point[1]);
		return distance;
	}
}
