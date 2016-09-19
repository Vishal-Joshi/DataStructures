package com.example;

public class InsertNodeInBST {

    public static void main(String[] args) {
        Node leftLeaf = new Node(-4, null, null);
        Node rightLeaf = new Node(3, null, new Node(8, null, null));
        Node parentOfLeftLeaves = new Node(2, leftLeaf, rightLeaf);
        Node parentOfRightLeaves = new Node(18, null, null);

        Node root = new Node(5, parentOfLeftLeaves, parentOfRightLeaves);
        InsertNodeInBST insertNodeInBST = new InsertNodeInBST();
        insertNodeInBST.insert(new Node(4, null, null), root);
        System.out.print(root);

    }

    private Node insert(Node newNodeToInsert, Node rootNode) {
        if (rootNode == null) {
            return newNodeToInsert;
        } else {
            return fineChildPlace(newNodeToInsert, rootNode);
        }
    }

    private Node fineChildPlace(Node nodeToPlace, Node currentNode) {
        //terminating condition
        if (currentNode.getLeft() == null && nodeToPlace.getData() < currentNode.getData()) {
            currentNode.setLeft(nodeToPlace);
            return null;
        } else if (currentNode.getRight() == null && nodeToPlace.getData() > currentNode.getData()) {
            currentNode.setRight(nodeToPlace);
            return null;
        }
        if (nodeToPlace.getData() < currentNode.getData()) {
            //goto left
            return fineChildPlace(nodeToPlace, currentNode.getLeft());
        } else {
            //goto right
            return fineChildPlace(nodeToPlace, currentNode.getRight());
        }
    }

    static class Node {
        private int data;
        private Node left;
        private Node right;

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        Node(int data, Node left, Node right) {
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
    }
}
