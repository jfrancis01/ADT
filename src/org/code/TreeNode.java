package org.code;

public class TreeNode {
	public TreeNode left = null;
	public TreeNode right = null;
	public TreeNode[] children = null;
	public int val;
	
	TreeNode(){
	}
	
	TreeNode(TreeNode[] children){
		this,children = children;
	}
	TreeNode(int val){
		this.val = val;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	int getVal() {
		return this.val;
	}
}
