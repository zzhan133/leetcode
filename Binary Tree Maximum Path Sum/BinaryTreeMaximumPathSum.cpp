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
	void sumPath(int& sum, TreeNode *node)
    {
        if(node == nullptr)
		return;
	if(node->val >= 0)
	{
		sum = sum+node->val;
		sumPath(sum, node->left);
		sumPath(sum, node->righ);
	}
	if(node->val < 0)
	{
		int max = maxPathSum(node);
	}
        
    }
    int maxPathSum(TreeNode *root) {
        int maxSum = -2147483648;
        if(root == nullptr)
            return maxSum;
        else if(root->val < 0)
        {
		maxSum = root->val;
		int left_val = maxPathSum(root->left);
		int right_val = maxPathSum(root->right);
            	int tmp = std::max(maxPathSum(root->left), maxPathSum(root->right));
	    	return std::max(maxSum, tmp);
        }
        else
        {
            int sum = root->val;
		sumPath(sum, root->left);
	    {
		sumPath(sum, root->right);
	    }
		
	    	    
            if(root->right)
            sumPath(sum, root->right);
	    return sum;

        }
    }
};
	    /*  int left_val = 0;
	    int right_val = 0;
	    TreeNode* neg_left = nullptr;
	    TreeNode* neg_right = nullptr;


	    if(neg_left != nullptr)
		    left_val = maxPathSum(neg_left);
	    if(neg_right != nullptr)
		    right_val = maxPathSum(neg_right);
            if(maxSum < sum)
                swap(maxSum, sum);
	    if(maxSum < left_val)
		swap(maxSum, left_val);
	    if(maxSum < right_val)
		    swap(maxSum, right_val);
	    return maxSum; */ 
