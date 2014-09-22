#include <string>

  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };

class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        if(k == 0 || head == NULL || head->next == NULL)
            return head;
        int iSize = 0;
        ListNode* pTmp = head;
        ListNode* pNewTail = head;
        while(pTmp->next != NULL)
        {
            iSize++;
            if(iSize >= k){
                pNewTail = pNewTail->next;
            }
            pTmp = pTmp->next;
        }
        if(iSize < k)
            return head;
        
        //cut from the middle
        ListNode *pResult = pNewTail->next;
        pNewTail->next = NULL;
        pTmp->next = head; 
        return pResult;
    }
};

