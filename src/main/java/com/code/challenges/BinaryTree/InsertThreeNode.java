package com.code.challenges.BinaryTree;

public class InsertThreeNode {

    private static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    private static Node node;

    static void main() {
        node = new Node(1);
        node = insertNode(node, 2);
        node = insertNode(node, 5);
        node = insertNode(node, 7);
        node = insertNode(node, 4);
        node = insertNode(node, 3);
        node = insertNode(node, 6);

        System.out.println("Read Three: ");
        readThree(node);
    }

    private static void readThree(Node node) {
        if(node == null) {
            return;
        }

        readThree(node.left);
        System.out.println(node.key + ", ");
        readThree(node.right);

    }

    private static Node insertNode(Node node, int key) {

        if(node == null) {
            return new Node(key);
        }
        if(key < node.key) {
            node.left = insertNode(node.left, key);
        } else if(key > node.key) {
            node.right = insertNode(node.right, key);
        }

        return node;
    }
}
