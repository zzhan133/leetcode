package com.amazon.leetCode;

import com.mv.leetCode.TreeNode;

public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		recover(root, null, null);
	}

	private TreeNode recover(TreeNode node, TreeNode left, TreeNode right) {
		if(node == null) return null;
		if (left == null) {
			if (right != null && node.val > right.val) {
				return node;
			}
		}
		if(right == null) {
			if(left != null && node.val < left.val){
				return node;
			}
		}
		
		if(left != null && node.val < left.val) {
			return node;
		}
		if(right != null && node.val > right.val) {
			return node;
		}
		
		TreeNode leftV = recover(node.left, left, node);
		TreeNode rightV = recover(node.right, node, right);
		if(leftV != null && rightV != null) {
			switchValue(leftV, rightV);
		} else if (leftV == null && rightV != null) {
			switchValue(node, rightV);
		} else if(leftV != null && rightV == null) {
			switchValue(leftV, node);
		}
		return null;
		
	}

	private void switchValue(TreeNode leftV, TreeNode rightV) {
		int tmp = leftV.val;
		leftV.val = rightV.val;
		rightV.val = tmp;
	}

}
