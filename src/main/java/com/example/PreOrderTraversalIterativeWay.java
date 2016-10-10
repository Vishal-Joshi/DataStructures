package com.example;

import java.util.Stack;

public class PreOrderTraversalIterativeWay {

    public static void main(String[] args) {
        Node leftLeaf = new Node(1, null, null);
        Node rightLeaf = new Node(4, null, null);
        Node leftLeafOfSecondNode = new Node(6, null, null);
        Node parentOfLeftLeaves = new Node(5, leftLeaf, rightLeaf);
        Node parentOfRightLeaves = new Node(2, leftLeafOfSecondNode, null);

        Node root = new Node(3, parentOfLeftLeaves, parentOfRightLeaves);
        PreOrderTraversalIterativeWay preOrderTraversalRecursiveWay = new PreOrderTraversalIterativeWay();
        preOrderTraversalRecursiveWay.preorderTraversal(root);
    }

    private void preorderTraversal(Node currentNode) {
        Stack<Node> stack = new Stack();
        while (currentNode != null) {
            if (currentNode.getRight() != null) {
                stack.push(currentNode.getRight());
            }
            System.out.print(currentNode.data);
            if (currentNode.getLeft() != null) {
                currentNode = currentNode.getLeft();
            } else if (!stack.empty()) {
                currentNode = stack.pop();
            } else {
                currentNode = null;
            }
        }
    }


    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public boolean hasChildren() {
            return this.getLeft() == null && this.getRight() == null;
        }

    }
}


