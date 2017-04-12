package com.mv.leetCode;

public class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public void print () {
		ListNode node = this;
		while(node != null) {
			System.out.print(node.val + ", ");
			node = node.next;
		}
		System.out.println();
	}
}
