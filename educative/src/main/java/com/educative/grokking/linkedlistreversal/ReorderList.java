package com.educative.grokking.linkedlistreversal;

import com.educative.grokking.helper.LinkedListNode;

public class ReorderList {

    public static void main(String[] args) {
        ReverseNodesInKGroup rn = new ReverseNodesInKGroup();
        LinkedListNode node = new LinkedListNode(1);
        LinkedListNode currNode = node;
        for (int i = 2; i <= 5; i++) {
            currNode.next = new LinkedListNode(i);
            currNode = currNode.next;
        }
        //Input: head = [1,2,3,4,5,6,7,8], k = 3
        // New head = [3,2,1,4,5,6,7,8], k = 3
        // Result = [3,2,1,6,5,4,7,8] k = 3
        LinkedListNode result = reorderList(node);
    }


    public static LinkedListNode reorderList(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode prevNode = null;
        //LinkedListNode secondHead = null;
        boolean skip = false;
        while (fast != null && fast.next != null) {
            //reverse first half of linkedlist in slow traversal
            fast = fast.next.next;
            LinkedListNode nextNode = slow.next;
            slow.next = prevNode;
            prevNode = slow;
            slow = nextNode;
            if (fast == null || fast.next == null) {
                nextNode = slow.next;
                slow.next = prevNode;
                head = slow;
                slow = nextNode;
            }
            if (fast == null) {
                skip = true;
            }
        }
        //change pointers
        LinkedListNode currNode = head;
        while (slow != null && currNode != null) {
            if (skip) {
                currNode = currNode.next;
                skip = false;
            }
            LinkedListNode nextSlow = slow.next;
            LinkedListNode nextCurr = currNode.next;
            currNode.next = slow;
            slow.next = nextCurr;
            slow = nextSlow;
            currNode = nextCurr;
        }
        //reverse the entire linkedList and return head
        prevNode = null;
        while (head != null) {
            LinkedListNode nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }

        return prevNode;
    }
}
