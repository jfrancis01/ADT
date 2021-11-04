package org.code;

import java.util.HashSet;

public class SumToLeafBinary {
	int sum = 0;
	HashSet<String> nums = new HashSet<String>();
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		/*
		 * root.left.left = new TreeNode(0); root.left.right = new TreeNode(1);
		 * root.right.left = new TreeNode(0); root.right.right = new TreeNode(1);
		 */
		
		SumToLeafBinary stl = new SumToLeafBinary();
		System.out.println(stl.sumRootToLeaf(root));
	}

	public int sumRootToLeaf(TreeNode root) {
		sumRootToLeafHelper(root, ""); 
		return sum;
	}
	private void sumRootToLeafHelper(TreeNode root, String s) {
		s += root.val;
		if(root.left == null & root.right == null) {
			sum += Integer.parseInt(s, 2);
		}
		else {
			if(root.left != null)sumRootToLeafHelper(root.left, s);
			if(root.right != null)sumRootToLeafHelper(root.right, s);
		}
	}

}
