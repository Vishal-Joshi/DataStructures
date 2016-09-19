package com.example;

public class FindingFromBinarySearchTree {

    public static void main(String[] args) {
        Node leftLeaf = new Node(10, null, null);
        Node rightLeaf = new Node(19, null, null);
        Node parentOfLeftLeaves = new Node(14, leftLeaf, rightLeaf);
        Node parentOfRightLeaves = new Node(35, new Node(31, null, null), new Node(42, null, null));

        Node root = new Node(27, parentOfLeftLeaves, parentOfRightLeaves);
        FindingFromBinarySearchTree findingFromBinarySearchTree = new FindingFromBinarySearchTree();


        Node foundNode = findingFromBinarySearchTree.findNode(89, root);
        if (foundNode == null) {
            System.out.print("Sorry, the key is not available!");
        } else {
            System.out.println("Node found!");
        }
    }

    private Node findNode(int data, Node currentNode) {
        if (currentNode == null) {
            return null;
        } else {
            if (data == currentNode.getData()) {
                return currentNode;
            }

            if (data < currentNode.getData()) {
                return findNode(data, currentNode.getLeft());
            } else if (data > currentNode.getData()) {
                return findNode(data, currentNode.getRight());
            }

        }
        return null;
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
