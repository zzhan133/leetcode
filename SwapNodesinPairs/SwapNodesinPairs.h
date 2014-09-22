
  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(0) {}
  };
 
class Solution {
public:
    void swapPointers(ListNode* &first, ListNode* &second,ListNode* &head){
        head->next = second;
        first->next = second->next;
        second->next = first;
    }
    ListNode *swapPairs(ListNode *head) {
        ListNode *reslt = head;
        if(head == 0 || head->next == 0){
            return head;
        }
        ListNode *r1 = head;
        ListNode *r2 = head->next;
        ListNode *h = head;
        reslt = head->next;
        while(r1 != 0 && r2 != 0){
            swapPointers(r1, r2, h);
            h = r1;
            r1 = r1->next;
			if (r1 == 0)
				break;
            r2 = r1->next; 
        }
        return reslt;
    }
};

