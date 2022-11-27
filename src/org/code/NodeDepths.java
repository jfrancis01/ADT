package org.code;

public class NodeDepths {

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.left.left = new BinaryTree(4);
		root.left.left.left = new BinaryTree(8);
		root.left.left.right = new BinaryTree(9);
		root.left.right = new BinaryTree(5);
		root.right = new BinaryTree(3);
		root.right.left = new BinaryTree(6);
		root.right.right = new BinaryTree(7);
		System.out.println(nodeDepths(root));
	}

	public static int nodeDepths(BinaryTree root) {
		int currentSum = 0;
		int currentDepth = 0;
		return helper(root, currentSum, currentDepth);
	}

	public static int helper(BinaryTree root, int currentSum, int currentDepth) {
		if (root == null)
			return 0;
		++currentDepth;
		if (root.left != null) {
			currentSum += currentDepth;
			currentSum = helper(root.left, currentSum, currentDepth);
		}
		if (root.left != null) {
			currentSum += currentDepth;
			currentSum = helper(root.right, currentSum, currentDepth);
		}
		return currentSum;
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

}
