package com.educative.grokking.linkedlistreversal;


import com.educative.grokking.helper.LinkedListNode;

//Pending
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ReverseNodesInKGroup rn = new ReverseNodesInKGroup();
        LinkedListNode node = new LinkedListNode(1);
        LinkedListNode currNode = node;
        for (int i = 2; i <= 6; i++) {
            currNode.next = new LinkedListNode(i);
            currNode = currNode.next;
        }
        //Input: head = [1,2,3,4,5,6,7,8], k = 3
        // New head = [3,2,1,4,5,6,7,8], k = 3
        // Result = [3,2,1,6,5,4,7,8] k = 3
        LinkedListNode result = rn.reverseLinkedList(node, 3);
    }
    public static LinkedListNode reverseLinkedList(LinkedListNode head, int k) {
        if(k==1){
            return head;
        }
        int count = 0;
        LinkedListNode currNode = head;
        LinkedListNode prev = null;
        boolean firstSet = false;
        LinkedListNode temp = head;
        //1 2 3 4 5 6--- 3 2 1 6 5 4
        while(currNode!=null){
            LinkedListNode nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
            count++;
            if(count==k){
                count = 0;
                if(!firstSet){
                    head=prev;
                    firstSet = true;
                }
                temp.next = nextNode;
                prev = temp;
                temp = nextNode;

            }
        }
        return head;
    }
}
