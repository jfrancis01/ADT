package org.code;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MinCostToConnect {
	
	public int cost = 0;
	class Point {
		int node;
		int dist;
		
		public Point(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	public int minCostConnectPoints(int[][] points) {
		HashSet<Integer> visited = new HashSet<Integer>();
		int n = points.length;
		int[][] adjMat = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				adjMat[i][j] = 1; // every node is connected to every other node;
			}
		}
		PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				return Integer.compare(a.dist, b.dist);
			}
		});
		//initially, we designate a node as the source and its distance is 0
		//and the others Integer.MAX_VALUE
		pq.offer(new Point(0, 0));
		for(int i = 1; i < n ; i++) {
			pq.offer(new Point(i, Integer.MAX_VALUE));
		}
		while(!(visited.size()== n)) {///run the loop till we have visited all the nodes
			Point p = pq.poll();
			visited.add(p.node); // add it to the visited
			//now find out all its neighbours who have not been visited
			for(int i = 0; i < n; i++) {
				if(points[p.node][i] == 1 && !visited.contains(i)) {
					int dist = getDistance(points[p.node][0], points[p.node][1], points[i][0], i);
					pq.offer(new Point(i, dist));
					cost+= dist;
				}
			}
		}
		return cost;
	}
	
	public int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs((x2 - x1) + (y2 - y1));
	}

	public static void main(String[] args) {
		int[][]points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
		MinCostToConnect mst = new MinCostToConnect();
		System.out.println(mst.minCostConnectPoints(points));
	}

}
