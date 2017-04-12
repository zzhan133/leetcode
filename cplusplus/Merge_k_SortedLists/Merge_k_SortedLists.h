
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
	void pMinNode(vector<ListNode *> &lists, ListNode* &pNode){
		int iMinVal = INT_MAX;
		int iMinIndex = -1;
		for(unsigned uiIndex = 0; uiIndex < lists.size(); uiIndex++){
			if(lists[uiIndex] == NULL)
			{
				lists.erase(lists.begin() + uiIndex);
				pMinNode(lists, pNode);
				return;
			}
			if(iMinVal < lists[uiIndex]->val)
			{
				iMinVal = lists[uiIndex]->val;
				iMinIndex = uiIndex;
			}
		}
		if(iMinIndex == -1)
			return;
		pNode = lists[iMinIndex];
		lists[iMinIndex] = lists[iMinIndex]->next;
		return;
	}
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        //no new ListNode
		if(lists.size() == 0)
			return NULL;
		if(lists.size() == 1)
			return lists[0];
		ListNode *pResult = NULL;
		pMinNode(lists, pResult);
		ListNode *pNode = pResult;
		//find out the minimum val of those nodes
		do
		{
			pMinNode(lists, pNode->next);
			pNode = pNode->next;
		}while(pNode != NULL);
		return pResult;
		
    }
};
