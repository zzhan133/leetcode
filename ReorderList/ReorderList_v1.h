#include <new>

  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };

class Solution {
public:
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
        while(pRunner != flag){
            ListNode* pLast = pRunner;


            while(pLast->next->next != NULL){
                pLast = pLast->next;
            }
            pLast->next->next = pRunner->next;
            pRunner->next = pLast->next;
            pLast->next = NULL;
            pRunner = pRunner->next->next;
        }
    }
};

