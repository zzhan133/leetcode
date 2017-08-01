package com.amazon.leetCode;

import java.util.ArrayList;
import java.util.List;

import com.mv.leetCode.TreeNode;

public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		List<TreeNode> bads = new ArrayList<TreeNode>();
		recover(root, null, null, bads);
		if(bads.size() == 4) {
			int tmp = bads.get(0).val;
			bads.get(0).val = bads.get(3).val;
			bads.get(3).val = tmp;
			return;
		} else {
			
		}
	}

	private void recover(TreeNode node, TreeNode left, TreeNode right, List<TreeNode> bads) {
		if (node == null)
			return;
		if (left != null && node.val < left.val) {
			int v = node.val;
			TreeNode tmpNode = node;
			while(tmpNode.right != null) {
				tmpNode = tmpNode.right;
				if(tmpNode.val < v) {
					int tmp = left.val;
					left.val = tmpNode.val;
					tmpNode.val = tmp;
					return;
				}
			}
			bads.add(left);
			bads.add(node);
			return;
		}
		if (right != null && node.val > right.val) {
			bads.add(node);
			bads.add(right);
			return;
		}

		recover(node.left, left, node, bads);
		recover(node.right, node, right, bads);
		return;

	}
}
