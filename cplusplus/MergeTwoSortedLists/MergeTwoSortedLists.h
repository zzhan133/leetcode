/**
 * Definition for singly-linked list. */
  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(0) {}
  };
 
class Solution {
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        if(l1 == 0)
            return l2;
        if(l2== 0)
            return l1;
        //append l2 to l1
        ListNode *node1 = l1;
        ListNode *runner1 = l1->next;
        ListNode *node2 = l2;
        //make sure node2->val is between node1->val and runner->val
        if(node2 != nullptr && node2->val <= node1->val)
        {
            ListNode *tmp = node2->next;
            node2->next = node1;
            runner1 = node1;
            
            node1 = node2;
            l1 = node1;
            node2 = tmp;
        }
        if(node2 == nullptr)
            return l2;
        //from now node1->val < node2->val
        while(runner1 != 0 && node2 != 0)
        {
            while(runner1 != nullptr && runner1->val < node2->val)
            {
                node1 = runner1;
                runner1 = runner1->next;
            }
            if(runner1 == nullptr)
            {
                node1->next = node2;
                return l1;
            }
            else//node2->val is between node1->val and runner->val
            {
                ListNode *tmp = node2->next;
                node1->next = node2;
                node2->next = runner1;
				node1 = node1->next;
                node2 = tmp;
            }
        }
        if(node2 == 0)
            return l1;
        if(runner1 == nullptr)
        {
            node1->next = node2;
            return l1;
        }
        return l1;
    }
};

