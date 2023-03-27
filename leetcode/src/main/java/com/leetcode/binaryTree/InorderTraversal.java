package com.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
//Run with leetCode compiler
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inOrder = new ArrayList<Integer>();
		if (root != null) {
			addNodetoList(root, inOrder);
		}
		return inOrder;
	}

	public List<Integer> addNodetoList1(TreeNode root, List<Integer> inOrderList) {
		if (root != null) {
			if (root.left == null) {
				inOrderList.add(root.val);
				if (root.right != null) {
					addNodetoList(root.right, inOrderList);
				}
				return inOrderList;
			} else {
				addNodetoList(root.left, inOrderList);
				inOrderList.add(root.val);
				if (root.right != null) {
					addNodetoList(root.right, inOrderList);
				}
			}
		}
		return inOrderList;
	}

	public List<Integer> addNodetoList(TreeNode root, List<Integer> inOrderList) {
		if (root != null) {
			if (root.left != null) {
				addNodetoList(root.left, inOrderList);
			}
			inOrderList.add(root.val);
			if (root.right != null) {
				addNodetoList(root.right, inOrderList);
			}
		}
		return inOrderList;
	}
}
