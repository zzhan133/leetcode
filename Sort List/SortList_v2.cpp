#include <vector>
#include <algorithm>
using namespace std;


  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
class Solution {
public:
    ListNode *sortList(ListNode *head) {
        //Merge sort
        if(head == NULL || head->next == NULL)
            return head;
        ListNode* pOne = head;
        ListNode* pTwo = head;
        while(pTwo != NULL){
            
            pTwo = pTwo->next;
            if(pTwo->next == NULL){
                break;
            }
            pTwo = pTwo->next;
            pOne = pOne->next;
        }
        ListNode* pTmp = pOne->next;
        pOne->next = NULL;
        
        ListNode* pFirst = sortList(head);
        ListNode* pSecond = sortList(pTmp);
        
        //combine these two part
        ListNode* pResult = NULL;
        while(pFirst && pSecond){
            if(pFirst->val < pSecond->val){
                
                if(pResult == NULL){
                    pResult = pFirst;
                }
                else
                    pResult->next = pFirst;
                pFirst = pFirst->next;
            }
            else{
                if(pResult == NULL){
                    pResult = pSecond;
                }
                else
                    pResult->next = pSecond;
                pSecond = pSecond->next;
            }
        }
        
        if(pFirst){
            pResult->next = pFirst;
            return pResult;
        }
        if(pSecond){
            pResult->next = pSecond;
            return pResult;
        }
        return pResult;
    }
};


int main()
{
	ListNode *a = new ListNode(3);
	ListNode *b = new ListNode(2);
	ListNode *c = new ListNode(4);
	a->next = b;
	b->next = c;
	Solution instance;
	ListNode* pResult = instance.sortList(a);
	return 0;
}

/* 
 *
 * //1.empty list
        
	ListNode* start_point = head;

	for(;start_point != NULL; start_point = start_point->next)
	{
		ListNode* runner = start_point;
		ListNode* runner_next = runner->next;
		while(runner_next != NULL){
			if(runner->val > runner_next->val)
			{
				//swap the value
				int tmp = runner_next->val;
				runner_next->val = runner->val;
				runner->val = tmp;
			}
			runner = runner_next;
			runner_next = runner->next;
		}

	}
*/
