package com.udemy.masterthecodinginterview.dataStructures.linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        // l1 = [5,4,3]
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        //l2 = [5,6,4]
        AddTwoNumbers atn = new AddTwoNumbers();
        //atn.addTwoNumbers(atn.reverse(l1), atn.reverse(l2));
        ListNode result = atn.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null || l2 != null || carry>0) {
            current.next = new ListNode();
            int sum = 0;
            if(l1!=null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum+=carry;
            current.next.val = sum%10;
            carry = (sum) / 10;
            current = current.next;
        }
        return head.next;
    }

    public ListNode reverse(ListNode node) {
        ListNode current = node;
        ListNode prev = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}