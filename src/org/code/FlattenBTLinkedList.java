package org.code;

public class FlattenBTLinkedList {

	public static void main(String[] args) {
		//[1,2,9,3,4,null,10,5,6,7,8]
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(7);
		root.left.left.right.right = new TreeNode(8);
		root.right = new TreeNode(9);
		root.right.right = new TreeNode(10);
		FlattenBTLinkedList fbst = new FlattenBTLinkedList();
		fbst.flatten(root);
	}

	 public void flatten(TreeNode root) {
			traverse(root);
		}
		
		public TreeNode traverse(TreeNode root) {
			if(root == null) return root;
			TreeNode left = traverse(root.left);
			TreeNode right = traverse(root.right);
			if(left != null) {
	            TreeNode temp = left;
	            while (temp != null && temp.right != null){
	                temp = temp.right;
	            }
	            //make the change
	            temp.right = root.right;
				root.right = left;
				root.left = null;
			}
			return root;
		}

}
