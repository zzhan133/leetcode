#pragma once
#include <vector>

using namespace std;
  
//Definition for binary tree
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
public:
    void findSum(TreeNode *node, int sum, vector<int> store_vector, vector<vector<int> > &reslt)
    {
        if(node == nullptr)
            return;
        if(node->val == sum && node->left == nullptr && node->right == nullptr)  //leaf
        {
            store_vector.push_back(node->val);
            reslt.push_back(store_vector);
            return;
        }
        
        if(node->val != sum && node->left == nullptr && node->right == nullptr)
        {
            return;
        }
        //here represents node is not a leaf;
        store_vector.push_back(node->val);
        int next_sum = sum-node->val;
        findSum(node->left,next_sum, store_vector, reslt);
        findSum(node->right, next_sum, store_vector, reslt);
    }
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        vector<vector<int> > reslt;
        if(nullptr == root)
            return reslt;
        vector<int> tmp;
        findSum(root, sum, tmp, reslt);
        return reslt;
    }
};

