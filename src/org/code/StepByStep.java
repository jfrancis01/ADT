package org.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class StepByStep {

	HashMap<TreeNode, HashMap<TreeNode, String>> graph = new HashMap<TreeNode, HashMap<TreeNode, String>>();

	public static void main(String argv[]) {
		TreeNode root = new TreeNode (5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(4);
		StepByStep sbs = new StepByStep();
		sbs.getDirections(root, 3, 6);
		Set<TreeNode> keys = sbs.graph.keySet();
		for(TreeNode key : keys) {
			System.out.print(key.val + " ");
			System.out.print(sbs.graph.get(key));
			System.out.println();
		}
	}

	public String getDirections(TreeNode root, int startValue, int destValue) {
		// we do a inorder traversal
		inorder(root, null);
		//now we perform a breadth first search using the graph
		Set<TreeNode> keys = graph.keySet();
		TreeNode start = null;
		for(TreeNode key : keys) {
			if(key.val == startValue) {
				start = key;
				break;
			}
		}
		return bfs(start, destValue);
	}
	
	public String bfs(TreeNode root, int destValue) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		queue.add(root);
		StringBuilder sb = new StringBuilder("");
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				TreeNode current = queue.poll();
				if(current.val == destValue) {
					return sb.toString();
				}
				visited.add(current);
				HashMap<TreeNode, String> map = graph.get(current);
				Set<TreeNode> keys = graph.keySet();
				for(TreeNode key : keys) {
					if(!visited.contains(key)) {
						queue.add(key);
					}
				}
			}
		}
		return "";
	}

	public void inorder(TreeNode root, TreeNode parent) {
		if (root == null)
			return;
		inorder(root.left, root);
		inorder(root.right, root);
		if (root.left != null) {
			if (!graph.containsKey(root)) {
				graph.put(root, new HashMap<TreeNode, String>());
			}
			HashMap<TreeNode, String> map = graph.get(root);
			map.put(root.left, "L");
			graph.put(root, map);
		}
		if (root.right != null) {
			if (!graph.containsKey(root)) {
				graph.put(root, new HashMap<TreeNode, String>());
			}
			HashMap<TreeNode, String> map = graph.get(root);
			map.put(root.right, "R");
			graph.put(root, map);
		}
		if (parent != null) {
			if (!graph.containsKey(root)) {
				graph.put(root, new HashMap<TreeNode, String>());
			}
			HashMap<TreeNode, String> map = graph.get(root);
			map.put(parent, "U");
			graph.put(root, map);
		}
	}
}
