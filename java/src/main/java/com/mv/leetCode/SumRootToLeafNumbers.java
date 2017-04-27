package com.mv.leetCode;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		return sumNumbersWithParent(root, 0);
	}

	private int sumNumbersWithParent(TreeNode node, int prev) {
		if (node == null) {
			return 0;
		}
		int sum = prev * 10 + node.val;
		if (node.left == null && node.right == null) {
			return sum;
		}
		return sumNumbersWithParent(node.left, sum) + sumNumbersWithParent(node.right, sum); 
	}

}
