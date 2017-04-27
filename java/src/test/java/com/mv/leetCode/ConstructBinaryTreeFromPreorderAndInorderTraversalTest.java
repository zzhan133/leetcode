package com.mv.leetCode;

import org.junit.Test;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

	private ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
	
	@Test
	public void testBuildTree() throws Exception {
		int[] preorder = {1, 2, 3};
		for (int i : preorder) {
			System.out.println(i);
		}
		int[] inorder = {3, 2, 1};
		TreeNode root = obj.buildTree(preorder, inorder);
		
	}

}
