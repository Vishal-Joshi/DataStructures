package com.example;

import java.util.*;

public class PrintBinaryTreeInVeritcalOrder {

    public static void main(String[] args) {
        Node leftLeaf = new Node(10, null, null);
        Node rightLeaf = new Node(19, null, null);
        Node parentOfLeftLeaves = new Node(14, leftLeaf, rightLeaf);
        Node parentOfRightLeaves = new Node(35, new Node(31, null, null), new Node(42, null, null));

        Node root = new Node(27, parentOfLeftLeaves, parentOfRightLeaves);

        PrintBinaryTreeInVeritcalOrder printBinaryTreeInVeritcalOrder = new PrintBinaryTreeInVeritcalOrder();
        for (Map.Entry<Integer, List<Node>> integerListEntry : printBinaryTreeInVeritcalOrder.inorderTreeTaversal(root).entrySet()) {
            for (Node node : integerListEntry.getValue()) {
                System.out.print(node.getData() + " ");
            }
            System.out.println();
        }

    }

    private Map<Integer, List<Node>> inorderTreeTaversal(Node root) {

        if (root == null) {
            return null;
        }
        Map<Integer, List<Node>> mapOfHDAndNodes = new HashMap<>();
        Stack<NodeAndHD> stack = new Stack<>();
        Node currentNode = root;
        int hd = 0;
        List<Node> listOfNodes = new ArrayList<>();
        listOfNodes.add(root);
        mapOfHDAndNodes.put(hd, listOfNodes);
        while (!stack.empty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(new NodeAndHD(hd, currentNode));
                currentNode = currentNode.getLeft();
                hd--;
                List<Node> sameHdNodes;
                if (!mapOfHDAndNodes.containsKey(hd)) {
                    sameHdNodes = new ArrayList<>();
                    mapOfHDAndNodes.put(hd, new ArrayList<>());
                } else {
                    sameHdNodes = mapOfHDAndNodes.get(hd);
                }
                sameHdNodes.add(currentNode);
            } else {
                currentNode = stack.pop().getNode();
                hd = stack.pop().getHd();
                currentNode = currentNode.getRight();
                hd++;
                List<Node> sameHdNodes;
                if (!mapOfHDAndNodes.containsKey(hd)) {
                    sameHdNodes = new ArrayList<>();
                    mapOfHDAndNodes.put(hd, new ArrayList<>());
                } else {
                    sameHdNodes = mapOfHDAndNodes.get(hd);
                }
                sameHdNodes.add(currentNode);
            }
        }
        return mapOfHDAndNodes;
    }

    static class NodeAndHD {
        private int hd;
        private Node node;

        NodeAndHD(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }

        public int getHd() {
            return hd;
        }

        public Node getNode() {
            return node;
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
