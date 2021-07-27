package org.code;

public class DoubleLinkedList {

	private Node head = null;
	private int size = 0;

	private class Node {

		public int val;
		public Node prev = null;
		public Node next = null;

		Node() {

		}

		Node(int val) {
			this.val = val;
		}

		Node(int val, Node prev, Node next) {
			this.val = val;
			this.prev = prev;
			this.next = next;
		}
	}

	/** Initialize your data structure here. */
	public DoubleLinkedList() {
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if (head == null)
			return -1;
		int count = 0;
		Node temp = head;
		while (temp != null) {
			if (index == count) {
				return temp.val;
			}
			count++;
			temp = temp.next;
		}
		return -1;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		if (head == null) {
			head = new Node(val, null, null);
		} else {
			Node newNode = new Node(val, null, head);
			head.prev = newNode;
			head = newNode;

		}
		size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		if (head == null) {
			addAtHead(val);
		} else {
			Node temp = head;
			while (temp != null && temp.next != null) {
				temp = temp.next;
			}
			// now temp has come to the last noe before null
			Node newNode = new Node(val, temp, null);
			temp.next = newNode;
		}
		size++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (head == null)
			return;
		if (index == 0) {
			addAtHead(val);
		} else if (size == index) {
			addAtTail(val);
		} else if (index > size) {
			// do nothing
		} else {
			int count = 0;
			Node temp = head;
			while (temp != null) {
				if (index == count + 1) {
					Node tempNext = temp.next;
					Node newNode = new Node(val, temp, tempNext);
					temp.next = newNode;
					tempNext.prev = newNode;
					break;
				}
				temp = temp.next;
				count++;
			}
			size++;
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		// delete head
		if (index == 0) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
			size--;
		}
		else if(size == index) {
			//do nothing
		}
		else {
			Node temp = head;
			int count = 0;
			while (temp != null) {
				if (index == count + 1) {
					Node next = temp.next.next;
					next.prev = temp;
					temp.next = next;
					size--;
					break;
				}
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {

		DoubleLinkedList myLinkedList = new DoubleLinkedList();
		myLinkedList.addAtHead(7);
		myLinkedList.addAtHead(2);
		myLinkedList.addAtHead(1);
		myLinkedList.addAtIndex(3, 0);
		myLinkedList.deleteAtIndex(2);
		myLinkedList.addAtHead(6);
		myLinkedList.addAtTail(4);
		myLinkedList.get(4);
		myLinkedList.addAtHead(4);
		myLinkedList.addAtIndex(5, 0);
		myLinkedList.addAtHead(6);
	}

}
