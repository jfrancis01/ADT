package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PathMaxProbaility {
	
	HashMap<Integer, Double> dist = new HashMap<Integer, Double>();
	
	class Link{
		int to;
		double weight;
		
		public Link(int to, double weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		
		HashMap<Integer, List<Link>> graph = new HashMap<Integer, List<Link>>();
		//add all the nodes to the distance map and set the distance of the starting node to 0;
		for(int i = 0; i < n; i++) {
			if(start == i) {
				dist.put(i, 1.0);
			}
			else {
				dist.put(i, Double.MIN_VALUE);
			}
		}
		
		//build the graph
		for(int i  = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			double weight = succProb[i];
			if(!graph.containsKey(edge[0])) {
				graph.put(edge[0], new ArrayList<Link>());
			}
			if(!graph.containsKey(edge[1])) {
				graph.put(edge[1], new ArrayList<Link>());
			}
			//undirected graph 
			graph.get(edge[0]).add(new Link (edge[1], weight));
			graph.get(edge[1]).add(new Link (edge[0], weight));
		}
		
		boolean[] seen = new boolean[n];
		//start by picking the node with the shortest calculated distance
		//at the start, it will be the "start" node itself
		while(true) {
			int candNode = -1;
			double candDist = Double.MIN_VALUE;
			for(int i = 0 ; i < n; i++) {
				if(!seen[i] && dist.get(i) > candDist) {
					candNode = i;
					candDist = dist.get(i);
				}
			}
			
			if(candNode < 0) {
				break; //this means there was a disconnected component
			}
			seen[candNode] = true;
			if(graph.containsKey(candNode)) {
				List<Link> children = graph.get(candNode);
				for(Link child : children) {
					dist.put(child.to, Math.max(dist.get(child.to), candDist * child.weight));
				}
			}
		}
		return dist.get(end);
	}

	public static void main(String[] args) {
		PathMaxProbaility pmp = new PathMaxProbaility();
		int n = 3;
		int[][] edges = {{0,1},{1,2},{0,2}};
		double[] succProb = {0.5,0.5,0.2};
		int start = 0;
		int end =  2;
		System.out.println(pmp.maxProbability(n, edges, succProb, start, end));
	}

}
