package com.code.challenges.BinaryTree;

public class SwapTree {

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
        node = insertNode(node, 13);
        node = insertNode(node, 17);
        node = insertNode(node, 4);
        node = insertNode(node, 14);
        node = insertNode(node, 15);

        node = insertNode(node, 6);

        System.out.println("Read Three: ");
        readThree(node);

        System.out.println("\n After Deletion");
        node = delete(node, 5);
        readThree(node);

        node = swap(node);

        System.out.println("Read Inverted Three: ");
        readThree(node);
    }

    private static Node swap(Node node) {
        if(node == null) {
            return node;
        }

        Node leftNodeTemp = node.left;

        node.left = swap(node.right);
        node.right = swap(leftNodeTemp);

        return node;
    }

    private static Node delete(Node node, int value) {
        if(node == null)
            return node;

        // node is different
        if(value < node.key) {
            node.left = delete(node.left, value);
        } else if (value > node.key) {
            node.right = delete(node.right, value);
        }

        // node Key is equal
        else {
            //Node with one child or no children
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            }

            //Node with two children
            node.key = minValue(node);
            node.right = delete(node.right, node.key);
        }

        return node;
    }

    private static int minValue(Node node) {
        if(node.right == null)
            return node.key;

        return minValue(node.right);
    }

    private static Node insertNode(Node node, int value) {
        if(node == null) {
            return new Node(value);
        }

        if(value < node.key) {
            node.left = insertNode(node.left, value);
        } else if(value > node.key) {
            node.right = insertNode(node.right, value);
        }

        return node;
    }

    private static void readThree(Node node) {
        if(node == null)
            return;

        readThree(node.left);
        System.out.println(node.key);
        readThree(node.right);
    }

    //invert
    //readThree
    //insertNode
    //delete Node

}
