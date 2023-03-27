package com.educative.grokking.fastandslowpointers;

import com.educative.grokking.helper.LinkedListNode;

public class MiddleOfLinkedList {

    public static void main(String[] args) {

    }

    public static LinkedListNode middleNode(LinkedListNode head) {
        if(head.next == null){
            return head;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
