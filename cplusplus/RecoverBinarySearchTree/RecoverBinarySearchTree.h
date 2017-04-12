/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
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
	 TreeNode *findNode(TreeNode* node, int first, int second){  //first is the mistake val, second is the true val
		if (node->val == first)
		{
			return node;  //The position should be second
		}
		if (node->val < second)
		{
			return findNode(node->right, first, second);
		} 
		else if(node->val > second)
		{
			return findNode(node->left, first, second);
		}
		else //node->val == second  //the position first should be///first > second
		{
			if (first > second)  //first > second; second should be the right
								//we need to find the first val position (2), and it should be the second that should be (3)
			{
				return findNode(node->left, first, second);
			}
			else  //first < second 
			{
				return findNode(node->right, first, second);
			}
		}
	 }

	

	 void findFirstElem(TreeNode *node, int& prevElem, vector<int> &map){
		 if(node == NULL || map.size() != 0){
			 return;
		 }

		 //process left node
		 findFirstElem(node->left,prevElem, map);
		 if(map.size() == 1)
			 return;


		 if(node->val > prevElem)
		 {
			 prevElem = node->val;
		 }
		 else{  //node->val < prevElem
			 map.push_back(prevElem);
			 return;
		 }

		 findFirstElem(node->right, prevElem, map);
		 if(map.size() == 1)
			 return;


	 }

	 void findSecondNode(TreeNode *node, int& nextElem, vector<int> &map){
		 if(node == NULL || map.size() == 2)
		 {
			 return;
		 }

		 findSecondNode(node->right, nextElem, map);
		 if(map.size() == 2)
			 return;

		 if(node->val < nextElem)
		 {
			 nextElem = node->val;
		 }
		 else{
			 map.push_back(nextElem);
			 return;
		 }

		 findSecondNode(node->left, nextElem, map);
		 if(map.size() == 2)
			 return;
	 }


	 void recoverTree(TreeNode *root) {
		 vector<int> map;
		 //from left to right to find the first element
		 int prevElem = INT_MIN;
		 findFirstElem(root, prevElem, map);
		 //from right to left to find the second element
		 int nextElem = INT_MAX;
		 findSecondNode(root, nextElem, map);
		 TreeNode* f = findNode(root, map[0], map[1]);
		 TreeNode* s = findNode(root, map[1], map[0]);
		 swap(f->val, s->val);
		 return;
	 }
 };
