package com.leetcode.binaryTree;

/*				3
 *	 	9				20
 * null null		15		7*	
 */

public class BinaryTree {

	public static void main(String[] args) {
		//Integer[] arr = {3,9,20,null,null,15,7};
		//Integer[] arr =	{2,null,3,null,4,null,5,null,6};
		Integer[] arr = {1,null,2,3};//Issue
		BinaryTree binTree = new BinaryTree();
		TreeNode tree = binTree.createTree(arr, 0); //Can run code in debug and check tree formation
	}

	public TreeNode createTree(Integer[] arr, int index) {
		TreeNode root = null;
		if(arr==null) {
			return null;
		}
		if(index>arr.length-1 || arr[index]==null) {
			return null;
		}
		root = new TreeNode(arr[index]);
		int leftIndex, rightIndex;
		leftIndex = (index*2) + 1;
		rightIndex = (index*2) + 2;
		root.left = createTree(arr, leftIndex);
		root.right = createTree(arr, rightIndex);
		return root;
	}
}
