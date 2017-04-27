package com.mv.leetCode;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        getInvalidNode(root, null, null);
    }
    
    private TreeNode getInvalidNode(TreeNode root, TreeNode min, TreeNode max) {
    	if(root == null){
    		return null;
    	}
    	if(min != null) {
    		if(root.val <= min.val) return root;
    	}
    	if(max != null) {
    		if(root.val >= max.val) return root;
    	}
    	
    	TreeNode leftSide = getInvalidNode(root.left, min, root);
    	TreeNode rightSide = getInvalidNode(root.right, root, max);
    	if(leftSide != null && rightSide != null) {
    		int tmp = leftSide.val;
    		leftSide.val = rightSide.val;
    		rightSide.val = tmp;
    		return null;
    		
    	}
    	else if(leftSide != null) return leftSide;
    	else if(rightSide != null) return rightSide;
    	else return null;
    }

}
