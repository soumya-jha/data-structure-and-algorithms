package org.techinterviewhandbook.grind75;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val
                || (p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }
        if (p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(2);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(3);
        node.left.right.right = new TreeNode(5);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(9);

        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(node, node.left, node.right).val); //6, 2, 8
        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(node, node.left, node.left.right).val); //6, 2, 4
    }
}

