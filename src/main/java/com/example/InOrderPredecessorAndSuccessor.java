package com.example;

public class InOrderPredecessorAndSuccessor {

    public static void main(String[] args) {
        Node leftLeaf = new Node(10, null, null);
        Node rightLeaf = new Node(19, null, null);
        Node parentOfLeftLeaves = new Node(14, leftLeaf, rightLeaf);
        Node parentOfRightLeaves = new Node(35, new Node(31, null, null), new Node(42, null, null));

        Node root = new Node(27, parentOfLeftLeaves, parentOfRightLeaves);
        InOrderPredecessorAndSuccessor inOrderPredecessorAndSuccessor = new InOrderPredecessorAndSuccessor();
        Node searchResult = inOrderPredecessorAndSuccessor.search(35, root);
        if (searchResult != null) {
            System.out.print("Node found");
            System.out.println("Predecessor: " + inOrderPredecessorAndSuccessor.findRightMostChild(searchResult.getLeft()).getData());
            System.out.println("PostProcessor: " + inOrderPredecessorAndSuccessor.findLeftMostChild(searchResult.getRight()).getData());
        } else {
            System.out.print("Node not found :( ");
        }
    }

    private Node findRightMostChild(Node currentNode) {
        if (!currentNode.hasChildren()) {
            return currentNode;
        } else {
            return findRightMostChild(currentNode.getRight());
        }
    }

    private Node findLeftMostChild(Node currentNode) {
        if (!currentNode.hasChildren()) {
            return currentNode;
        } else {
            return findRightMostChild(currentNode.getRight());
        }
    }

    private Node search(int key, Node root) {
        if (root == null) {
            return root;
        }
        if (root.getData() == key) {
            return root;
        } else if (root.getData() > key) {
            return search(key, root.getLeft());
        } else if (root.getData() < key) {
            return search(key, root.getRight());
        }
        return null;
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
            return this.getLeft() != null || this.getRight() != null;
        }

    }

}


