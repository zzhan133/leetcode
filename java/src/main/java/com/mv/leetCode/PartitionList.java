package com.mv.leetCode;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode biggerPrev = dummy;

		while (biggerPrev.next != null) {
			if (biggerPrev.next.val >= x) {
				break;
			}
			biggerPrev = biggerPrev.next;
		}
		if(biggerPrev.next == null) return head;
		
		ListNode lessPrev = biggerPrev.next;
		while (lessPrev.next != null) {
			if (lessPrev.next.val < x) {
				ListNode tmp = biggerPrev.next;
				biggerPrev.next = lessPrev.next;
				lessPrev.next = lessPrev.next.next;
				lessPrev.next = tmp;
				biggerPrev = biggerPrev.next;
			}
			lessPrev = lessPrev.next;
		}
		return head;
	}
}
