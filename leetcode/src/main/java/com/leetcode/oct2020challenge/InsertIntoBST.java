package com.leetcode.oct2020challenge;

//Code is correct. Check how to run this code
public class InsertIntoBST {
	TreeNode root;
	public static void main(String[] args) {
		InsertIntoBST tree = new InsertIntoBST();
		/*
		 * tree.insert(50); tree.insert(30); tree.insert(20); tree.insert(70);
		 * tree.insert(60); tree.insert(80);
		 */
		TreeNode root = new TreeNode();
		root = tree.insertIntoBST(root, 40);
		System.out.println(root.val);
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		 if (root == null) { 
	            root = new TreeNode(val); 
	            return root; 
	        } 
	  
	        if (val < root.val) 
	            root.left = insertIntoBST(root.left, val); 
	        else if (val > root.val) 
	            root.right = insertIntoBST(root.right, val); 
	  
		return root;
	}
	
	/*
	 * public void insert(int key) { root = insertIntoBST(root, key); }
	 */
}
