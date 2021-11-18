package org.code;

public class LowestCommonAncestor {
	TreeNode node = null;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		lowestCommonAncestorHelper(root, p, q);
        return node;
    }
	
	private void lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return;
		if( root.left != null && root.right != null){
            if((root.left.val == p.val && root.right.val == q.val)|| (root.left.val == q.val && root.right.val == p.val)){
                node = root;
                return;
            }
        }
        if(root.val == p.val){
            if(isFound(root.left, q.val) || isFound(root.right, q.val) ){
                node = root;
                return;
            }
        }
        if(root.val == q.val){
            if(isFound(root.left, p.val) || isFound(root.right, p.val)){
                node = root;
                return;
            }
        }
        if(isFound(root.left, p.val) && isFound(root.right, q.val) || isFound(root.left, q.val) && isFound(root.right, p.val)) {
        	node = root;
        	return;
        }
        lowestCommonAncestorHelper(root.left, p, q);
        lowestCommonAncestorHelper(root.right, p, q);
	}

	private boolean isFound(TreeNode root, int val) {
		if(root == null)
			return false;
		if (root.val == val)
			return true;
		if (isFound(root.left, val) || isFound(root.right, val))
			return true;
		return false;
	}
}
