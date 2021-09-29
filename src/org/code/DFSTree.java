package org.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode (5);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		DFSTree dfsTree = new DFSTree();
	}
	
	public void traverseTree(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		stack.add(root);
		while(!(stack.isEmpty())) {
			TreeNode node = stack.pop();
			visited.add(node);
			if(node.right != null && !(visited.contains(node.right)))stack.push(node.right);
			if(node.left != null && !(visited.contains(node.left)))stack.push(node.left);
			System.out.println (node.val);
		}
	}
}
