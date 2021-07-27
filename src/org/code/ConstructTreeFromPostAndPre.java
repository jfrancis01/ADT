package org.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeFromPostAndPre {

	public static void main(String argv[]) {
		int[] pre =  {2, 1};//{ 1, 2, 4, 5, 3, 6, 7 };
		int[] post = {1,2};//{ 4, 5, 2, 6, 7, 3, 1 };
		ConstructTreeFromPostAndPre cftpp = new ConstructTreeFromPostAndPre();
		TreeNode root = cftpp.constructFromPrePost(pre, post);
		System.out.println("Done");
		TreeTraversal.inOrder(root);
	}

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		HashSet<Integer> visited = new HashSet();
		HashSet<Integer> inQueue = new HashSet();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int rootVal = pre[0];
		// create root node
		TreeNode root = new TreeNode(rootVal);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			visited.add(current.val);
			current.left = null;
			current.right = null;
			int leftVal = searchLeftValue(current.val, pre, visited, inQueue);
			int rightVal = searchRightValue(current.val, post, visited, inQueue);
			if (leftVal != -1) {
				current.left = new TreeNode(leftVal);
				queue.add(current.left);
				inQueue.add(current.left.val);
			}
			if(rightVal != leftVal) {
				if (rightVal != -1) {
					current.right = new TreeNode(rightVal);
					queue.add(current.right);
					inQueue.add(current.right.val);
				}
			}
		}

		return root;
	}

	public int searchLeftValue(int current, int[] pre, HashSet<Integer> visited, HashSet<Integer> inQueue) {
		for (int i = 0; i < pre.length; i++) {
			if (pre[i] == current) {
				if (i + 1 <= pre.length - 1) {
					if (!visited.contains(pre[i + 1]) && !inQueue.contains(pre[i + 1])) {
						return pre[i + 1];
					} else {
						return -1;
					}
				}
			}
		}
		return -1;
	}

	public int searchRightValue(int current, int[] post, HashSet<Integer> visited, HashSet<Integer> inQueue) {
		for (int i = 0; i < post.length; i++) {
			if (post[i] == current) {
				if (i - 1 >= 0) {
					if (!visited.contains(post[i - 1]) && !inQueue.contains(post[i - 1])) {
						return post[i - 1];
					} else {
						return -1;
					}
				}
			}
		}
		return -1;
	}

}
