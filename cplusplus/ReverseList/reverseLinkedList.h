/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *swapPairs(ListNode *head) {
	    if(head == 0)
		    return 0;
       ListNode *pHavereversed = 0;
       ListNode *pNeedReverse = 0;
        while(head){
		pNeedReverse = head->next;
		head->next = pHavereversed;
		pHavereversed = head;
		head = pNeedReverse;
	}
	return pHavereversed;
    }
};

