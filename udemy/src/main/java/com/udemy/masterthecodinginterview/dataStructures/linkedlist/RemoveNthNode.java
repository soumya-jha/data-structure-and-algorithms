package com.udemy.masterthecodinginterview.dataStructures.linkedlist;

public class RemoveNthNode {
    public static void main(String[] args) {
        /*Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]
         */
        RemoveNthNode rn = new RemoveNthNode();
        ListNode node = new ListNode(1);
        ListNode currNode = node;
        for (int i = 2; i <= 2; i++) {
            currNode.next = new ListNode(i);
            currNode = currNode.next;
        }
        ListNode result = rn.removeNthFromEnd(node, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        ListNode prevNode = null;

        while (node1 != null) {
            node1 = node1.next;
            if (n <= 0) {
                prevNode = node2;
                node2 = node2.next;
            }
            n--;
        }
        if(prevNode!=null) {
            prevNode.next = node2.next;
            return head;
        }else{
            return head.next;
        }
    }
}
