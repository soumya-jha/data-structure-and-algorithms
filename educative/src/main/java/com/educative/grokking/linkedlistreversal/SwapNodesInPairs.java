package com.educative.grokking.linkedlistreversal;

import com.educative.grokking.helper.LinkedListNode;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ReverseNodesInKGroup rn = new ReverseNodesInKGroup();
        LinkedListNode node = new LinkedListNode(1);
        LinkedListNode currNode = node;
        for (int i = 2; i <= 4; i++) {
            currNode.next = new LinkedListNode(i);
            currNode = currNode.next;
        }
        LinkedListNode result = swapPairs(node);
    }

    public static LinkedListNode swapPairs(LinkedListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        int count = 0;
        LinkedListNode currNode = root;
        LinkedListNode prevNode = null;
        LinkedListNode node1 = null;
        boolean setHead = false;
//1, 2, 3, 4, 5
        while (currNode != null) {
            count++;
            if (count < 2) {
                node1 = currNode;
                currNode = currNode.next;
            } else {
                if (prevNode != null) {
                    prevNode.next = currNode;
                }
                //prevNode.next=currNode;
                LinkedListNode nextNode = currNode.next;
                currNode.next = node1;
                node1.next = nextNode;
                count = 0;
                if (!setHead) {
                    root = currNode;
                    setHead = true;
                }
                prevNode = node1;
                currNode = nextNode;
            }
        }
        return root;
    }
}
