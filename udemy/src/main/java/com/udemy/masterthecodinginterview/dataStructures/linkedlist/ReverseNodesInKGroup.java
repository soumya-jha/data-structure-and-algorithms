package com.udemy.masterthecodinginterview.dataStructures.linkedlist;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ReverseNodesInKGroup rn = new ReverseNodesInKGroup();
        ListNode node = new ListNode(1);
        ListNode currNode = node;
        for (int i = 2; i <= 8; i++) {
            currNode.next = new ListNode(i);
            currNode = currNode.next;
        }
        //Input: head = [1,2,3,4,5,6,7,8], k = 3
        // New head = [3,2,1,4,5,6,7,8], k = 3
        // Result = [3,2,1,6,5,4,7,8] k = 3
        ListNode result = rn.reverseKGroup(node, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        ListNode tempNode1 = null, tempNode2 = null;
        ListNode prev = null, next;
        int c = k;
        boolean newHeadCt = false;
        while (first != null || second != null) {
            if (c > 0 && first != null) {
                first = first.next;
                c--;
            } else if (c >= -k && c <= 0) {
                next = second.next;
                if (c == 0) {
                    second.next = first;
                    if (tempNode1 == null) {
                        tempNode1 = second;
                    } else {
                        tempNode2 = second;
                    }
                } else {
                    second.next = prev;
                }
                prev = second;
                second = next;
                c--;
                if (c == -k) {
                    c = k;
                    if (tempNode2 != null) {
                        tempNode1.next = prev;
                        tempNode1 = tempNode2;
                        tempNode2 = null;
                    }
                    if (!newHeadCt) {
                        head = prev;
                        newHeadCt = true;
                    }
                }
            } else {
                return head;
            }
        }
        return head;
    }
}
