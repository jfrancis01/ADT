package org.code;

public class PathSumIII {

	public static void main(String[] args) {
		PathSumIII psIII = new PathSumIII();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(-3);
		root.right.left = new TreeNode(-2);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(-1);
		
		System.out.println(psIII.pathSum(root, -1));
	}

	int ways = 0;

	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return 0;
		}
		helper(root, root.val, targetSum);
		pathSum(root.left, targetSum);
		pathSum(root.right, targetSum);
		return ways;
	}

	private void helper(TreeNode root, int sum, int targetSum) {
		if (root == null) {
			return;
		}
		if (sum == targetSum) {
			ways++;
		}
		if (root.left != null) {
			helper(root.left, sum + root.left.val, targetSum);
		}
		if (root.right != null) {
			helper(root.right, sum + root.right.val, targetSum);
		}
	}

}
