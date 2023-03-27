package com.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/*
 3 ---------0
/  \
9   20 -----------1
	/  \
	15   7 ----------- 2 
*/
public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levelOrderList = new ArrayList<>();
		if (root != null) {
			addToList(root, levelOrderList, 0);
		}
		return levelOrderList;
	}
	
	public void addToList(TreeNode root, List<List<Integer>> levelOrderList, int level) {
		List<Integer> levelList = new ArrayList<Integer>();
		levelList.add(root.val);
		level++;
	}
}
