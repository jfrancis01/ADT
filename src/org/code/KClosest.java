package org.code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {

	public static void main(String[] args) {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		KClosest kClosest = new KClosest();
		int[][] ans = kClosest.kClosest(points, 2);
		for (int[] num : ans) {
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i]);
			}
			System.out.println();
		}

	}

	public class Data {
		public int dist;
		public int[] arr;

		public Data(int dist, int[] arr) {
			this.dist = dist;
			this.arr = arr;
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Data> pq = new PriorityQueue<Data>(new Comparator<Data>() {
			@Override
			public int compare(Data a, Data b) {
				return a.dist < b.dist ? -1 : 1;
			}
		});
		for (int i = 0; i < points.length; i++) {
			int[] arr = points[i];
			int dist = arr[0] * arr[0] + arr[1] * arr[1];
			pq.add(new Data(dist, arr));
		}
		int[][] ans = new int[k][2];
		for (int i = 1; i <= k; i++) {
			Data d = pq.poll();
			ans[i - 1] = d.arr;
		}

		return ans;
	}

}
