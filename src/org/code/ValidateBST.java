package org.code;

public class ValidateBST {

	public static void main(String argv[]) {
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right = new TreeNode(24);
		root.right.left = new TreeNode(23);
		root.right.right = new TreeNode(26);
		ValidateBST vbst = new ValidateBST();
		System.out.println(vbst.isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (root.left != null) {
			if (!(root.left.val < root.val))
				return false;
		}
		if (root.right != null) {
			if (!(root.right.val > root.val))
				return false;
		}
		boolean left = isValidBSTHelper(root.left, Long.MIN_VALUE, root.val);
		boolean right = isValidBSTHelper(root.right, root.val, Long.MAX_VALUE);
		if (left && right)
			return true;
		return false;
	}

	public boolean isValidBSTHelper(TreeNode node, long min, long max) {
		if (node == null)
			return true;
		boolean left = true;
		boolean right = true;
		if (node.left != null) {
			if (((node.left.val < node.val) && (node.left.val < max) && (node.left.val > min))) {
				left = isValidBSTHelper(node.left, min, node.val);
			} else {
				left = false;
			}
		}
		if (node.right != null) {
			if (((node.right.val > node.val) && (node.right.val > min) && (node.right.val < max))) {
				right = isValidBSTHelper(node.right, node.val, max);
			} else {
				left = false;
			}
		}
		if (left && right)
			return true;
		return false;
	}
}
