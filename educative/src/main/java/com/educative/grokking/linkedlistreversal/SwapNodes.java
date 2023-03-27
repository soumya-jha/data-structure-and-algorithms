package com.educative.grokking.linkedlistreversal;


import com.educative.grokking.helper.LinkedListNode;

public class SwapNodes {

    public static void main(String[] args) {
        ReverseNodesInKGroup rn = new ReverseNodesInKGroup();
        LinkedListNode node = new LinkedListNode(1);
        LinkedListNode currNode = node;
        for (int i = 2; i <= 8; i++) {
            currNode.next = new LinkedListNode(i);
            currNode = currNode.next;
        }
        LinkedListNode result = swapNodes(node, 3);
    }

    public static LinkedListNode swapNodes(LinkedListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode firstNode = null;
        while (fast.next != null) {
            k--;
            if (k > 0) {
                fast = fast.next;
                if(k==1 && fast.next==null){
                    firstNode = fast;
                }
                continue;
            }
            if (k == 0) {
                firstNode = fast;
            }
            slow = slow.next;
            fast = fast.next;
        }
        if (firstNode == slow) {
            return head;
        }
        //swap values of the two node (not the actual nodes)
        int temp = slow.data;
        slow.data = firstNode.data;
        firstNode.data = temp;

        return head;
    }
}
