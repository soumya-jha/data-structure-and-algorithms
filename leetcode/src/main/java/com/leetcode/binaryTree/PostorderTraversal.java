package com.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
//	Run with leetCode compiler
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> postOrder = new ArrayList<Integer>();
		if (root != null) {
			addNodetoList(root, postOrder);
		}
		return postOrder;
	}

	public List<Integer> addNodetoList(TreeNode root, List<Integer> postOrderList) {
		if (root != null) {
			if (root.left != null) {
				addNodetoList(root.left, postOrderList);
			}
			if (root.right != null) {
				addNodetoList(root.right, postOrderList);
			}
			postOrderList.add(root.val);
		}
		return postOrderList;
	}
}
