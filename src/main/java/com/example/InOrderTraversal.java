package com.example;

import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {
        Node leftLeaf = new Node(10, null, null);
        Node rightLeaf = new Node(19, null, null);
        Node parentOfLeftLeaves = new Node(14, leftLeaf, rightLeaf);
        Node parentOfRightLeaves = new Node(35, new Node(31, null, null), new Node(42, null, null));

        Node root = new Node(27, parentOfLeftLeaves, parentOfRightLeaves);
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.inorderPrint(root);

    }

    public void inorderPrint(Node root) {
        if (root == null)
            return;

        Stack<Node> s = new Stack<>();

        Node currentNode = root;

        while (!s.empty() || currentNode != null) {

            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                Node n = s.pop();
                System.out.printf("%d ", n.data);
                currentNode = n.right;
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
