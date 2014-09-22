
// * Definition for singly-linked list.
//
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;
  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
class Solution {
public:
	//0 represents correct; 1 represent finished
	ListNode* mergeTwoLists(ListNode* &pFirst, ListNode* &pSecond){
		if(pFirst == NULL)
			return pSecond;
		if(pSecond == NULL)
			return pFirst;
		ListNode* pResult;
		if(pFirst->val <= pSecond->val){
		    pResult = pFirst;
		    pFirst = pFirst->next;
		}
		else{
		    pResult = pSecond;
		    pSecond = pSecond->next;
		}
		
		ListNode* pTmp = pResult;
		
		while(pFirst != NULL && pSecond != NULL){
			if(pFirst->val <= pSecond->val){
				pTmp->next = pFirst;
				pTmp = pTmp->next;
				pFirst = pFirst->next;
			}
			else{
				pTmp->next = pSecond;
				pTmp = pTmp->next;
				pSecond = pSecond->next;
			}

		}
		if(pFirst == NULL){
			pTmp->next = pSecond;
			return pResult;
		}
		if(pSecond == NULL){
			pTmp->next = pFirst;
			return pResult;
		}
	}
	void merge(vector<ListNode *> &lists, unsigned iBegin, unsigned iEnd){
		if (iBegin == iEnd)
		{
			return;
		}
		if(iBegin + 1 ==  iEnd){
			ListNode* tmp = mergeTwoLists(lists[iBegin], lists[iEnd]);
			lists.erase(lists.begin()+iBegin, lists.begin()+iEnd);
			lists.insert(lists.begin()+iBegin,tmp);
			return;
		}
		unsigned middle = (iBegin + iEnd)/2;
		merge(lists, iBegin, middle);
		merge(lists, iBegin+1, iBegin+(iEnd-middle));
		ListNode* tmp = mergeTwoLists(lists[iBegin], lists[iBegin+1]);
		lists.erase(lists.begin()+iBegin, lists.begin()+iBegin+1);
		lists.insert(lists.begin()+iBegin,tmp);
		return;

	}
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        //no new ListNode
		if(lists.size() == 0)
			return NULL;
		if(lists.size() == 1)
			return lists[0];

		merge(lists, 0, lists.size() - 1);
		return lists[0];
    }
};


