package com.example;

public class PreOrderTraversalRecursiveWay {

    public static void main(String[] args) {
        Node leftLeaf = new Node(1, null, null);
        Node rightLeaf = new Node(4, null, null);
        Node leftLeafOfSecondNode = new Node(6, null, null);
        Node parentOfLeftLeaves = new Node(5, leftLeaf, rightLeaf);
        Node parentOfRightLeaves = new Node(2, leftLeafOfSecondNode, null);

        Node root = new Node(3, parentOfLeftLeaves, parentOfRightLeaves);
        PreOrderTraversalRecursiveWay preOrderTraversalRecursiveWay = new PreOrderTraversalRecursiveWay();
        preOrderTraversalRecursiveWay.preorderTraversal(root);
    }

    private void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.getLeft());
        preorderTraversal(root.getRight());
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
