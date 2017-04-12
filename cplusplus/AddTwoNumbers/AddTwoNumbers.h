struct ListNode{
	int val;
	ListNode* next;
	ListNode(int a):val(a), next(0){}
};
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        if(l1 == 0)
            return l2;
        if(l2 == 0)
            return l1;
	ListNode *reslt = new ListNode(l1->val+l2->val);
	l1 = l1->next;
	l2 = l2->next;
	ListNode *head = reslt;
        //using l1 to store the result
        while(l1 != 0 && l2 != 0)
        {
	    reslt->next = new ListNode(l1->val + l2->val);
	    reslt = reslt->next;

            l1 = l1->next;
            l2 = l2->next;
        }
	while(l1 != 0){
		reslt->next = new ListNode(l1->val);
		reslt = reslt->next;
		l1 = l1->next;
	}

	while(l2 != 0){
		reslt->next = new ListNode(l2->val);
		reslt = reslt->next;
		l2 = l2->next;
	}

	int carrier = 0;
	reslt = head;
	do{
		int tmp = carrier + reslt->val;
		if(tmp < 10)
		{
			carrier = 0;
			reslt->val = tmp;
		}
		else{
			reslt->val = tmp - 10;
			carrier = 1;
		}
		if (reslt->next == 0)
			break;
		else
			reslt = reslt->next;
	} while (true);
	if(carrier == 1)
		reslt->next = new ListNode(1);
	return head;

    }
};



