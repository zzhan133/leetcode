package com.mv.leetCode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	   public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if(preorder == null || preorder.length == 0) return null;
	        return cons(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	    }
	    
	    private TreeNode cons(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
	        if(preBegin == preorder.length || preBegin > preEnd) return null;
	        if(preBegin == preEnd) return new TreeNode(preorder[preBegin]);
	        int nodeV = preorder[preBegin];
	        TreeNode node = new TreeNode(nodeV);
	        int low = inBegin; 
	        int high = inEnd;
	        int posInorder = -1;
	        while(true) {
	            posInorder = (low + high) / 2;
	            if(inorder[posInorder] == nodeV) break;
	            else if(inorder[posInorder] < nodeV) low = posInorder + 1;
	            else high = posInorder - 1;
	        }
	        int dist = posInorder - inBegin;
	        node.left = cons(preorder, preBegin + 1, preBegin + posInorder - inBegin , inorder, inBegin, posInorder - 1);
	        node.right = cons(preorder, preBegin + posInorder - inBegin + 1, preEnd, inorder, posInorder + 1 , inEnd);
	        return node;
	    }

}
