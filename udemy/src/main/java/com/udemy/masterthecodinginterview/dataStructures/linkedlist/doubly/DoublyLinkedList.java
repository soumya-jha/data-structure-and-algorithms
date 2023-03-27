package com.udemy.masterthecodinginterview.dataStructures.linkedlist.doubly;

import java.util.ArrayList;

public class DoublyLinkedList {
	Node head;
	Node tail;
	int size;

	public DoublyLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	private class Node {
		int val;
		Node nextNode;
		Node prevNode;

		Node(int val) {
			this.val = val;
			this.nextNode = null;
			this.prevNode = null;
		}
	}

	public int add(int val) { // addLast
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			tail = newNode;
			size++;
		} else {
			tail.nextNode = newNode;
			newNode.prevNode = tail;
			tail = newNode;
			size++;
		}
		return 1;
	}

	public int add(int idx, int val) { // addAtIndex
		if (idx < 0 || idx > size) {
			return -1;
		} else {
			Node newNode = new Node(val);
			if (idx == 0 && head == null) {
				head = tail = newNode;
			}else if(idx == 0) {
				newNode.nextNode=head;
				head=newNode;
			}else if(idx==size) {
				newNode.prevNode=tail;
				tail.nextNode=newNode;
				tail=newNode;
			}else {
				Node currNode = head;
				Node prevNode = null;
				int currIdx=0;
				while(currIdx!=idx) {
					prevNode=currNode;
					currNode=currNode.nextNode;
					currIdx++;
				}
				if(currIdx==idx) {
					newNode.prevNode=prevNode;
					prevNode.nextNode=newNode;
					newNode.nextNode=currNode;
					currNode.prevNode=newNode;
				}
			}
		}
		size++;
		return 1;
	}

	public int getIndex(int val) {
		Node currNode = head;
		int idx = 0;
		while (currNode != null && currNode.val != val) {
			currNode = currNode.nextNode;
			idx++;
		}
		if (currNode != null && currNode.val == val) {
			return idx;
		}
		return -1;
	}

	public ArrayList<Integer> printList() {
		ArrayList<Integer> values = new ArrayList<>();
		Node currentNode = head;
		while (currentNode != null) {
			values.add(currentNode.val);
			currentNode = currentNode.nextNode;
		}
		return values;
	}
}
