package org.code;

public class NodeHeight {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(7);
		tree.right = new TreeNode(1);
		tree.left.left = new TreeNode(9);
		tree.left.right = new TreeNode(10);
		NodeHeight nh = new NodeHeight();
		System.out.println(nh.getHeight(tree, tree, 1));

	}

	public int getHeight(TreeNode tree, TreeNode node, int depth) {
		if (tree == null || node == null ) {
			return 0;
		}
		if(tree != null && tree == node) {
			return depth;
		}
		int left = 0;
		int right = 0;
		left = getHeight(tree.left, node, depth + 1);
		right = getHeight(tree.right, node, depth + 1);
		if (left != 0)
			return left;
		return right;
	}

}
