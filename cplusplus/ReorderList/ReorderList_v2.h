#include <new>

  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };

class Solution {
public:
	void func(ListNode*& pFront, ListNode* pBack, ListNode* flag){
		if(pBack->next->next != NULL){
			func(pFront, pBack->next, flag);
			if (pFront == flag)
			{
				return;
			}
		}

		pBack->next->next = pFront->next;
		pFront->next = pBack->next;
		pBack->next = NULL;
		pFront = pFront->next->next;
	}

    void reorderList(ListNode *head) {
        if(head == NULL || head->next == NULL || head->next->next == NULL)
            return;
        //find the flag for the last element
        ListNode* oneStep = head;
        ListNode* twoStep = head->next->next;
        
        while(twoStep != NULL){
            oneStep = oneStep->next;
            twoStep = twoStep->next;
            if(twoStep == NULL)
                break;
            twoStep = twoStep->next;
        }
        
        ListNode* flag = oneStep;
        
        //reorder
        ListNode* pRunner = head;
		ListNode* pTailer = flag;

		func(pRunner, pTailer, flag);
    }
};

