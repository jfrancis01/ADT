package org.code;

public class LCABinaryTree {

	TreeNode node = null;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		LCABinaryTree lcabt = new LCABinaryTree();
		System.out.println(lcabt.lowestCommonAncestor(root, root.left.right.left, root.right.right));
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		traverse(root, p.val, q.val);
		return node;
	}

	private void traverse(TreeNode root, int p, int q) {

		if (root == null)
			return;

		if (root.left != null && root.right != null) {
			if ((root.left.val == p && root.right.val == q) || (root.left.val == q && root.right.val == p)) {
				node = root;
				return;
			}
		}

		// if value p matches the root, then search for q on either side of the left or
		// right
		if ((root.val == p)) {
			if (isFound(root.left, q) || isFound(root.right, q)) {
				node = root;
				return;
			}
		}
		// if value q matches the root, then search for p on either side of the left or
		// right
		if ((root.val == q)) {
			if (isFound(root.left, p) || isFound(root.right, p)) {
				node = root;
				return;
			}
		}
		if (isFound(root.left, p) && isFound(root.right, q) || isFound(root.left, q) && isFound(root.right, p)) {
			node = root;
			return;
		}
		traverse(root.left, p, q);
		traverse(root.right, p, q);
	}

	public boolean isFound(TreeNode root, int value) {
		if (root == null)
			return false;
		if (root.val == value)
			return true;
		return isFound(root.left, value) || isFound(root.right, value);
	}

}
