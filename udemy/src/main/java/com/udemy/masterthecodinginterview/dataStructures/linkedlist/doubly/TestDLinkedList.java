package com.udemy.masterthecodinginterview.dataStructures.linkedlist.doubly;

public class TestDLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(10);
		System.out.println(list.printList() + " :: Size :: " + list.size);
		list.add(5);
		System.out.println(list.printList() + " :: Size :: " + list.size);
		System.out.println(list.getIndex(5));
		list.add(1, 15);
		System.out.println(list.printList() + " :: Size :: " + list.size);
		list.add(2, 20);
		System.out.println(list.printList() + " :: Size :: " + list.size);
		list.add(4, 25);
		System.out.println(list.printList() + " :: Size :: " + list.size);
		list.add(0, 30);
		System.out.println(list.printList() + " :: Size :: " + list.size);
		list.add(20, 20);//Invalid index
		System.out.println(list.printList() + " :: Size :: " + list.size);
		System.out.println(list.getIndex(15));
		
	}

}
