package org.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.code.RottingOranges.Pair;

public class EvaluateDivision {
	
	class Pair{
		String node = "";
		double val = 0.0;
		Pair(String node, double val){
			this.node = node;
			this.val = val;
		}
	}
	
	HashMap<String, HashMap<String, Double>>map = 
			new HashMap<String, HashMap<String, Double>>();
	

	public static void main(String[] args) {
		EvaluateDivision ed = new EvaluateDivision();
		List<List<String>> equations = new ArrayList<List<String>>();
		List<String> eq1 = new ArrayList<String>();
		List<String> eq2 = new ArrayList<String>();
		List<String> eq3 = new ArrayList<String>();
		List<String> eq4 = new ArrayList<String>();
		eq1.add("x1");
		eq1.add("x2");
		eq2.add("x2");
		eq2.add("x3");
		eq3.add("x3");
		eq3.add("x4");
		eq4.add("x4");
		eq4.add("x5");
		equations.add(eq1);
		equations.add(eq2);
		equations.add(eq3);
		equations.add(eq4);
		List<List<String>> queries = new ArrayList<List<String>>();
		List<String> q1 = new ArrayList<String>();
		List<String> q2 = new ArrayList<String>();
		List<String> q3 = new ArrayList<String>();
		List<String> q4 = new ArrayList<String>();
		List<String> q5 = new ArrayList<String>();
		q1.add("x1");
		q1.add("x5");
		q2.add("x5");
		q2.add("x2");
		q3.add("x2");
		q3.add("x4");
		q4.add("x2");
		q4.add("x2");
		q5.add("x2");
		q5.add("x9");
		queries.add(q1);
		queries.add(q2);
		queries.add(q3);
		queries.add(q4);
		queries.add(q5);
		double[] values = {3.0,4.0,5.0,6.0};
		double[] ans = ed.calcEquation(equations, values, queries);
		Arrays.stream(ans).forEach(x->System.out.print(x + " "));

	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		createAdjacencyList(equations, values);
		double[] ans = new double[queries.size()];
		int index = 0;
		for(List<String> query : queries) {
			String x = query.get(0);
			String y = query.get(1);
			if(!map.containsKey(x)||!map.containsKey(y)) {
				ans[index] = -1;
			}
			else if(x.equals(y)) {
				ans[index] = 1.0;
			}
			else {
				//perform bfs
				ans[index] = bfs(new Pair(x, 1.0), new Pair(y, 1.0));
			}
			index++;
		}
		return ans;
	}
	
	private double bfs(Pair x, Pair y) {
		Set<String> visited = new HashSet<String>();
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(x);
		visited.add(x.node);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i  = 0; i < size; i++) {
				Pair temp = queue.poll();
				String node = temp.node;
				HashMap<String, Double> children = map.get(node);
				if(children.containsKey(y.node)) {
					return temp.val * children.get(y.node);
				}
				else {
					Set<String> keys = children.keySet();
					for(String key: keys) {
						if(!visited.contains(key)) {
							visited.add(key);
							queue.add(new Pair(key, children.get(key) * temp.val));
						}
					}
				}
			}
		}
		return -1;
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
