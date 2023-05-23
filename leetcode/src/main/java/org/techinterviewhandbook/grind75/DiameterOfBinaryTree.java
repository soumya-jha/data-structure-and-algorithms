package org.techinterviewhandbook.grind75;

public class DiameterOfBinaryTree {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findDepth(root);
        return maxDiameter;
    }

    public int findDepth(TreeNode node) {
        if (node == null)
            return 0;
        int left = findDepth(node.left); //depth of left tree
        int right = findDepth(node.right); //depth of left tree
        int currDiameter = left + right;
        maxDiameter = Math.max(maxDiameter, currDiameter);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(node));
    }
}
