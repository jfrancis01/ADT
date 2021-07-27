package org.code;

public class MyLinkedList {
	// attributes
	private int size = 0;
	private Node head = null;

	/** Initialize your data structure here. */
	public class Node {
		public int val;
		public Node next;

		Node(int val) {
			this.val = val;
		}

		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	public MyLinkedList() {
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		int count = 0;
		if(index == 0) return head.val;
		Node iterator = head;
		while(iterator != null) {
			if (index == count) {
				return iterator.val;
			}
			iterator = iterator.next;
			count++;
		}
		return -1;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		if (isEmpty()) {
			head = new Node(val);
		} else {
			Node temp = head;
			head = new Node(val, temp);
		}
		size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		if (head == null) {
			head = new Node(val, null);
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(val, null);
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
		int count = 0;
		int size = size();
		if (!isEmpty()) {
			if (size() == index) {
				addAtTail(val); // add to the end
			}
			else if(index == 0) {
				addAtHead(val);
			}
			else if(index > size) {
				return;
			}
			else {
				Node iterator = head;
				while (iterator != null) {
					if (index == count + 1) {
						Node temp = iterator.next;
						iterator.next = new Node(val, temp);
						iterator.next.next = temp;
						this.size++;
						break;
					}
					iterator = iterator.next;
					count++;
				}
			}
		}
		else {
			addAtHead(val);
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		int count = 0;
		if (!isEmpty()) {
			if(index == 0) {
				head = head.next;
				return;
			}
			else if(size()== index) {
				//do nothing
			}
			else {
				Node iterator = head;
				while (iterator != null) {
					if (index == count + 1) {
						Node temp = iterator.next.next;
						iterator.next = temp;
						size--;
						break;
					}
					iterator = iterator.next;
					count++;
				}
			}
		}
	}

	private int size() {
		return this.size;
	}

	private boolean isEmpty() {
		if (this.size == 0)
			return true;
		return false;
	}

	public static void main(String argv[]) {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addAtHead(2);
		myLinkedList.deleteAtIndex(1);
		myLinkedList.addAtHead(2);
		myLinkedList.addAtHead(7);
		myLinkedList.addAtHead(3);
		myLinkedList.addAtHead(2);
		myLinkedList.addAtHead(5);
		myLinkedList.addAtTail(5);
		myLinkedList.get(6);
		myLinkedList.deleteAtIndex(6);
		myLinkedList.deleteAtIndex(4);
	}
}
