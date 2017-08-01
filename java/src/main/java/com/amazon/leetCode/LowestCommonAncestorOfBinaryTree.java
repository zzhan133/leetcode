package com.amazon.leetCode;

import com.mv.leetCode.TreeNode;

public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) {
        	return root;
        } else {
            TreeNode leftF = lowestCommonAncestor(root.left, p, q);
            TreeNode rightF = lowestCommonAncestor(root.right, p, q);
            if(leftF == null) return rightF;
            if(rightF == null) return leftF;
            return root;
        }
    }

}
