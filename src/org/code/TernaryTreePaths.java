package org.code;

import java.util.ArrayList;

public class TernaryTreePaths {
	
	private ArrayList<String> ans = new ArrayList<String>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode six = new TreeNode(6);
		TreeNode three = new TreeNode(3);
		TreeNode five_1 = new TreeNode(5);
		TreeNode five_2 = new TreeNode(5);
		
		TreeNode[] rootChilds = {two, five_1, three};
		root.children = rootChilds;
		
		TreeNode[] twoChilds = {four, five_2};
		two.children = twoChilds;
		
		TreeNode[] threeChilds = {six};
		three.children = threeChilds;
		
		TernaryTreePaths ttp = new TernaryTreePaths();
		String[] strs = ttp.ternaryTreePaths(root);
		for(String str : strs) {
			System.out.println(str);
		}
	}
	
	public String[] ternaryTreePaths(TreeNode root) {
        traverse(root, "");
        int size = ans.size();
        String[] strs = new String[size];
        for(int i = 0; i < size; i++) {
        	strs[i] = ans.get(i);
        }
        return strs;
    }
	
	public void traverse(TreeNode root, String str) {
		str+= root.val + "->";
		TreeNode[]children = root.children;
		if(children != null) {
			for(int i  = 0; i < children.length; i++) {
				traverse(children[i], str);
			}
		}
		else {
			ans.add(str.substring(0, str.length() - 2));
		}
	}

}
