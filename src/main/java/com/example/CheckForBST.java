package com.example;

public class CheckForBST {

    public static void main(String[] args) {
        Node leftLeaf = new Node(100, null, null);
        Node rightLeaf = new Node(19, null, null);
        Node parentOfLeftLeaves = new Node(14, leftLeaf, rightLeaf);
        Node parentOfRightLeaves = new Node(35, new Node(31, null, null), new Node(42, null, null));

        Node root = new Node(27, parentOfLeftLeaves, parentOfRightLeaves);
        CheckForBST checkForBST = new CheckForBST();
        System.out.print(checkForBST.isBst(root));

    }

    private boolean isBst(Node node) {
        return node == null || checkForBst(node) && isBst(node.getLeft()) && isBst(node.getRight());
    }

    private boolean checkForBst(Node node) {
        boolean isBst = true;
        if (node.getLeft() != null) {
            isBst = (node.getLeft().getData() < node.getData());
        }

        if (node.getRight() != null) {
            isBst = isBst && (node.getRight().getData() > node.getData());
        }

        return isBst;
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
