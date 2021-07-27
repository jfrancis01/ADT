package org.code;

public class BSTPreOrderConsturction {

	public static void main(String argv[]) {
		//int[] preOrder = { 8, 5, 1, 7, 10, 12 };
		int[] preOrder = {8,5, 1};
		bstFromPreorder(preOrder);
	}

	public static TreeNode bstFromPreorder(int[] preOrder) {
		TreeNode root = null;
		for (int i = 0; i < preOrder.length; i++) {
			root  = traverseTree(root, preOrder[i]);
		}
		return root;
	}

	public static TreeNode traverseTree(TreeNode root, int val) {
		if(root == null) {
			root = new TreeNode(val);
			return root;
		}
		if(root.getVal()> val) {
			root.left = traverseTree(root.left, val);
		}
		else {
			root.right = traverseTree(root.right, val);
		}
		return root;
	}
}
