package org.techinterviewhandbook.grind75;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(node));
        node.right.right.right = new TreeNode(11);
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(node));
    }
}
