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
	if(head == NULL)
		return NULL;
	//2.list has only one element
	if(head->next == NULL)
		return NULL;
	ListNode* tmp = head;
	vector<int> arr;
	while(tmp != NULL)
	{
		arr.push_back(tmp->val);
		tmp = tmp->next;
	}
	sort(arr.begin(), arr.end());
	tmp = head;
	for(unsigned i = 0; i< arr.size(); i++)
	{
		tmp->val = arr[i];
		tmp = tmp->next;
	}
	return head;

    }
};

int main()
{
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
