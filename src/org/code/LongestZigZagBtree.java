package org.code;

public class LongestZigZagBtree {
	int max = Integer.MIN_VALUE;

	public int longestZigZag(TreeNode root) {
		if (root.left == null && root.right == null) {
			return 0;
		}
		traverse(root);
		return max;
	}

	private void traverse(TreeNode root) {
		if (root == null)
			return;
		int leftDepth = helper(root.left, "right");
		int rightDepth = helper(root.right, "left");
		int localMax = Math.max(leftDepth, rightDepth);
		max = Math.max(localMax, max);
		traverse(root.left);
		traverse(root.right);
	}

	private int helper(TreeNode root, String dir) {
		if (root == null)
			return 0;
		if (dir.equals("left")) {
			return 1 + helper(root.left, "right");
		} else {
			return 1 + helper(root.right, "left");
		}

	}
}
