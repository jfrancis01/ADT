package org.code;

import java.util.ArrayDeque;

public class SameTree {
	
	public static void main(String argv[]) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		p.left.left = new TreeNode(4);
		
		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);
		q.left.left = new TreeNode(4);
		
		SameTree st = new SameTree();
		
		System.out.println(st.isSameTree(p,q));
	}

	private boolean isSameTree(TreeNode p, TreeNode q) {
		
		//first check p and q
		if(check(p,q)) {
			ArrayDeque<TreeNode> pqueue = new ArrayDeque<TreeNode>();
			ArrayDeque<TreeNode> qqueue = new ArrayDeque<TreeNode>();
			
			pqueue.add(p);
			qqueue.add(q);
			
			while(!pqueue.isEmpty()) {
				TreeNode currentP = pqueue.poll();
				TreeNode currentQ = qqueue.poll();
				if(check(currentP.left, currentQ.left)) {
					if(currentP.left != null && currentQ.left != null) {
						pqueue.add(currentP.left);
						qqueue.add(currentQ.left);
					}
				}
				else {
					return false;
				}
				if(check(currentP.right, currentQ.right)) {
					if(currentP.right != null && currentQ.right != null) {
						pqueue.add(currentP.right);
						qqueue.add(currentQ.right);
					}
				}
				else {
					return false;
				}
			}
			if(!qqueue.isEmpty()) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean check(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		if(p == null || q == null) return false;
		if(p.val != q.val)return false;
		return true;
	}

}
