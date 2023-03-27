package com.udemy.masterthecodinginterview.dataStructures.linkedlist;

public class SwappingNodes {
    public static void main(String[] args) {
        SwappingNodes sn = new SwappingNodes();
        ListNode node = new ListNode(1);
        ListNode currNode = node;
        for (int i = 2; i <= 5; i++) {
            currNode.next = new ListNode(i);
            currNode = currNode.next;
        }
        ListNode result = sn.swapNodes(node, 4);
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode leftNode = null, rightNode = head;
        ListNode currNode = head;
        while (currNode != null) {
            k--;
            if (k == 0) {
                leftNode = currNode;
            }
            currNode = currNode.next;
            if (k < 0) {
                rightNode = rightNode.next;
            }
        }
        int temp = rightNode.val;
        rightNode.val = leftNode.val;
        leftNode.val = temp;
        return head;
    }
}
