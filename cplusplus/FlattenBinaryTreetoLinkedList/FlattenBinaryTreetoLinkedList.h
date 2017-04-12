
 // Definition for binary tree
#include <new>
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
public:
    void flatten(TreeNode *root) {
		if(root == NULL)
			return;
		if(root->left == NULL && root->right == NULL){
			return;
		}

		TreeNode* pLeft = root->left;

		TreeNode* pRight = root->right;

		if(pLeft)
			flatten(pLeft);
		if(pRight)
			flatten(pRight);

		if(pLeft){
			root->left = NULL;
			root->right = pLeft;
		}

		if(pRight){
			if(pLeft == NULL){
				root->right = pRight;
			}
			else{
				TreeNode *pTmp = pLeft;
				while(pTmp->right != NULL){
					pTmp = pTmp->right;
				}
				pTmp->right = pRight;
			}
			
		}
    }
};

