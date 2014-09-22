/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int digits(int num)
    {
        if(num == 0)
            return 1;
        int iN = 0;
        while(num != 0){
            iN++;
            num = num/10;
        }
        return iN;
    }
    int iWithRoot(int irootVal, int iN){
        while(iN != 0)
        {
            irootVal *= 10;
            iN--;
        }
        return irootVal;
    }
    int sumNumbers(TreeNode *root) {
        if(root == NULL)
            return 0;
        if(root->left == NULL && root->right == NULL)
        {
            return root->val;
        }
        int iLeft = 0;
        int iRight = 0;
        if(root->left != NULL){
            int Left = sumNumbers(root->left);
            iLeft = iWithRoot(root->val, digits(Left)) + Left;
        }
        if(root->right != NULL){
            int Right = sumNumbers(root->right);
            iRight = iWithRoot(root->val, digits(Right)) + Right;
        
        }
        return iLeft + iRight;
    }
};

