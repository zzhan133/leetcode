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
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
	if(l1 == NULL)
		return l2;
	if(l2 == NULL)
		return l1;
 	ListNode *head = l1;

 	while(l1->next && l2->next){
		l1->val += l2->val;
		l1 = l1->next;
		l2 = l2->next;
	}
	// l1->next == NULL && l2->next == NULL
	// l1->next == NULL && l2->next
	// l1->next && l2->next == NULL
	l1->val += l2->val;
	if(l1->next == NULL)
		l1->next = l2->next;

	int adder = 0;
	ListNode *tmp = head;
	while(head){
		if(head->val + adder > 9){
			head->val = head->val + adder - 10;
			adder = 1;
		}
		else{
			head->val += adder;
			adder = 0;
		}
		head = head->next;
	}
	return tmp;
		
    }
};
