package com.educative.grokking.linkedlistreversal;


import com.educative.grokking.helper.LinkedListNode;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        ReverseNodesInKGroup rn = new ReverseNodesInKGroup();
        LinkedListNode node = new LinkedListNode(1);
        LinkedListNode currNode = node;
        for (int i = 2; i <= 9; i++) {
            currNode.next = new LinkedListNode(i);
            currNode = currNode.next;
        }
        //Input: head = [1,2,3,4,5,6,7,8], k = 3
        // New head = [3,2,1,4,5,6,7,8], k = 3
        // Result = [3,2,1,6,5,4,7,8] k = 3
        LinkedListNode result = reverseBetween(node, 1,9);
    }

    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        if(right-left == 0){
            return head;
        }
        int count = 0;
        LinkedListNode currNode = head;
        LinkedListNode prevNode = null;
        LinkedListNode leftTempNode = null;
        LinkedListNode rightTempNode = null;
        while(count<right && currNode!=null){
            count++;
            if(count<left) {
                prevNode = currNode;
                currNode = currNode.next;
                continue;
            }
            if(count==left){
                leftTempNode = prevNode;
                rightTempNode = currNode;
            }
            LinkedListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            if(count==right){
                if(leftTempNode!=null)
                    leftTempNode.next = prevNode;
                rightTempNode.next = nextNode;
                if(left==1){
                    head = prevNode;
                }
            }
        }
        return head;
    }
}
