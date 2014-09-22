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
    
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        if(head == NULL || m >= n || m < 1)
            return head;
        
	unsigned i = 1;
	ListNode *node = head;
       while( i < m && node){
	       node = node->next;
	       i++;
       }	     
	if(node == NULL){
		return head;
	}
       
       int elemNum = (n - m + 1)/2;
     stack<ListNode *> pStack;
       while(pStack.size() != elemNum && node){
	       pStack.push(node);
	       node = node->next;
       }

       if(node == NULL){
		return head;
	}

       queue<ListNode *> pQueue;

       if( (n-m+1)%2 ){
       		node = node->next;
       }
       
       if(node == NULL){
		return head;
	}

       while(pQueue.size() != elemNum && node){
	       pQueue.push(node);
	       node = node->next;
       }

       if(node == NULL){
		return head;
	}

       while(!pQueue.empty()){
		swap(pQueue.front()->val, pStack.top()->val);
		pStack.pop();
		pQueue.pop();
       }
        
        return head;
    }
};

