package org.code;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		OddEvenLinkedList oell = new OddEvenLinkedList();
		ListNode result = oell.oddEvenList(head);

	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode prev = null;
		int n = 1;
		while (head != null) {
			head = head.next;
			if (n % 2 == 0) {
				even.next = prev.next;
				even = even.next;
			} else {
				odd.next = even.next;
				prev = odd;
				odd = odd.next;
			}
		}
		odd.next = even;
		return head;
	}

}
