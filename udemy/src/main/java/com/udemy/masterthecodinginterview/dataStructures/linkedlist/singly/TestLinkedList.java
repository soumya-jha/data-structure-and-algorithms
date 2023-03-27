package com.udemy.masterthecodinginterview.dataStructures.linkedlist.singly;

public class TestLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		System.out.println(list);
		list.add(10);
		System.out.println(list);
		list.add(5);
		System.out.println(list);
		list.add(16);
		System.out.println(list);
		list.addAtHead(18);
		System.out.println(list);
		list.remove(5);
		System.out.println(list);
		list.removeAtIndex(1);
		System.out.println(list);
		list.remove(18);
		System.out.println(list);
		list.remove(2);// 2 is not in the list
		System.out.println(list);
		list.remove(16);
		System.out.println(list);
		list.remove(10);// list is now empty
		System.out.println(list);
		System.out.println(list.head);
		System.out.println(list.tail);
		//list.add(30);
		//System.out.println(list);
		list.add(0, 28);
		System.out.println(list);
		list.add(1, 30);
		System.out.println(list);
		System.out.println(list.head);
		System.out.println(list.tail);
		//test reverse
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		list.add(25);
		System.out.println(list.printList());
		list.reverse();
		System.out.println(list.printList());
	}
}
