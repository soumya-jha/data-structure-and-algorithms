package org.techinterviewhandbook.grind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 3 ---------0
/  \
9   20 -----------1
	/  \
	15   7 ----------- 2
*/
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            List<Integer> currLevelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = nodeQueue.poll();
                currLevelNodes.add(currNode.val);
                if (currNode.left != null)
                    nodeQueue.offer(currNode.left);
                if (currNode.right != null)
                    nodeQueue.offer(currNode.right);
            }
            result.add(currLevelNodes);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(new LevelOrderTraversal().levelOrder(node));

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(2);
        System.out.println(new LevelOrderTraversal().levelOrder(node));
    }
}
