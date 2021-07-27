package org.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	
	/** 
	 * Original:
	 *          1
	 *         / \
	 *        2   3
	 *       / \  / \
	 *      4   56   7
	 *     /
	 *     8
	 * Inverted:
	 *      
	 *      1
	 *     / \ 
	 *    3   2
	 *       / \ 
	 *      4   5
	 *      
	 *      DFS:
	 *      In-order (left, root, right): 4 2 5 1 3
	 *      Pre-order (root, left, right): 1 2 4 5 3
	 *      Post-Order (left right, root): 4 5 2 3 1 
	 *      
	 *      BFS:
	 *      Lever-order: 1 2 3 4 5
	 *      
	 *      [1,2,null,3,4,null,null,5]
	 *      1
	 *     2 null
	 *    3 4 null null
	 *   5   
	 * @param argv
	 */
	
	public static void main(String argv[]) {
		TreeNode binaryTree = new TreeNode(1);
		binaryTree.left = new TreeNode(2);
		binaryTree.left.left = new TreeNode(4);
		binaryTree.left.right = new TreeNode(5);
		binaryTree.left.left.left = new TreeNode(8);
		binaryTree.left.left.left.left = new TreeNode(9);
		binaryTree.right = new TreeNode(3);
		binaryTree.right.left = new TreeNode(6);
		binaryTree.right.right = new TreeNode(7);
		int x = 9;
		
		System.out.println("In-order: ");
		inOrder(binaryTree);
		System.out.println();
		System.out.println("pre-order: ");
		preOrder(binaryTree);
		System.out.println();
		System.out.println("post-order: ");
		postOrder(binaryTree);
		System.out.println();
		System.out.println("level-order: ");
		List<List<Integer>> result = levelOrder(binaryTree);
		printList(result);
		System.out.println();
		List<List<Integer>> anotherResult  = groupLevelOrder(binaryTree);
		System.out.println("group level-order: ");
		printList(anotherResult);
		System.out.println("Was  " + x + " found: " + findDepth(binaryTree, x, 0, 0)) ;
	}

	public static void printList(List<List<Integer>> result){
		for(int i=0; i < result.size();i++){
			System.out.print(result.get(i) + " ");
		}
	}

	public static void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.getVal() + " ");
			inOrder(root.right);
		}
	}
	public static void preOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.getVal() + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public  static void postOrder(TreeNode root) {
		if(root !=null ) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.getVal() + " ");
		}
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<List<Integer>> order= new LinkedList<List<Integer>>();
		List<Integer> levelOrder = null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		HashSet<Integer> visited = new HashSet<Integer>();
		if(root !=  null){
			queue.add(root); //add the source node to the queue
			List<Integer> rootOrder = new LinkedList<Integer>();
			rootOrder.add(root.getVal());
			order.add(rootOrder);
			while(!queue.isEmpty()) {
				TreeNode current = queue.poll();
				visited.add(current.getVal());
				levelOrder = new LinkedList<Integer>();
				if(current.left != null) {
					queue.add(current.left);
					levelOrder.add(current.left.getVal());
				}
				if(current.right != null) {
					queue.add(current.right);
					levelOrder.add(current.right.getVal());
				}
				if(!levelOrder.isEmpty()){
					order.add(levelOrder);
				}
			}
		}
		return order;
	}

	public static List<List<Integer>> groupLevelOrder(TreeNode root){
		List<List<Integer>> result= new LinkedList<List<Integer>>();
		if(root == null) return result; // if the root is null
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		//add the root to the queue
		queue.add(root);
		//process the queue
		while(!queue.isEmpty()){
			List<Integer> group = new LinkedList<Integer>();
			int groupSize = queue.size();
			while(groupSize > 0){
				TreeNode temp = queue.poll();
				if(temp.left != null){
					queue.add(temp.left);
				}
				if(temp.right != null){
					queue.add(temp.right);
				}
				groupSize = groupSize - 1;
				group.add(temp.getVal());
			}
			result.add(group);
		}
		return result;
	}
	
	public static int findDepth(TreeNode root, int val, int count, int level){
        if(root == null ) return 0;
		if(root.getVal() == val) return level;
		count = findDepth(root.left, val, count, level + 1);
		if(count == 0) {;
			count = findDepth(root.right, val, count, level + 1);
		}
		return count;
    }
	
	public static boolean isCousins(TreeNode root, int x, int y) {
		if(root == null) return false;
		if(root.getVal() == x) return true;
		boolean check = isCousins(root.left, x, y);
		if(check) {
			if(root.left.getVal() == x && root.right.getVal() == y || 
					root.left.getVal() == y  && root.right.getVal() == x) return false;
			return true;
		}
		return isCousins(root.right,x, y);
				
	}
}
