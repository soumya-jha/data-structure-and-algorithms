package com.udemy.masterthecodinginterview.dataStructures.linkedlist.singly;

import java.util.ArrayList;

public class SinglyLinkedList {
	Node head;
	Node tail;
	int size;

	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	private class Node {
		Node nextNode;
		int val;

		public Node(int val) {
			this.val = val;
			this.nextNode = null;
		}

		@Override
		public String toString() {
			return "Node [nextNode=" + nextNode + ", val=" + val + "]";
		}

	}

	public void add(int val) { // addAtTail
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.nextNode = newNode;
			tail = newNode;
		}
		size++;
	}

	public int add(int idx, int val) {
		/*
		 * if(head==null) { return -1; }
		 */
		int currIdx = 0;
		Node currentNode = head;
		Node previousNode = null;
		while (idx != currIdx) {
			if (currentNode.nextNode != null) {
				previousNode = currentNode;
				currentNode = currentNode.nextNode;
				currIdx++;
			} else {
				break;
			}
		}
		if (currIdx == idx) {
			Node newNode = new Node(val);
			if (idx == 0) {
				newNode.nextNode = currentNode;
				head = newNode;
			} else {
				previousNode.nextNode = newNode;
				newNode.nextNode = currentNode;
			}
			size++;
			return 1;
		} else if (currIdx == idx - 1) {
			Node newNode = new Node(val);
			currentNode.nextNode = newNode;
			tail = newNode;
			size++;
			return 1;
		}
		return -1;
	}

	public void addAtHead(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.nextNode = head;
			head = newNode;
		}
		size++;
	}

	public int remove(int val) {
		if (head == null) {
			return -1;
		}
		int currentVal = head.val;
		Node currentNode = head;
		if (currentVal == val) {
			head = head.nextNode;
			if (head == null) {
				tail = head;
			}
			size--;
			return 1;
		}
		Node previousNode = currentNode;
		while (currentVal != val) {
			if (currentNode.nextNode != null) {
				previousNode = currentNode;
				currentNode = currentNode.nextNode;
				currentVal = currentNode.val;
			} else {
				return -1;
			}
		}
		if (currentVal == val) {
			previousNode.nextNode = currentNode.nextNode;
			if (previousNode.nextNode == null) {
				tail = previousNode;
			}
			size--;
			return 1;
		}
		return -1;
	}

	public int removeAtIndex(int idx) {
		if (head == null || idx < 0 || idx >= size) {
			return -1;
		}
		if (idx == 0 && size == 1) {
			head = tail = null;
			size--;
			return 1;
		} else if (idx == 0 && size>1){
			head=head.nextNode;
			size--;
			return 1;
		}else {
			int currIdx = 0;
			Node currentNode = head;
			Node previousNode = null;
			while (currIdx != idx) {
				previousNode = currentNode;
				currentNode = currentNode.nextNode;
				currIdx++;
			}
			if (currIdx == idx) {
				previousNode.nextNode = currentNode.nextNode;
				if (currentNode.nextNode == null) {
					tail = previousNode;
				}
				size--;
				return 1;
			}
		}
		return -1;
	}
	
	public int reverse() {
		if(size==0)
			return -1;
		if(size==1)
			return 1;
		else {
			Node first = this.head;
			this.tail=this.head;
			Node second = this.head.nextNode;
			while(second!=null) {
				Node temp = second.nextNode;
				second.nextNode=first;
				first=second;
				second=temp;
			}
			this.head.nextNode=null;
			this.head=first;
		}
		return 1;
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

	@Override
	public String toString() {
		return "SinglyLinkedList [head=" + head + ", size=" + size + "]";
	}

}
