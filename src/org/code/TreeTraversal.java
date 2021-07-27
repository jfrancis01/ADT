package org.code;

public class TreeTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(11);
		root.left.right.right = new TreeNode(12);
		root.right.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		preOrder(root);
	}
	
	public static void inOrder(TreeNode root) {
		if(root == null)return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
	
	public static void postOrder(TreeNode root) {
		if(root == null)return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}
	
	public static void preOrder(TreeNode root) {
		if(root == null) return;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

}
