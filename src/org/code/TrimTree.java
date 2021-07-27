package org.code;

/**
 * 		1
 * 	   / \
 *    0   2 	
 * @author Joel
 *
 */

public class TrimTree {
	public static void main(String argv[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(2);
		
		int L = 1;
		int R = 2;
		
		trimBST(root, L, R);
		inOrder(root);
	}
	
	public static void trimBST(TreeNode root, int L, int R) {
		if(root != null) {
			trimBST(root.left, L, R);
			if(!checkVal(root, L, R)) {
				root= null;
			}
		}
	}
	
	public static boolean checkVal(TreeNode root, int L, int R) {
		boolean answer = ((root.getVal() >= L && root.getVal() <= R));
		return answer;
	}
	
	public static void inOrder(TreeNode node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.getVal() + " ");
		inOrder(node.right);
	}
}
