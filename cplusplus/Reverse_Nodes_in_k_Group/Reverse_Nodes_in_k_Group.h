class Solution {
public:
	ListNode *reverseK(ListNode *node, int k){

		int i = 1;
		
		ListNode *first = node;
		ListNode *last = node;
		
		while( i < k && last->next){
			ListNode *tmp = last->next;
			last->next = tmp->next;
			tmp->next = first;
			first = tmp;
			i++;
		}
			
		return first;
		
	}

	//get the last element of a group
	ListNode *nextStep(ListNode *node, int k){
		
		int i = 1;
		while(i < k && node){
			node = node->next;
			i++;
		}
		return node;
		
	}


    ListNode *reverseKGroup(ListNode *head, int k) {
 	if(k<=1){
		return head;
	}	

	ListNode *nextNode = nextStep(head,k);
	if(nextNode == NULL)
		return head;
	
	ListNode *newHead = reverseK(head, k);
	nextNode = nextStep(newHead,k);

	while(nextNode->next){
		ListNode *lastPreNode = nextNode;
		nextNode = nextStep(lastPreNode->next,k);
		if(nextNode == NULL)
			return newHead;
		lastPreNode->next = reverseK(lastPreNode->next, k);
		nextNode = nextStep(lastPreNode->next,k);

	}

	return newHead;
    }
};
