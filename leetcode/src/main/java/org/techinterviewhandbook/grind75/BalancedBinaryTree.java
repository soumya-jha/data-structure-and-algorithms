package org.techinterviewhandbook.grind75;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return bfs(root) != -1;
    }

    private int bfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = bfs(node.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = bfs(node.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new BalancedBinaryTree().isBalanced(root));
    }

}
