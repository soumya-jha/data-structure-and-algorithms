package com.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

	public static void main(String[] args) {
		//Integer[] arr = { 3, 9, 20, null, null, 15, 7 };
		Integer[] arr = {1,null,2,3};
		//Integer[] arr = {1};
		//Integer[] arr = {};
		TreeNode tree = new BinaryTree().createTree(arr, 0);
		PreorderTraversal preOrdObj = new PreorderTraversal();
		List<Integer> preOrderList = preOrdObj.preorderTraversal(tree);
		System.out.println(preOrderList);
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preOrder = new ArrayList<Integer>();
		if (root != null) {
			addNodetoList(root, preOrder);
		}
		return preOrder;
	}

	public List<Integer> addNodetoList(TreeNode root, List<Integer> preOderList) {
		if (root != null) {
			preOderList.add(root.val);
			addNodetoList(root.left, preOderList);
			addNodetoList(root.right, preOderList);
		}
		return preOderList;
	}

}
