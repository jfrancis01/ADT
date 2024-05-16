package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class EvaluateDivision {
	
	HashMap<String, HashMap<String, Double>>map = 
			new HashMap<String, HashMap<String, Double>>();
	

	public static void main(String[] args) {
		EvaluateDivision ed = new EvaluateDivision();
		List<List<String>> equations = new ArrayList<List<String>>();
		List<String> eq1 = new ArrayList<String>();
		List<String> eq2 = new ArrayList<String>();
		eq1.add("a");
		eq1.add("b");
		eq2.add("b");
		eq2.add("c");
		equations.add(eq1);
		equations.add(eq2);
		List<List<String>> queries = new ArrayList<List<String>>();
		List<String> q1 = new ArrayList<String>();
		List<String> q2 = new ArrayList<String>();
		List<String> q3 = new ArrayList<String>();
		List<String> q4 = new ArrayList<String>();
		List<String> q5 = new ArrayList<String>();
		q1.add("a");
		q1.add("c");
		q2.add("b");
		q2.add("a");
		q3.add("a");
		q3.add("e");
		q4.add("a");
		q4.add("a");
		q5.add("x");
		q5.add("x");
		queries.add(q1);
		queries.add(q2);
		queries.add(q3);
		queries.add(q4);
		queries.add(q5);
		double[] values = {2.0, 3.0};
		double[] ans = ed.calcEquation(equations, values, queries);
		Arrays.stream(ans).forEach(x->System.out.print(x + " "));

	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		createAdjacencyList(equations, values);
		double[] ans = new double[queries.size()];
		int index = 0;
		for(List<String> eq : equations) {
			String x = eq.get(0);
			String y = eq.get(1);
			if(!map.containsKey(x)||!map.containsKey(y)) {
				ans[index] = -1;
			}
			else {
				//perform bfs
				ans[index] = bfs(x, y);
			}
			index++;
		}
		return ans;
	}
	
	private double bfs(String x, String y) {
		double ans = 1.0;
		Set<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(x);
		visited.add(x);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i  = 0; i < size; i++) {
				String node = queue.poll();
				HashMap<String, Double> children = map.get(node);
				if(map.containsKey(y)) {
					ans*=children.get(y);
					return ans;
				}
				else {
					Set<String> keys = children.keySet();
					for(String key: keys) {
						if(!visited.contains(key)) {
							ans*=children.get(key);
							queue.add(key);
						}
					}
				}
			}
		}
		return ans;
	}
	
	private void createAdjacencyList(List<List<String>> equations, double[] values) {
		int i;
		for(i = 0; i < equations.size(); i++) {
			List<String>equation = equations.get(i);
			String numerator = equation.get(0);
			String denominator = equation.get(1);
			HashMap<String, Double> temp = null;
			if(!map.containsKey(numerator)) {
				map.put(numerator, new HashMap<String, Double>());
			}
			if(!map.containsKey(denominator)) {
				map.put(denominator, new HashMap<String, Double>());
			}
			temp = map.get(numerator);
			temp.put(denominator, values[i]);
			map.put(numerator, temp);
			
			temp = map.get(denominator);
			temp.put(numerator, 1.0/values[i]);
			map.put(denominator, temp);
			
		}
	}

}
