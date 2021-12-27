package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleAgain {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		HashMap<Integer, Boolean> seen = new HashMap<>();
		int[] indegree = new int[numCourses];
		Queue<Integer> q = new LinkedList<>();
		int count = 0;

		// Building the graph
		for (int[] courses : prerequisites) {
			int to = courses[0];
			int from = courses[1];
			var list = map.getOrDefault(from, new ArrayList<>());
			list.add(to);
			map.put(from, list);
			indegree[to]++;
		}

		// Implementation of Kahn's Alg
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}
		while (!q.isEmpty()) {
			int node = q.peek();
			q.poll();
			count++;
			if (map.containsKey(node)) {
				for (int nei : map.get(node)) {
					indegree[nei]--;
					if (indegree[nei] == 0) {
						q.add(nei);
					}
				}
			}
		}
		return count == numCourses;
	}

	public static void main(String[] args) {
		int[][] prerequisites = { { 5, 6 }, { 0, 2 }, { 1, 7 }, { 5, 9 }, { 1, 8 }, { 3, 4 }, { 0, 6 }, { 0, 7 },
				{ 0, 3 }, { 8, 9 } };
		int numCourses = 10;
		CourseScheduleAgain csa = new CourseScheduleAgain();
		System.out.println(csa.canFinish(numCourses, prerequisites));
	}

}
