package org.techinterviewhandbook.grind75;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode leftNode = invertTree(node.left);
        TreeNode rightNode = invertTree(node.right);

        node.left = rightNode;
        node.right = leftNode;

        return node;
    }
}

