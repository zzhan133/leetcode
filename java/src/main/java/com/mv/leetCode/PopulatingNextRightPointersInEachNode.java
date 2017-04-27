package com.mv.leetCode;

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode parent = root;
        TreeLinkNode mostLeftChild = root.left;
        while(mostLeftChild != null) {
            while(parent != null) {
                parent.left.next = parent.right;
                parent.right.next = parent.next != null ? parent.next.left : null;
                parent = parent.next;
            }
            parent = mostLeftChild;
            mostLeftChild = parent.left;
        }
    }

}
