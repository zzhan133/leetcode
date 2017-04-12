package com.mv.leetCode;

import org.junit.Test;

public class AddTwoNumbersTest {
	@Test
	public void testAddTwoNumbers() throws Exception {
		ListNode l1 = new ListNode(4);
		ListNode l11 = new ListNode(4);
		l1.next = l11;
		ListNode l12 = new ListNode(3);
		l11.next = l12;
		ListNode l2 = new ListNode(5);
		ListNode l21 = new ListNode(6);
		l2.next = l21;
		ListNode l22 = new ListNode(6);
		l21.next = l22;

		AddTwoNumbers obj = new AddTwoNumbers();
		obj.addTwoNumbers(l1, l2).print();
		
	}

}
