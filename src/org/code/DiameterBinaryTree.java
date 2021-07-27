package org.code;

import static java.lang.Integer.max;

/**
 * https://www.techiedelight.com/find-diameter-of-a-binary-tree/
 * There are three cases to consider when trying to find the
 * longest path between two nodes in a binary tree (diameter):
 *
 * The longest path passes through the root,
 * The longest path is entirely contained in the left sub-tree,
 * The longest path is entirely contained in the right sub-tree.
 * The longest path through the root is simply the sum of the heights of the left and right sub-trees + 1
 * (for the root node), and the other two can be found recursively:
 */
//TODO: The issue lies when the longest path doesn't not go through the root
public class DiameterBinaryTree {

    public static void main(String argv[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.left.left.left.right = new TreeNode(10);
        root.left.right.right = new TreeNode(9);
        root.left.right.right.left = new TreeNode(11);

        System.out.println(diameter(root));
    }

    public static int diameter(TreeNode root){
        int maxDiameter = 0;
        return diameterHelper(root, maxDiameter) ;
    }

    public static int diameterHelper(TreeNode root, int maxDiameter){
        if(root == null ) return 0;
        int leftDiameter = diameterHelper(root.left, maxDiameter);
        int leftHeight = findHeight(root.left);
        int rightDiameter = diameterHelper(root.right, maxDiameter);
        int rightHeight = findHeight(root.right);
        return  Math.max(Math.max(leftDiameter, rightDiameter), leftHeight + rightHeight);
    }

    public static int findHeight(TreeNode root ){
        int countLeft = Integer.MIN_VALUE;
        int countRight = Integer.MIN_VALUE;
        return findHeightHelper(root, countLeft, countRight) ;
    }

    public static int findHeightHelper(TreeNode root, int countLeft, int countRight){
        if(root == null ) return 0;
        countLeft = 1 + findHeightHelper(root.left, countLeft, countRight);
        countRight = 1 + findHeightHelper(root.right, countLeft, countRight);
        return Math.max(countLeft, countRight) ;
    }
}
