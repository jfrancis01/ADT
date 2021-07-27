package org.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		p.left.left = new TreeNode(4);
		p.left.right = new TreeNode(5);
		p.right.left = new TreeNode(6);
		p.right.right = new TreeNode(7);
		
		LevelOrderTraversal lot = new LevelOrderTraversal();
		
		List<List<Integer>> levels = lot.levelOrder(p);
		for(int i = 0 ; i < levels.size(); i++) {
			System.out.print(levels.get(i));
		}

	}
	
	public List<List<Integer>> levelOrder(TreeNode root){
		
		List<List<Integer>> levels = new ArrayList(); //return list
		Queue<TreeNode> queue = new LinkedList<TreeNode>(); //queue
		if(root == null)return levels;
		//add the first node to the queue
		queue.add(root);
		while(!queue.isEmpty()) {
			//get the current number of nodes int he queue
			int groupSize = queue.size();
			ArrayList<Integer> level = new ArrayList<Integer>();
			while(groupSize > 0) {
				TreeNode current = queue.poll();
				if(current.left != null) {
					queue.add(current.left);
				}
				if(current.right != null) {
					queue.add(current.right);
				}
				groupSize--;
				level.add(current.val);
			}
			levels.add(level);
		}
		
		return levels;
	}

}
