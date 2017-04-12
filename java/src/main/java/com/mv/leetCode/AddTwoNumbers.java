package com.mv.leetCode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 =  reverseListNode(l1);
		l2 = reverseListNode(l2);
		return reverseListNode(addByNormalOrder(l1, l2));
	}
	
	private ListNode addByNormalOrder(ListNode l1, ListNode l2) {
		int isAdd = 0;
		ListNode tail = null;
		ListNode head = null;
		while(l1 != null || l2 != null) {
			int l1Val = l1 == null ? 0 : l1.val;
			int l2Val = l2 == null ? 0 : l2.val;
			int resultItem = l1Val + l2Val + isAdd;
			if(resultItem >= 10) {
				resultItem = resultItem % 10;
				isAdd = 1;
			} else {
				isAdd = 0;
			}
			if(head == null) {
				head = new ListNode(resultItem);
				tail = head;
			} else {
				tail.next = new ListNode(resultItem);
				tail = tail.next;
			}
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
			
		}
		if(isAdd == 1) {
			tail.next = new ListNode(1);
		}
		return head;
	}

	private ListNode reverseListNode(ListNode listNode) {
		ListNode previous = null;
		ListNode current = listNode;
		ListNode next = listNode.next;
		current.next = previous;

		while (next != null) {
			previous = current;
			current = next;
			next = next.next;
			current.next = previous;
		}
		return current;
	}

}
