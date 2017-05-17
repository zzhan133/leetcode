package com.mv.leetCode;

public class ReverseLinkedListTwo {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fixedPrev = null;
        ListNode prevNext = head;
        for (int i = 1; i < m; i++) {
            fixedPrev = prevNext;
            prevNext = prevNext.next;
        }
        
        ListNode prev = prevNext;
        ListNode cur = prev.next;
        ListNode fixedNext = head;
        ListNode nextPrev = null;
        for(int i = 0; i < n; i++) {
        	nextPrev = fixedNext;
            fixedNext = fixedNext.next;
        }
        
        fixedPrev.next = nextPrev;
        prevNext.next = fixedNext;
        nextPrev.next = null;
        
        while(cur != null) {
        	ListNode nextOne = cur.next;
        	cur.next = prev;
        	prev = cur;
        	cur = nextOne;
        }
        
        return head;
    }
}
