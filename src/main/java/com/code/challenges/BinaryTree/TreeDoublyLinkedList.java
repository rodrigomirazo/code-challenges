package com.code.challenges.BinaryTree;

import org.w3c.dom.Node;

public class TreeDoublyLinkedList {

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int item) {
            val = item;
            left = right = null;
        }
    }

    static TreeNode rootTree = null;

    static void main() {

        rootTree = appendTree(rootTree, 1);
        rootTree = appendTree(rootTree, 2);
        rootTree = appendTree(rootTree, 3);
        rootTree = appendTree(rootTree, 4);
        rootTree = appendTree(rootTree, 5);

        postOrderRecur(rootTree);
    }



    private static TreeNode appendTree(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        if(root.val < val) {
            appendTree(root.left, val);
        } else if(root.val > val) {
            appendTree(root.right, val);
        }
        return root;
    }

    private static void postOrderRecur(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        postOrderRecur(treeNode.left);
        System.out.print(treeNode.val + ",");
        postOrderRecur(treeNode.right);
    }
}
