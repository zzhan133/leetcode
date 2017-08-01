package com.amazon.leetCode;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mv.leetCode.TreeNode;

public class LowestCommonAncestorOfBinaryTreeTest {
	
	private LowestCommonAncestorOfBinaryTree obj = new LowestCommonAncestorOfBinaryTree();

	@Test
	public void testLowestCommonAncestor() throws Exception {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		TreeNode ans = obj.lowestCommonAncestor(node1, node3, node4);
		assertEquals(1, ans.val);
		
	}

}
