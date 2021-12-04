package org.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BinaryTreeKDistanceTarget {

	public static HashMap<TreeNode, ArrayList<TreeNode>> graph = new HashMap<TreeNode, ArrayList<TreeNode>>();

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		List<Integer> ans = BinaryTreeKDistanceTarget.distanceK(root, root.left, 2);
		for(int val : ans) {
			System.out.print(val + " ");
		}
	}

	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		// build an undirected graph
		List<Integer> ans = null;
		buildGraph(root);
		//perform breadth first search from the root
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if(target == null) return ans;
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		q.add(target);
		int level  = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			ans = new ArrayList<Integer>();
			while(size > 0) {
				TreeNode temp = q.poll();
				//System.out.println("Visting " + temp.val);
				ArrayList<TreeNode> children = graph.get(temp);
				for(TreeNode child : children) {
					if(!visited.contains(child)) {
						//System.out.println("Adding to queue " + child.val);
						q.add(child);
					}
				}
				//System.out.println("Addint to level " + temp.val);
				ans.add(temp.val);
				visited.add(temp);
				size--;
			}
			if(level == k) {
				return ans;
			}
			level++;
		}
		return null;
	}

	public static void buildGraph(TreeNode root) {
		if (root == null)
			return; 
		buildGraph(root.left);
		buildGraph(root.right);
		if (!graph.containsKey(root)) {
			graph.put(root, new ArrayList<TreeNode>());
		}
		ArrayList<TreeNode> children = graph.get(root);
		if (root.left != null) {
			children.add(root.left);
			if (!graph.containsKey(root.left)) {
				graph.put(root.left, new ArrayList<TreeNode>());
			} else {
				ArrayList<TreeNode> leftChildren = graph.get(root.left);
				leftChildren.add(root);
				graph.put(root.left, leftChildren);
			}
		}
		if (root.right != null) {
			children.add(root.right);
			if (!graph.containsKey(root.right)) {
				graph.put(root.right, new ArrayList<TreeNode>());
			} else {
				ArrayList<TreeNode> rightChildren = graph.get(root.right);
				rightChildren.add(root);
				graph.put(root.right, rightChildren);
			}
		}
		graph.put(root, children);
	}

	public static void printGraph() {
		Set<TreeNode> keySet = graph.keySet();
		for (TreeNode node : keySet) {
			System.out.println("Node " + node.val + ":  ");
			ArrayList<TreeNode> children = graph.get(node);
			for (TreeNode child : children) {
				System.out.print(child.val + " ");
			}
			System.out.println();
		}
	}

}
